
package controller;

import dao.*;
import model.*;
import javafx.fxml.FXML;
import javafx.collections.*;
import javafx.scene.control.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 * Controlador responsável pela tela de gerenciamento de tarefas.
 * Permite cadastrar, consultar, alterar e excluir tarefas,
 * além de associá-las às matérias cadastradas.
 *
 * @author Fernanda
 * @version 1.0
 */
public class TarefaController
{
    @FXML private TableView<Tarefa> tabela;
    @FXML private TableColumn<Tarefa,String> cTitulo,cMateria,cStatus,cPrioridade;
    @FXML private TableColumn<Tarefa,LocalDate> cData;
    @FXML private ComboBox<Materia> materia;
    @FXML private TextField titulo;
    @FXML private TextArea descricao;
    @FXML private DatePicker data;
    @FXML private ComboBox<String> status,prioridade;

    private final TarefaDao dao=new TarefaDao();
    private final MateriaDao md=new MateriaDao();
    private Tarefa editando;

    /**
     * Inicializa a tela, configura as colunas da tabela,
     * carrega as opções de status, prioridade e matérias
     * e registra a seleção de tarefas.
     */
    @FXML public void initialize()
    {
        cTitulo.setCellValueFactory(v->new javafx.beans.property.SimpleStringProperty(v.getValue().getTitulo()));
        cMateria.setCellValueFactory(v->new javafx.beans.property.SimpleStringProperty(v.getValue().getMateria().getNome()));
        cStatus.setCellValueFactory(v->new javafx.beans.property.SimpleStringProperty(v.getValue().getStatus()));
        cPrioridade.setCellValueFactory(v->new javafx.beans.property.SimpleStringProperty(v.getValue().getPrioridade()));
        cData.setCellValueFactory(v->new javafx.beans.property.SimpleObjectProperty<>(v.getValue().getDataEntrega()));

        status.getItems().addAll("Pendente","Em andamento","Concluida");
        prioridade.getItems().addAll("Baixa","Media","Alta");
        status.setValue("Pendente");
        prioridade.setValue("Media");

        try
        {
            materia.setItems(FXCollections.observableArrayList(md.listar()));
        }
        catch(SQLException e)
        {
            erro(e);
        }

        tabela.getSelectionModel().selectedItemProperty().addListener((o,a,b)->
        {
            if(b!=null)
            {
                editando=b;
                materia.setValue(b.getMateria());
                titulo.setText(b.getTitulo());
                descricao.setText(b.getDescricao());
                data.setValue(b.getDataEntrega());
                status.setValue(b.getStatus());
                prioridade.setValue(b.getPrioridade());
            }
        });

        carregar();
    }

    /**
     * Consulta as tarefas cadastradas e atualiza a tabela.
     * Apresenta uma mensagem caso ocorra algum erro.
     */
    private void carregar()
    {
        try
        {
            tabela.setItems(FXCollections.observableArrayList(dao.listar()));
        }
        catch(SQLException e)
        {
            erro(e);
        }
    }

    /**
     * Cadastra uma nova tarefa ou atualiza a tarefa selecionada.
     * Verifica o preenchimento dos campos obrigatórios antes de salvar.
     */
    @FXML private void salvar()
    {
        if(materia.getValue()==null||titulo.getText().isBlank()||data.getValue()==null)
        {
            alert("Preencha matéria, título e data.");
            return;
        }

        Tarefa t=editando==null?new Tarefa():editando;
        t.setMateria(materia.getValue());
        t.setTitulo(titulo.getText().trim());
        t.setDescricao(descricao.getText());
        t.setDataEntrega(data.getValue());
        t.setStatus(status.getValue());
        t.setPrioridade(prioridade.getValue());

        try
        {
            if(editando==null)dao.inserir(t);
            else dao.atualizar(t);

            limpar();
            carregar();
        }
        catch(SQLException e)
        {
            erro(e);
        }
    }

    /**
     * Prepara o formulário para o cadastro de uma nova tarefa.
     */
    @FXML private void novo()
    {
        limpar();
    }

    /**
     * Exclui a tarefa selecionada após a confirmação do usuário.
     * Atualiza a tabela e limpa o formulário após a operação.
     */
    @FXML private void excluir()
    {
        Tarefa t=tabela.getSelectionModel().getSelectedItem();

        if(t==null)
        {
            alert("Selecione uma tarefa.");
            return;
        }

        if(confirmar("Excluir tarefa?"))
        {
            try
            {
                dao.excluir(t.getIdTarefa());
                carregar();
                limpar();
            }
            catch(SQLException e)
            {
                erro(e);
            }
        }
    }

    /**
     * Atualiza as opções de matérias disponíveis no campo de seleção,
     * preservando a matéria selecionada quando possível.
     */
    @FXML
    private void carregarMaterias() {
        try {
            List<Materia> materias = new MateriaDao().listar();

            // Exemplo usando ComboBox<Materia> chamado comboMateria:
            Materia selecionada = materia.getSelectionModel().getSelectedItem();

            materia.setItems(FXCollections.observableArrayList(materias));

            if (selecionada != null) {
                materia.getSelectionModel().select(selecionada);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Limpa os campos do formulário, restaura os valores padrão
     * de status e prioridade e remove a seleção da tabela.
     */
    private void limpar()
    {
        editando=null;
        titulo.clear();
        descricao.clear();
        data.setValue(null);
        status.setValue("Pendente");
        prioridade.setValue("Media");
        materia.setValue(null);
        tabela.getSelectionModel().clearSelection();
    }

    /**
     * Apresenta uma mensagem de erro ao usuário.
     *
     * @param e exceção ocorrida durante a operação.
     */
    private void erro(Exception e)
    {
        alert("Erro: "+e.getMessage());
    }

    /**
     * Exibe uma mensagem informativa na tela.
     *
     * @param s texto que será apresentado ao usuário.
     */
    private void alert(String s)
    {
        new Alert(Alert.AlertType.INFORMATION,s).showAndWait();
    }

    /**
     * Solicita a confirmação do usuário antes de executar uma operação.
     *
     * @param s mensagem apresentada na janela de confirmação.
     * @return true caso o usuário confirme; false caso contrário.
     */
    private boolean confirmar(String s)
    {
        Alert a=new Alert(Alert.AlertType.CONFIRMATION,s,ButtonType.YES,ButtonType.NO);
        return a.showAndWait().orElse(ButtonType.NO)==ButtonType.YES;
    }
}
