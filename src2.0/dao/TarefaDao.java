
package dao;

import model.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * Responsável pelas operações de acesso e manipulação
 * dos dados de tarefas no banco de dados.
 *
 * @author Camila
 * @version 1.0
 */
public class TarefaDao
{
    /**
     * Recupera os dados da matéria associada a uma tarefa.
     *
     * @param r resultado da consulta SQL.
     * @return objeto Materia correspondente aos dados consultados.
     * @throws SQLException caso ocorra um erro na leitura dos dados.
     */
    private Materia lerMateria(ResultSet r)throws SQLException
    {
        return new Materia(r.getInt("id_materia"),r.getString("materia"),null);
    }

    private static final String BASE="SELECT t.*,m.nome AS materia FROM Tarefa t JOIN Materia m ON m.id_materia=t.id_materia";

    /**
     * Consulta todas as tarefas cadastradas, organizadas pela data de entrega.
     *
     * @return lista de tarefas cadastradas.
     * @throws SQLException caso ocorra um erro na consulta.
     */
    public List<Tarefa> listar()throws SQLException
    {
        List<Tarefa> l=new ArrayList<>();
        try(Connection c=Conexao.getConnection();PreparedStatement p=c.prepareStatement(BASE+" ORDER BY data_entrega");ResultSet r=p.executeQuery())
        {
            while(r.next())l.add(map(r));
        }
        return l;
    }

    /**
     * Converte uma linha do resultado SQL em um objeto Tarefa.
     *
     * @param r resultado da consulta SQL.
     * @return objeto Tarefa preenchido com os dados do banco.
     * @throws SQLException caso ocorra um erro na leitura dos dados.
     */
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

    /**
     * Insere uma nova tarefa no banco de dados.
     *
     * @param t objeto contendo os dados da tarefa.
     * @throws SQLException caso ocorra um erro durante a inserção.
     */
    public void inserir(Tarefa t)throws SQLException
    {
        String s="INSERT INTO Tarefa(id_materia,titulo,descricao,data_entrega,status,prioridade) VALUES(?,?,?,?,?,?)";
        try(Connection c=Conexao.getConnection();PreparedStatement p=c.prepareStatement(s))
        {
            bind(p,t);
            p.executeUpdate();
        }
    }

    /**
     * Atualiza os dados de uma tarefa já cadastrada.
     *
     * @param t objeto contendo os dados atualizados da tarefa.
     * @throws SQLException caso ocorra um erro durante a atualização.
     */
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

    /**
     * Define os parâmetros utilizados nas instruções SQL de inserção e atualização.
     *
     * @param p comando SQL preparado.
     * @param t tarefa cujos dados serão associados ao comando.
     * @throws SQLException caso ocorra um erro ao definir os parâmetros.
     */
    private void bind(PreparedStatement p,Tarefa t)throws SQLException
    {
        p.setInt(1,t.getMateria().getIdMateria());
        p.setString(2,t.getTitulo());
        p.setString(3,t.getDescricao());
        p.setDate(4,Date.valueOf(t.getDataEntrega()));
        p.setString(5,t.getStatus());
        p.setString(6,t.getPrioridade());
    }

    /**
     * Exclui uma tarefa do banco de dados a partir de seu identificador.
     *
     * @param id identificador da tarefa que será excluída.
     * @throws SQLException caso ocorra um erro durante a exclusão.
     */
    public void excluir(int id)throws SQLException
    {
        try(Connection c=Conexao.getConnection();PreparedStatement p=c.prepareStatement("DELETE FROM Tarefa WHERE id_tarefa=?"))
        {
            p.setInt(1,id);
            p.executeUpdate();
        }
    }

    /**
     * Consulta as tarefas que ainda não foram concluídas,
     * organizando os resultados pela data de entrega.
     *
     * @return lista de tarefas pendentes ou em andamento.
     * @throws SQLException caso ocorra um erro na consulta.
     */
    public List<Tarefa> buscarPendentes()throws SQLException
    {
        List<Tarefa> l=new ArrayList<>();
        try(Connection c=Conexao.getConnection();PreparedStatement p=c.prepareStatement(BASE+" WHERE t.status <> 'Concluida' ORDER BY t.data_entrega");ResultSet r=p.executeQuery())
        {
            while(r.next())l.add(map(r));
        }
        return l;
    }

    /**
     * Consulta as tarefas vinculadas a uma matéria específica.
     *
     * @param idMateria identificador da matéria utilizada como filtro.
     * @return lista de tarefas associadas à matéria informada.
     * @throws SQLException caso ocorra um erro na consulta.
     */
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
