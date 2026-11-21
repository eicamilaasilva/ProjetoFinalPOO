package dao;
import model.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;
public class TarefaDao
{
    private Materia lerMateria(ResultSet r)throws SQLException
    {
        return new Materia(r.getInt("id_materia"),r.getString("materia"),null);
    }
    private static final String BASE="SELECT t.*,m.nome AS materia FROM Tarefa t JOIN Materia m ON m.id_materia=t.id_materia";
    public List<Tarefa> listar()throws SQLException
    {
        List<Tarefa> l=new ArrayList<>();
        try(Connection c=Conexao.getConnection();PreparedStatement p=c.prepareStatement(BASE+" ORDER BY data_entrega");ResultSet r=p.executeQuery())
        {
            while(r.next())l.add(map(r));
        }
        return l;
    }
    private Tarefa map(ResultSet r)throws SQLException
    {
        Tarefa t=new Tarefa();
        t.setIdTarefa(r.getInt("id_tarefa"));
        t.setMateria(new Materia(r.getInt("id_materia"),r.getString("materia"),null));
        t.setTitulo(r.getString("titulo"));
        t.setDescricao(r.getString("descricao"));
        t.setDataEntrega(r.getDate("data_entrega").toLocalDate());
        t.setStatus(r.getString("status"));
        t.setPrioridade(r.getString("prioridade"));
        return t;
    }
    public void inserir(Tarefa t)throws SQLException
    {
        String s="INSERT INTO Tarefa(id_materia,titulo,descricao,data_entrega,status,prioridade) VALUES(?,?,?,?,?,?)";
        try(Connection c=Conexao.getConnection();PreparedStatement p=c.prepareStatement(s))
        {
            bind(p,t);
            p.executeUpdate();
        }
    }
    public void atualizar(Tarefa t)throws SQLException
    {
        String s="UPDATE Tarefa SET id_materia=?,titulo=?,descricao=?,data_entrega=?,status=?,prioridade=? WHERE id_tarefa=?";
        try(Connection c=Conexao.getConnection();PreparedStatement p=c.prepareStatement(s))
        {
            bind(p,t);
            p.setInt(7,t.getIdTarefa());
            p.executeUpdate();
        }
    }
    private void bind(PreparedStatement p,Tarefa t)throws SQLException
    {
        p.setInt(1,t.getMateria().getIdMateria());
        p.setString(2,t.getTitulo());
        p.setString(3,t.getDescricao());
        p.setDate(4,Date.valueOf(t.getDataEntrega()));
        p.setString(5,t.getStatus());
        p.setString(6,t.getPrioridade());
    }
    public void excluir(int id)throws SQLException
    {
        try(Connection c=Conexao.getConnection();PreparedStatement p=c.prepareStatement("DELETE FROM Tarefa WHERE id_tarefa=?"))
        {
            p.setInt(1,id);
            p.executeUpdate();
        }
    }
    public List<Tarefa> buscarPendentes()throws SQLException
    {
        List<Tarefa> l=new ArrayList<>();
        try(Connection c=Conexao.getConnection();PreparedStatement p=c.prepareStatement(BASE+" WHERE t.status <> 'Concluida' ORDER BY t.data_entrega");ResultSet r=p.executeQuery())
        {
            while(r.next())l.add(map(r));
        }
        return l;
    }
    public List<Tarefa> buscarPorMateria(int idMateria)throws SQLException
    {
        List<Tarefa> l=new ArrayList<>();
        try(Connection c=Conexao.getConnection();PreparedStatement p=c.prepareStatement(BASE+" WHERE t.id_materia=? ORDER BY t.data_entrega"))
        {
            p.setInt(1,idMateria);
            try(ResultSet r=p.executeQuery())
            {
                while(r.next())l.add(map(r));
            }
        }
        return l;
    }
}
