package controller;
import dao.*;
import model.*;
import javafx.fxml.FXML;
import javafx.collections.*;
import javafx.scene.control.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
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
                editando=b;materia.setValue(b.getMateria());titulo.setText(b.getTitulo());descricao.setText(b.getDescricao());data.setValue(b.getDataEntrega());status.setValue(b.getStatus());prioridade.setValue(b.getPrioridade());
            }
        }
        );
        carregar();
    }
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
    @FXML private void novo()
    {
        limpar();
    }
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
    private void erro(Exception e)
    {
        alert("Erro: "+e.getMessage());
    }
    private void alert(String s)
    {
        new Alert(Alert.AlertType.INFORMATION,s).showAndWait();
    }
    private boolean confirmar(String s)
    {
        Alert a=new Alert(Alert.AlertType.CONFIRMATION,s,ButtonType.YES,ButtonType.NO);
        return a.showAndWait().orElse(ButtonType.NO)==ButtonType.YES;
    }
}
