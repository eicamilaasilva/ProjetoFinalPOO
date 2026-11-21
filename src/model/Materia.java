package model;
public class Materia
{
    private int idMateria;
    private String nome, descricao;
    public Materia()
    {
    }
    public Materia(int id,String nome,String descricao)
    {
        this.idMateria=id;
        this.nome=nome;
        this.descricao=descricao;
    }
    public int getIdMateria()
    {
        return idMateria;
    }
    public void setIdMateria(int id)
    {
        idMateria=id;
    }
    public String getNome()
    {
        return nome;
    }
    public void setNome(String nome)
    {
        this.nome=nome;
    }
    public String getDescricao()
    {
        return descricao;
    }
    public void setDescricao(String descricao)
    {
        this.descricao=descricao;
    }
    @Override public String toString()
    {
        return nome==null?"":nome;
    }
}
