
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

/**
 * Controlador responsável pela tela de gerenciamento de matérias.
 * Realiza o cadastro, a consulta, a alteração e a exclusão
 * de matérias no sistema FocusUp.
 *
 * @author Fernanda
 * @version 1.0
 */
public class MateriaController {

    @FXML private TableView<Materia> tabela;
    @FXML private TableColumn<Materia, Integer> colId;
    @FXML private TableColumn<Materia, String> colNome;
    @FXML private TableColumn<Materia, String> colDescricao;
    @FXML private TextField nome;
    @FXML private TextArea descricao;

    private final MateriaDao dao = new MateriaDao();
    private Materia editando;

    /**
     * Inicializa os componentes da tela, configura as colunas
     * da tabela, registra a seleção de matérias e carrega os dados.
     */
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

    /**
     * Consulta as matérias no banco de dados e atualiza a tabela.
     * Em caso de erro, apresenta uma mensagem ao usuário.
     */
    private void carregar() {
        try {
            tabela.setItems(FXCollections.observableArrayList(dao.listar()));
        } catch (SQLException e) {
            erro(e);
        }
    }

    /**
     * Cadastra uma nova matéria ou atualiza a matéria selecionada.
     * Verifica se o nome foi informado antes de realizar a operação.
     */
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

    /**
     * Prepara o formulário para o cadastro de uma nova matéria,
     * limpando os campos e a seleção atual.
     */
    @FXML
    private void novo() {
        limpar();
    }

    /**
     * Exclui a matéria selecionada após a confirmação do usuário.
     * Atualiza a tabela e limpa o formulário após a exclusão.
     */
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

    /**
     * Limpa os campos do formulário e remove a seleção da tabela.
     */
    private void limpar() {
        editando = null;
        nome.clear();
        descricao.clear();
        tabela.getSelectionModel().clearSelection();
    }

    /**
     * Registra o erro no console e apresenta uma mensagem ao usuário.
     *
     * @param e exceção ocorrida durante a operação.
     */
    private void erro(Exception e) {
        e.printStackTrace();
        alert("Falha: " + e.getMessage());
    }

    /**
     * Exibe uma mensagem informativa na tela.
     *
     * @param mensagem texto que será apresentado ao usuário.
     */
    private void alert(String mensagem) {
        new Alert(Alert.AlertType.INFORMATION, mensagem).showAndWait();
    }

    /**
     * Solicita a confirmação do usuário antes de executar uma operação.
     *
     * @param mensagem texto apresentado na janela de confirmação.
     * @return true caso o usuário confirme a operação; false caso contrário.
     */
    private boolean confirmar(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, mensagem, ButtonType.YES, ButtonType.NO);
        return alert.showAndWait().orElse(ButtonType.NO) == ButtonType.YES;
    }
}
