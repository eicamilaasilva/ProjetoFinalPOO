package controller;

import dao.*;
import model.*;
import javafx.fxml.FXML;
import javafx.collections.*;
import javafx.scene.control.*;
import java.sql.SQLException;
import java.math.BigDecimal;
import java.time.LocalDate;
public class AvaliacaoController
{
    @FXML private TableView<Avaliacao> tabela;
    @FXML private TableColumn<Avaliacao,String> cTitulo,cMateria,cNota;
    @FXML private TableColumn<Avaliacao,LocalDate> cData;
    @FXML private ComboBox<Materia> materia;
    @FXML private TextField titulo,nota,maximo;
    @FXML private DatePicker data;
    private final AvaliacaoDao dao=new AvaliacaoDao();
    private final MateriaDao md=new MateriaDao();
    private Avaliacao editando;
    @FXML public void initialize()
    {
        cTitulo.setCellValueFactory(v->new javafx.beans.property.SimpleStringProperty(v.getValue().getTitulo()));
        cMateria.setCellValueFactory(v->new javafx.beans.property.SimpleStringProperty(v.getValue().getMateria().getNome()));
        cNota.setCellValueFactory(v->new javafx.beans.property.SimpleStringProperty(v.getValue().getNota()==null?"Sem nota":v.getValue().getNota().toString()+" / "+v.getValue().getValorMaximo()));
        cData.setCellValueFactory(v->new javafx.beans.property.SimpleObjectProperty<>(v.getValue().getDataAvaliacao()));
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
                editando=b;materia.setValue(b.getMateria());titulo.setText(b.getTitulo());data.setValue(b.getDataAvaliacao());nota.setText(b.getNota()==null?"":b.getNota().toString());maximo.setText(b.getValorMaximo().toString());
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
        if(materia.getValue()==null||titulo.getText().isBlank()||data.getValue()==null||maximo.getText().isBlank())
        {
            alert("Preencha matéria, título, data e valor máximo.");
            return;
        }
        try
        {
            BigDecimal n=nota.getText().isBlank()?null:new BigDecimal(nota.getText().replace(',','.'));
            BigDecimal mx=new BigDecimal(maximo.getText().replace(',','.'));
            if(mx.compareTo(BigDecimal.ZERO)<=0||(n!=null&&(n.compareTo(BigDecimal.ZERO)<0||n.compareTo(mx)>0)))
            {
                alert("Nota deve estar entre 0 e o valor máximo, e o valor máximo deve ser positivo.");
                return;
            }
            Avaliacao a=editando==null?new Avaliacao():editando;
            a.setMateria(materia.getValue());
            a.setTitulo(titulo.getText().trim());
            a.setDataAvaliacao(data.getValue());
            a.setNota(n);
            a.setValorMaximo(mx);
            if(editando==null)dao.inserir(a);
            else dao.atualizar(a);
            limpar();
            carregar();
        }
        catch(NumberFormatException e)
        {
            alert("Nota e valor máximo precisam ser números.");
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
        Avaliacao a=tabela.getSelectionModel().getSelectedItem();
        if(a==null)
        {
            alert("Selecione uma avaliação.");
            return;
        }
        if(confirmar("Excluir avaliação?"))
        {
            try
            {
                dao.excluir(a.getIdAvaliacao());
                carregar();
                limpar();
            }
            catch(SQLException e)
            {
                erro(e);
            }
        }
    }
    private void limpar()
    {
        editando=null;
        titulo.clear();
        nota.clear();
        maximo.setText("10");
        data.setValue(null);
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
