package controller;

import dao.ConsultaPersonalizadaDao;
import dao.MateriaDao;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.ConsultaDesempenhoMateria;
import model.ConsultaPendenciasMateria;
import model.Materia;

import java.sql.SQLException;

/**
 * Controlador da tela de consultas personalizadas do FocusUp.
 * Atualiza as tabelas de pendências e desempenho acadêmico por matéria.
 *
 * @author Fernanda
 * @version 1.0
 */
public class ConsultasController {
    @FXML private ComboBox<Materia> cmbFiltroMateria;
    @FXML private TableView<ConsultaPendenciasMateria> tblPendenciasMateria;
    @FXML private TableColumn<ConsultaPendenciasMateria, String> colPendMateria;
    @FXML private TableColumn<ConsultaPendenciasMateria, Integer> colPendQuantidade;
    @FXML private TableColumn<ConsultaPendenciasMateria, Integer> colPendAtrasadas;
    @FXML private TableColumn<ConsultaPendenciasMateria, String> colPendProximaEntrega;

    @FXML private TableView<ConsultaDesempenhoMateria> tblDesempenhoMateria;
    @FXML private TableColumn<ConsultaDesempenhoMateria, String> colDesempenhoMateria;
    @FXML private TableColumn<ConsultaDesempenhoMateria, Integer> colDesempenhoQuantidade;
    @FXML private TableColumn<ConsultaDesempenhoMateria, java.math.BigDecimal> colDesempenhoMedia;
    @FXML private TableColumn<ConsultaDesempenhoMateria, java.math.BigDecimal> colDesempenhoMaiorNota;
    @FXML private TableColumn<ConsultaDesempenhoMateria, java.math.BigDecimal> colDesempenhoMenorNota;

    private final ConsultaPersonalizadaDao consultaDao = new ConsultaPersonalizadaDao();

    /** Inicializa os componentes e carrega as consultas. */
    @FXML public void initialize() {
        configurarColunas();
        carregarMaterias();
        consultarPendenciasMateria();
        consultarDesempenhoMateria();
    }

    private void configurarColunas() {
        colPendMateria.setCellValueFactory(new PropertyValueFactory<>("materia"));
        colPendQuantidade.setCellValueFactory(new PropertyValueFactory<>("pendentes"));
        colPendAtrasadas.setCellValueFactory(new PropertyValueFactory<>("atrasadas"));
        colPendProximaEntrega.setCellValueFactory(new PropertyValueFactory<>("proximaEntrega"));

        colDesempenhoMateria.setCellValueFactory(new PropertyValueFactory<>("materia"));
        colDesempenhoQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        colDesempenhoMedia.setCellValueFactory(new PropertyValueFactory<>("media"));
        colDesempenhoMaiorNota.setCellValueFactory(new PropertyValueFactory<>("maiorNota"));
        colDesempenhoMenorNota.setCellValueFactory(new PropertyValueFactory<>("menorNota"));
    }

    private void carregarMaterias() {
        try {
            cmbFiltroMateria.setItems(FXCollections.observableArrayList(new MateriaDao().listar()));
        } catch (SQLException e) {
            mostrarErro("Não foi possível carregar as matérias.", e);
        }
    }

    /** Executa a consulta de pendências, aplicando o filtro de matéria selecionado. */
    @FXML private void consultarPendenciasMateria() {
        try {
            Integer filtro = cmbFiltroMateria.getValue() == null ? null : cmbFiltroMateria.getValue().getIdMateria();
            tblPendenciasMateria.setItems(FXCollections.observableArrayList(
                    consultaDao.consultarPendenciasPorMateria(filtro)));
        } catch (SQLException e) {
            mostrarErro("Não foi possível consultar as pendências por matéria.", e);
        }
    }

    /** Executa a consulta de desempenho, aplicando o filtro de matéria selecionado. */
    @FXML private void consultarDesempenhoMateria() {
        try {
            Integer filtro = cmbFiltroMateria.getValue() == null ? null : cmbFiltroMateria.getValue().getIdMateria();
            tblDesempenhoMateria.setItems(FXCollections.observableArrayList(
                    consultaDao.consultarDesempenhoPorMateria(filtro)));
        } catch (SQLException e) {
            mostrarErro("Não foi possível consultar o desempenho por matéria.", e);
        }
    }

    /** Aplica o filtro selecionado às duas consultas. */
    @FXML private void aplicarFiltro() {
        consultarPendenciasMateria();
        consultarDesempenhoMateria();
    }

    /** Limpa o filtro e atualiza ambas as consultas para todas as matérias. */
    @FXML private void mostrarTodas() {
        cmbFiltroMateria.setValue(null);
        consultarPendenciasMateria();
        consultarDesempenhoMateria();
    }

    private void mostrarErro(String mensagem, Exception e) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("FocusUp - Consultas");
        alerta.setHeaderText(mensagem);
        alerta.setContentText(e.getMessage());
        alerta.showAndWait();
    }
}
