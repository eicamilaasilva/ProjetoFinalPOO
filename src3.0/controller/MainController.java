
package controller;

import javafx.event.ActionEvent;
import net.sf.jasperreports.engine.JasperCompileManager;
import service.RelatorioService;

import javafx.scene.control.Alert;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import dao.Conexao;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

/**
 * Controlador principal da aplicação FocusUp.
 * Gerencia a navegação entre as telas do sistema,
 * o encerramento da aplicação e a solicitação de geração
 * dos relatórios de tarefas e de desempenho.
 *
 * @author Fernanda
 * @version 1.0
 */
public class MainController{
    @FXML private AnchorPane root;
    private final RelatorioService relatorioService = new RelatorioService();

    /**
     * Inicializa a tela principal e carrega a tela inicial do sistema.
     */
    @FXML public void initialize()
    {
        abrir("HomeView.fxml");
    }

    /**
     * Retorna à tela inicial da aplicação.
     */
    @FXML public void home()
    {
        abrir("HomeView.fxml");
    }

    /**
     * Encerra a execução da aplicação.
     *
     * @param event evento de ação que acionou o encerramento.
     */
    @FXML
    void fechar(ActionEvent event) {
        System.exit(0);
    }

    /**
     * Abre a tela de gerenciamento de matérias.
     */
    @FXML public void materias()
    {
        abrir("MateriaView.fxml");
    }

    /**
     * Abre a tela de gerenciamento de tarefas.
     */
    @FXML public void tarefas()
    {
        abrir("TarefaView.fxml");
    }

    /**
     * Abre a tela de gerenciamento de avaliações.
     */
    @FXML public void avaliacoes()
    {
        abrir("AvaliacaoView.fxml");
    }

    /**
     * Abre a tela de ajuda e informações sobre o sistema.
     */
    @FXML public void ajuda()
    {
        abrir("SobreView.fxml");
    }

    /**
     * Abre a tela de consultas personalizadas.
     */
    @FXML public void consultas() {
        abrir("ConsultasView.fxml");
    }

    /**
     * Carrega uma tela FXML e a insere no painel principal da aplicação.
     *
     * @param fxml nome do arquivo FXML que será carregado.
     */
    private void abrir(String fxml) {
        try {
            var url = getClass().getResource("/view/" + fxml);

            if (url == null) {
                System.err.println("FXML não encontrado: /view/" + fxml);
                return;
            }

            Parent tela = FXMLLoader.load(url);
            root.getChildren().setAll(tela);
            AnchorPane.setTopAnchor(tela, 0.0);
            AnchorPane.setBottomAnchor(tela, 0.0);
            AnchorPane.setLeftAnchor(tela, 0.0);
            AnchorPane.setRightAnchor(tela, 0.0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //@FXML
    /*private void relatorios()
    {
        try
        {
            RelatorioService.gerarRelatorioTarefas();
        }
        catch (JRException | SQLException | IOException e)
        {
            mostrarErroRelatorio("Não foi possível gerar o relatório de tarefas.", e);
        }
    }*/

    /**
     * Solicita a geração do relatório de tarefas em PDF.
     *
     * @param event evento de ação que acionou a geração do relatório.
     * @throws JRException caso ocorra um erro no processamento do relatório.
     * @throws IOException caso ocorra um erro de entrada ou saída.
     * @throws SQLException caso ocorra um erro na conexão com o banco.
     */
    @FXML
    void relatorios(ActionEvent event) throws JRException, IOException, SQLException {
        relatorioService.gerarRelatorioAtualizado(
                "/relatorios/RelatórioTarefa.jrxml",
                "C:/Users/Public/RelatórioTarefas.pdf"
        );
    }

    /**
     * Solicita a geração do relatório de desempenho em PDF.
     *
     * @param event evento de ação que acionou a geração do relatório.
     * @throws JRException caso ocorra um erro no processamento do relatório.
     * @throws IOException caso ocorra um erro de entrada ou saída.
     * @throws SQLException caso ocorra um erro na conexão com o banco.
     */
    @FXML
    void relatorioD(ActionEvent event) throws JRException, IOException, SQLException {
        relatorioService.gerarRelatorioAtualizado(
                "/relatorios/RelatórioDesempenho.jrxml",
                "C:/Users/Public/RelatórioDesempenho.pdf"
        );
    }

    /*@FXML
    private void relatorioD()
    {
        try
        {
            RelatorioService.gerarRelatorioDesempenho();
        }
        catch (JRException | SQLException | IOException e)
        {
            mostrarErroRelatorio("Não foi possível gerar o relatório de desempenho.", e);
        }
    }*/

    /**
     * Exibe uma janela de erro relacionada à geração de relatórios.
     *
     * @param mensagem descrição do erro que será apresentada.
     * @param e exceção responsável pelo erro.
     */
    private void mostrarErroRelatorio(String mensagem, Exception e)
    {
        Alert alerta = new Alert(Alert.AlertType.ERROR);

        alerta.setTitle("FocusUp - Relatórios");
        alerta.setHeaderText(mensagem);
        alerta.setContentText(e.getMessage());

        alerta.showAndWait();
    }
}
