package controller;

import dao.MateriaDao;
import java.sql.SQLException;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Materia;

public class MateriaController {

    @FXML private TableView<Materia> tabela;
    @FXML private TableColumn<Materia, Integer> colId;
    @FXML private TableColumn<Materia, String> colNome;
    @FXML private TableColumn<Materia, String> colDescricao;
    @FXML private TextField nome;
    @FXML private TextArea descricao;

    private final MateriaDao dao = new MateriaDao();
    private Materia editando;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(v -> new SimpleObjectProperty<>(v.getValue().getIdMateria()));
        colNome.setCellValueFactory(v -> new SimpleStringProperty(v.getValue().getNome()));
        colDescricao.setCellValueFactory(v -> new SimpleStringProperty(v.getValue().getDescricao()));

        tabela.getSelectionModel().selectedItemProperty().addListener((obs, antiga, selecionada) -> {
            if (selecionada != null) {
                editando = selecionada;
                nome.setText(selecionada.getNome());
                descricao.setText(selecionada.getDescricao());
            }
        });

        carregar();
    }

    private void carregar() {
        try {
            tabela.setItems(FXCollections.observableArrayList(dao.listar()));
        } catch (SQLException e) {
            erro(e);
        }
    }

    @FXML
    private void salvar() {
        if (nome.getText().isBlank()) {
            alert("Informe o nome da matéria.");
            return;
        }

        try {
            String nomeLimpo = nome.getText().trim();
            String descLimpa = descricao.getText() == null ? "" : descricao.getText().trim();

            if (editando == null) {
                dao.inserir(new Materia(0, nomeLimpo, descLimpa));
            } else {
                editando.setNome(nomeLimpo);
                editando.setDescricao(descLimpa);
                dao.atualizar(editando);
            }

            limpar();
            carregar();
        } catch (SQLException e) {
            erro(e);
        }
    }

    @FXML
    private void novo() {
        limpar();
    }

    @FXML
    private void excluir() {
        Materia selecionada = tabela.getSelectionModel().getSelectedItem();
        if (selecionada == null) {
            alert("Selecione uma matéria.");
            return;
        }

        if (confirmar("Excluir matéria? (Não será possível se houver tarefas ou avaliações vinculadas.)")) {
            try {
                dao.excluir(selecionada.getIdMateria());
                carregar();
                limpar();
            } catch (SQLException e) {
                erro(e);
            }
        }
    }

    private void limpar() {
        editando = null;
        nome.clear();
        descricao.clear();
        tabela.getSelectionModel().clearSelection();
    }

    private void erro(Exception e) {
        e.printStackTrace();
        alert("Falha: " + e.getMessage());
    }

    private void alert(String mensagem) {
        new Alert(Alert.AlertType.INFORMATION, mensagem).showAndWait();
    }

    private boolean confirmar(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, mensagem, ButtonType.YES, ButtonType.NO);
        return alert.showAndWait().orElse(ButtonType.NO) == ButtonType.YES;
    }
}