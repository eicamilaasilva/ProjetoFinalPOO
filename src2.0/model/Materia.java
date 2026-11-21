package model;

/**
 * Classe responsável por representar uma matéria
 * cadastrada no sistema FocusUp.
 *
 * Armazena o identificador, o nome e a descrição
 * de cada matéria.
 *
 * @author Camila
 * @version 1.0
 */
public class Materia {

    private int idMateria;
    private String nome, descricao;

    /**
     * Construtor padrão da classe Materia.
     */
    public Materia() {
    }

    /**
     * Construtor responsável por inicializar uma matéria
     * com seus respectivos dados.
     *
     * @param id Identificador da matéria.
     * @param nome Nome da matéria.
     * @param descricao Descrição da matéria.
     */
    public Materia(int id, String nome, String descricao) {
        this.idMateria = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    /**
     * Retorna o identificador da matéria.
     *
     * @return Identificador da matéria.
     */
    public int getIdMateria() {
        return idMateria;
    }

    /**
     * Define o identificador da matéria.
     *
     * @param id Identificador da matéria.
     */
    public void setIdMateria(int id) {
        idMateria = id;
    }

    /**
     * Retorna o nome da matéria.
     *
     * @return Nome da matéria.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da matéria.
     *
     * @param nome Nome da matéria.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna a descrição da matéria.
     *
     * @return Descrição da matéria.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição da matéria.
     *
     * @param descricao Descrição da matéria.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Retorna o nome da matéria como representação textual do objeto.
     *
     * @return Nome da matéria ou uma string vazia quando o nome for nulo.
     */
    @Override
    public String toString() {
        return nome == null ? "" : nome;
    }
}