package model;
import java.time.LocalDate;
import java.math.BigDecimal;
public class Avaliacao
{
    private int idAvaliacao;
    private Materia materia;
    private String titulo;
    private LocalDate dataAvaliacao;
    private BigDecimal nota,valorMaximo=BigDecimal.TEN;
    public int getIdAvaliacao()
    {
        return idAvaliacao;
    }
    public void setIdAvaliacao(int v)
    {
        idAvaliacao=v;
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
    public LocalDate getDataAvaliacao()
    {
        return dataAvaliacao;
    }
    public void setDataAvaliacao(LocalDate v)
    {
        dataAvaliacao=v;
    }
    public BigDecimal getNota()
    {
        return nota;
    }
    public void setNota(BigDecimal v)
    {
        nota=v;
    }
    public BigDecimal getValorMaximo()
    {
        return valorMaximo;
    }
    public void setValorMaximo(BigDecimal v)
    {
        valorMaximo=v;
    }
}
