package controller;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import dao.*;
import java.sql.SQLException;
public class RelatorioController
{
    @FXML private TextArea resultado;
    private final TarefaDao td=new TarefaDao();
    private final AvaliacaoDao ad=new AvaliacaoDao();
    @FXML private void tarefas()
    {
        try
        {
            StringBuilder s=new StringBuilder("TAREFAS");
            for(var t:td.listar())s.append(t.getDataEntrega()).append(" | ").append(t.getMateria()).append(" | ").append(t.getTitulo()).append(" | ").append(t.getStatus()).append(" | ").append(t.getPrioridade()).append("");
            resultado.setText(s.toString());
        }
        catch(SQLException e)
        {
            resultado.setText(e.getMessage());
        }
    }
    @FXML private void desempenho()
    {
        try
        {
            StringBuilder s=new StringBuilder("DESEMPENHO POR MATÉRIA");
            for(var r:ad.desempenhoPorMateria())s.append(r.get("materia")).append(" | Avaliações: ").append(r.get("qtd")).append(" | ").append(r.get("pontos")).append('/').append(r.get("maximo")).append(" | Aproveitamento: ").append(r.get("aproveitamento")).append("");
            resultado.setText(s.toString());
        }
        catch(SQLException e)
        {
            resultado.setText(e.getMessage());
        }
    }
}
