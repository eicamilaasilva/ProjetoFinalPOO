package dao;
import model.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.math.BigDecimal;
public class AvaliacaoDao
{
    private static final String BASE="SELECT a.*,m.nome AS materia FROM Avaliacao a JOIN Materia m ON m.id_materia=a.id_materia";
    private Avaliacao map(ResultSet r)throws SQLException
    {
        Avaliacao a=new Avaliacao();
        a.setIdAvaliacao(r.getInt("id_avaliacao"));
        a.setMateria(new Materia(r.getInt("id_materia"),r.getString("materia"),null));
        a.setTitulo(r.getString("titulo"));
        a.setDataAvaliacao(r.getDate("data_avaliacao").toLocalDate());
        a.setNota(r.getBigDecimal("nota"));
        a.setValorMaximo(r.getBigDecimal("valor_maximo"));
        return a;
    }
    public List<Avaliacao> listar()throws SQLException
    {
        List<Avaliacao> l=new ArrayList<>();
        try(Connection c=Conexao.getConnection();PreparedStatement p=c.prepareStatement(BASE+" ORDER BY data_avaliacao");ResultSet r=p.executeQuery())
        {
            while(r.next())l.add(map(r));
        }
        return l;
    }
    public void inserir(Avaliacao a)throws SQLException
    {
        String s="INSERT INTO Avaliacao(id_materia,titulo,data_avaliacao,nota,valor_maximo) VALUES(?,?,?,?,?)";
        try(Connection c=Conexao.getConnection();PreparedStatement p=c.prepareStatement(s))
        {
            bind(p,a);
            p.executeUpdate();
        }
    }
    public void atualizar(Avaliacao a)throws SQLException
    {
        String s="UPDATE Avaliacao SET id_materia=?,titulo=?,data_avaliacao=?,nota=?,valor_maximo=? WHERE id_avaliacao=?";
        try(Connection c=Conexao.getConnection();PreparedStatement p=c.prepareStatement(s))
        {
            bind(p,a);
            p.setInt(6,a.getIdAvaliacao());
            p.executeUpdate();
        }
    }
    private void bind(PreparedStatement p,Avaliacao a)throws SQLException
    {
        p.setInt(1,a.getMateria().getIdMateria());
        p.setString(2,a.getTitulo());
        p.setDate(3,Date.valueOf(a.getDataAvaliacao()));
        p.setBigDecimal(4,a.getNota());
        p.setBigDecimal(5,a.getValorMaximo());
    }
    public void excluir(int id)throws SQLException
    {
        try(Connection c=Conexao.getConnection();PreparedStatement p=c.prepareStatement("DELETE FROM Avaliacao WHERE id_avaliacao=?"))
        {
            p.setInt(1,id);
            p.executeUpdate();
        }
    }
    public List<Map<String,Object>> desempenhoPorMateria()throws SQLException
    {
        String sql="SELECT m.nome materia,COUNT(a.id_avaliacao) qtd,COALESCE(SUM(a.nota),0) pontos,COALESCE(SUM(a.valor_maximo),0) maximo,CASE WHEN COALESCE(SUM(a.valor_maximo),0)>0 THEN ROUND(SUM(a.nota)/SUM(a.valor_maximo)*100,2) ELSE 0 END aproveitamento FROM Materia m LEFT JOIN Avaliacao a ON m.id_materia=a.id_materia AND a.nota IS NOT NULL GROUP BY m.id_materia,m.nome ORDER BY aproveitamento DESC";
        List<Map<String,Object>> out=new ArrayList<>();
        try(Connection c=Conexao.getConnection();PreparedStatement p=c.prepareStatement(sql);ResultSet r=p.executeQuery())
        {
            while(r.next())
            {
                Map<String,Object> x=new LinkedHashMap<>();
                x.put("materia",r.getString("materia"));
                x.put("qtd",r.getInt("qtd"));
                x.put("pontos",r.getBigDecimal("pontos"));
                x.put("maximo",r.getBigDecimal("maximo"));
                x.put("aproveitamento",r.getBigDecimal("aproveitamento"));
                out.add(x);
            }
        }
        return out;
    }
}
