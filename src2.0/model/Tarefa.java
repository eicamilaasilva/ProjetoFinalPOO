package model;

import java.time.LocalDate;

/**
 * Classe responsável por representar uma tarefa
 * acadêmica cadastrada no sistema FocusUp.
 *
 * Armazena os dados da tarefa, incluindo matéria,
 * título, descrição, data de entrega, status e prioridade.
 *
 * @author Camila
 * @version 1.0
 */
public class Tarefa {

    private int idTarefa;
    private Materia materia;
    private String titulo, descricao, status, prioridade;
    private LocalDate dataEntrega;

    /**
     * Construtor padrão da classe Tarefa.
     */
    public Tarefa() {
    }

    /**
     * Retorna o identificador da tarefa.
     *
     * @return Identificador da tarefa.
     */
    public int getIdTarefa() {
        return idTarefa;
    }

    /**
     * Define o identificador da tarefa.
     *
     * @param v Identificador da tarefa.
     */
    public void setIdTarefa(int v) {
        idTarefa = v;
    }

    /**
     * Retorna a matéria relacionada à tarefa.
     *
     * @return Matéria associada à tarefa.
     */
    public Materia getMateria() {
        return materia;
    }

    /**
     * Define a matéria relacionada à tarefa.
     *
     * @param v Matéria associada à tarefa.
     */
    public void setMateria(Materia v) {
        materia = v;
    }

    /**
     * Retorna o título da tarefa.
     *
     * @return Título da tarefa.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Define o título da tarefa.
     *
     * @param v Título da tarefa.
     */
    public void setTitulo(String v) {
        titulo = v;
    }

    /**
     * Retorna a descrição da tarefa.
     *
     * @return Descrição da tarefa.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição da tarefa.
     *
     * @param v Descrição da tarefa.
     */
    public void setDescricao(String v) {
        descricao = v;
    }

    /**
     * Retorna a data de entrega da tarefa.
     *
     * @return Data de entrega.
     */
    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    /**
     * Define a data de entrega da tarefa.
     *
     * @param v Data de entrega.
     */
    public void setDataEntrega(LocalDate v) {
        dataEntrega = v;
    }

    /**
     * Retorna o status atual da tarefa.
     *
     * @return Status da tarefa.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Define o status da tarefa.
     *
     * @param v Status da tarefa.
     */
    public void setStatus(String v) {
        status = v;
    }

    /**
     * Retorna a prioridade da tarefa.
     *
     * @return Prioridade da tarefa.
     */
    public String getPrioridade() {
        return prioridade;
    }

    /**
     * Define a prioridade da tarefa.
     *
     * @param v Prioridade da tarefa.
     */
    public void setPrioridade(String v) {
        prioridade = v;
    }
}