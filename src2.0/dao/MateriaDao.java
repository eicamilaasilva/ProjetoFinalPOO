
package dao;

import model.Materia;
import java.sql.*;
import java.util.*;

/**
 * Responsável pelas operações de acesso e manipulação
 * dos dados de matérias no banco de dados.
 *
 * @author Camila
 * @version 1.0
 */
public class MateriaDao
{
    /**
     * Consulta todas as matérias cadastradas no banco de dados,
     * organizando os resultados pelo nome.
     *
     * @return lista de matérias cadastradas.
     * @throws SQLException caso ocorra um erro na consulta.
     */
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

    /**
     * Insere uma nova matéria no banco de dados.
     *
     * @param m objeto contendo os dados da matéria.
     * @throws SQLException caso ocorra um erro durante a inserção.
     */
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

    /**
     * Atualiza os dados de uma matéria já cadastrada.
     *
     * @param m objeto contendo os dados atualizados da matéria.
     * @throws SQLException caso ocorra um erro durante a atualização.
     */
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

    /**
     * Exclui uma matéria do banco de dados a partir de seu identificador.
     *
     * @param id identificador da matéria que será excluída.
     * @throws SQLException caso ocorra um erro durante a exclusão.
     */
    public void excluir(int id)throws SQLException
    {
        try(Connection c=Conexao.getConnection();PreparedStatement p=c.prepareStatement("DELETE FROM Materia WHERE id_materia=?"))
        {
            p.setInt(1,id);
            p.executeUpdate();
        }
    }
}
