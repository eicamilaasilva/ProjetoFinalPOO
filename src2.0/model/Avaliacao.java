package model;

import java.time.LocalDate;
import java.math.BigDecimal;

/**
 * Classe responsável por representar uma avaliação
 * cadastrada no sistema FocusUp.
 *
 * Armazena os dados da avaliação, incluindo matéria,
 * título, data, nota obtida e valor máximo.
 *
 * @author Camila
 * @version 1.0
 */
public class Avaliacao {

    private int idAvaliacao;
    private Materia materia;
    private String titulo;
    private LocalDate dataAvaliacao;
    private BigDecimal nota, valorMaximo = BigDecimal.TEN;

    /**
     * Retorna o identificador da avaliação.
     *
     * @return Identificador da avaliação.
     */
    public int getIdAvaliacao() {
        return idAvaliacao;
    }

    /**
     * Define o identificador da avaliação.
     *
     * @param v Identificador da avaliação.
     */
    public void setIdAvaliacao(int v) {
        idAvaliacao = v;
    }

    /**
     * Retorna a matéria relacionada à avaliação.
     *
     * @return Matéria associada à avaliação.
     */
    public Materia getMateria() {
        return materia;
    }

    /**
     * Define a matéria relacionada à avaliação.
     *
     * @param v Matéria associada à avaliação.
     */
    public void setMateria(Materia v) {
        materia = v;
    }

    /**
     * Retorna o título da avaliação.
     *
     * @return Título da avaliação.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Define o título da avaliação.
     *
     * @param v Título da avaliação.
     */
    public void setTitulo(String v) {
        titulo = v;
    }

    /**
     * Retorna a data da avaliação.
     *
     * @return Data da avaliação.
     */
    public LocalDate getDataAvaliacao() {
        return dataAvaliacao;
    }

    /**
     * Define a data da avaliação.
     *
     * @param v Data da avaliação.
     */
    public void setDataAvaliacao(LocalDate v) {
        dataAvaliacao = v;
    }

    /**
     * Retorna a nota obtida na avaliação.
     *
     * @return Nota obtida ou null quando ainda não foi registrada.
     */
    public BigDecimal getNota() {
        return nota;
    }

    /**
     * Define a nota obtida na avaliação.
     *
     * @param v Nota obtida na avaliação.
     */
    public void setNota(BigDecimal v) {
        nota = v;
    }

    /**
     * Retorna o valor máximo da avaliação.
     *
     * @return Valor máximo da avaliação.
     */
    public BigDecimal getValorMaximo() {
        return valorMaximo;
    }

    /**
     * Define o valor máximo da avaliação.
     *
     * @param v Valor máximo da avaliação.
     */
    public void setValorMaximo(BigDecimal v) {
        valorMaximo = v;
    }
}