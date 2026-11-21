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

public class MainController{
	@FXML private AnchorPane root;
	private final RelatorioService relatorioService = new RelatorioService();
	
    @FXML public void initialize()
    {
        abrir("HomeView.fxml");
    }
    @FXML public void home()
    {
        abrir("HomeView.fxml");
    }
    @FXML
	void fechar(ActionEvent event) {
		System.exit(0);
	}
    @FXML public void materias()
    {
        abrir("MateriaView.fxml");
    }
    @FXML public void tarefas()
    {
        abrir("TarefaView.fxml");
    }
    @FXML public void avaliacoes()
    {
        abrir("AvaliacaoView.fxml");
    }
    @FXML public void ajuda()
    {
        abrir("SobreView.fxml");
    }
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
    @FXML
    void relatorios(ActionEvent event) throws JRException, IOException, SQLException {
        relatorioService.gerarRelatorioAtualizado(
                "/relatorios/RelatórioTarefa.jrxml",
                "C:/Users/Public/RelatórioTarefas.pdf"
        );
    }

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

    private void mostrarErroRelatorio(String mensagem, Exception e)
    {
    	Alert alerta = new Alert(Alert.AlertType.ERROR);

    	alerta.setTitle("FocusUp - Relatórios");
    	alerta.setHeaderText(mensagem);
    	alerta.setContentText(e.getMessage());

    	alerta.showAndWait();
    }

    
}
