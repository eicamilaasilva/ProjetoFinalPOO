package dao;
import model.Materia;
import java.sql.*;
import java.util.*;
public class MateriaDao
{
    public List<Materia> listar() throws SQLException
    {
        List<Materia> l=new ArrayList<>();
        String sql="SELECT * FROM Materia ORDER BY nome";
        try(Connection c=Conexao.getConnection();PreparedStatement p=c.prepareStatement(sql);ResultSet r=p.executeQuery())
        {
            while(r.next())l.add(new Materia(r.getInt("id_materia"),r.getString("nome"),r.getString("descricao")));
        }
        return l;
    }
    public void inserir(Materia m)throws SQLException
    {
        String s="INSERT INTO Materia(nome,descricao) VALUES(?,?)";
        try(Connection c=Conexao.getConnection();PreparedStatement p=c.prepareStatement(s))
        {
            p.setString(1,m.getNome());
            p.setString(2,m.getDescricao());
            p.executeUpdate();
        }
    }
    public void atualizar(Materia m)throws SQLException
    {
        String s="UPDATE Materia SET nome=?,descricao=? WHERE id_materia=?";
        try(Connection c=Conexao.getConnection();PreparedStatement p=c.prepareStatement(s))
        {
            p.setString(1,m.getNome());
            p.setString(2,m.getDescricao());
            p.setInt(3,m.getIdMateria());
            p.executeUpdate();
        }
    }
    public void excluir(int id)throws SQLException
    {
        try(Connection c=Conexao.getConnection();PreparedStatement p=c.prepareStatement("DELETE FROM Materia WHERE id_materia=?"))
        {
            p.setInt(1,id);
            p.executeUpdate();
        }
    }
}
