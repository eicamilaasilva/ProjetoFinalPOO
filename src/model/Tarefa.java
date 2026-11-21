package model;
import java.time.LocalDate;
public class Tarefa
{
    private int idTarefa;
    private Materia materia;
    private String titulo,descricao,status,prioridade;
    private LocalDate dataEntrega;
    public Tarefa()
    {
    }
    public int getIdTarefa()
    {
        return idTarefa;
    }
    public void setIdTarefa(int v)
    {
        idTarefa=v;
    }
    public Materia getMateria()
    {
        return materia;
    }
    public void setMateria(Materia v)
    {
        materia=v;
    }
    public String getTitulo()
    {
        return titulo;
    }
    public void setTitulo(String v)
    {
        titulo=v;
    }
    public String getDescricao()
    {
        return descricao;
    }
    public void setDescricao(String v)
    {
        descricao=v;
    }
    public LocalDate getDataEntrega()
    {
        return dataEntrega;
    }
    public void setDataEntrega(LocalDate v)
    {
        dataEntrega=v;
    }
    public String getStatus()
    {
        return status;
    }
    public void setStatus(String v)
    {
        status=v;
    }
    public String getPrioridade()
    {
        return prioridade;
    }
    public void setPrioridade(String v)
    {
        prioridade=v;
    }
}
