package model;

import java.math.BigDecimal;

/**
 * Representa indicadores de desempenho das avaliações agrupadas por matéria.
 *
 * @author Camila
 * @version 1.0
 */
public class ConsultaDesempenhoMateria {
    private String materia;
    private int quantidade;
    private BigDecimal media;
    private BigDecimal maiorNota;
    private BigDecimal menorNota;

    /** Construtor padrão. */
    public ConsultaDesempenhoMateria() {}

    /** @return nome da matéria. */
    public String getMateria() { return materia; }
    /** @param materia nome da matéria. */
    public void setMateria(String materia) { this.materia = materia; }
    /** @return quantidade de avaliações com nota. */
    public int getQuantidade() { return quantidade; }
    /** @param quantidade quantidade de avaliações. */
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    /** @return média das notas registradas. */
    public BigDecimal getMedia() { return media; }
    /** @param media média calculada. */
    public void setMedia(BigDecimal media) { this.media = media; }
    /** @return maior nota registrada. */
    public BigDecimal getMaiorNota() { return maiorNota; }
    /** @param maiorNota maior nota. */
    public void setMaiorNota(BigDecimal maiorNota) { this.maiorNota = maiorNota; }
    /** @return menor nota registrada. */
    public BigDecimal getMenorNota() { return menorNota; }
    /** @param menorNota menor nota. */
    public void setMenorNota(BigDecimal menorNota) { this.menorNota = menorNota; }
}
