package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ConsultaDesempenhoMateria;
import model.ConsultaPendenciasMateria;

/**
 * Executa consultas personalizadas que relacionam e agregam informações
 * de matérias, tarefas e avaliações.
 *
 * @author Camila
 * @version 1.0
 */
public class ConsultaPersonalizadaDao {

    /**
     * Consulta indicadores de tarefas por matéria: pendentes, atrasadas
     * e a próxima data de entrega. Um filtro de matéria é opcional.
     *
     * @param idMateria identificador da matéria, ou null para todas.
     * @return lista de indicadores agrupados por matéria.
     * @throws SQLException caso ocorra erro na consulta.
     */
    public List<ConsultaPendenciasMateria> consultarPendenciasPorMateria(Integer idMateria) throws SQLException {
        String sql = "SELECT m.nome AS materia, "
                + "SUM(CASE WHEN t.id_tarefa IS NOT NULL AND t.status <> 'Concluida' THEN 1 ELSE 0 END) AS pendentes, "
                + "SUM(CASE WHEN t.id_tarefa IS NOT NULL AND t.status <> 'Concluida' AND t.data_entrega < CURDATE() THEN 1 ELSE 0 END) AS atrasadas, "
                + "MIN(CASE WHEN t.id_tarefa IS NOT NULL AND t.status <> 'Concluida' AND t.data_entrega >= CURDATE() THEN t.data_entrega ELSE NULL END) AS proxima_entrega "
                + "FROM Materia m LEFT JOIN Tarefa t ON t.id_materia = m.id_materia "
                + (idMateria != null ? "WHERE m.id_materia = ? " : "")
                + "GROUP BY m.id_materia, m.nome ORDER BY atrasadas DESC, pendentes DESC, m.nome";
        List<ConsultaPendenciasMateria> resultados = new ArrayList<>();
        try (Connection conexao = Conexao.getConnection();
             PreparedStatement comando = conexao.prepareStatement(sql)) {
            if (idMateria != null) comando.setInt(1, idMateria);
            try (ResultSet rs = comando.executeQuery()) {
                while (rs.next()) {
                    ConsultaPendenciasMateria item = new ConsultaPendenciasMateria();
                    item.setMateria(rs.getString("materia"));
                    item.setPendentes(rs.getInt("pendentes"));
                    item.setAtrasadas(rs.getInt("atrasadas"));
                    java.sql.Date data = rs.getDate("proxima_entrega");
                    item.setProximaEntrega(data == null ? "Sem entrega futura" : data.toLocalDate().toString());
                    resultados.add(item);
                }
            }
        }
        return resultados;
    }

    /**
     * Consulta quantidade, média, maior e menor nota por matéria,
     * considerando somente avaliações que já possuem nota.
     *
     * @param idMateria identificador da matéria, ou null para todas.
     * @return lista de indicadores de desempenho por matéria.
     * @throws SQLException caso ocorra erro na consulta.
     */
    public List<ConsultaDesempenhoMateria> consultarDesempenhoPorMateria(Integer idMateria) throws SQLException {
        String sql = "SELECT m.nome AS materia, COUNT(a.id_avaliacao) AS quantidade, "
                + "ROUND(AVG(a.nota), 2) AS media, MAX(a.nota) AS maior_nota, MIN(a.nota) AS menor_nota "
                + "FROM Materia m LEFT JOIN Avaliacao a ON a.id_materia = m.id_materia AND a.nota IS NOT NULL "
                + (idMateria != null ? "WHERE m.id_materia = ? " : "")
                + "GROUP BY m.id_materia, m.nome ORDER BY media DESC, m.nome";
        List<ConsultaDesempenhoMateria> resultados = new ArrayList<>();
        try (Connection conexao = Conexao.getConnection();
             PreparedStatement comando = conexao.prepareStatement(sql)) {
            if (idMateria != null) comando.setInt(1, idMateria);
            try (ResultSet rs = comando.executeQuery()) {
                while (rs.next()) {
                    ConsultaDesempenhoMateria item = new ConsultaDesempenhoMateria();
                    item.setMateria(rs.getString("materia"));
                    item.setQuantidade(rs.getInt("quantidade"));
                    item.setMedia(rs.getBigDecimal("media"));
                    item.setMaiorNota(rs.getBigDecimal("maior_nota"));
                    item.setMenorNota(rs.getBigDecimal("menor_nota"));
                    resultados.add(item);
                }
            }
        }
        return resultados;
    }
}
