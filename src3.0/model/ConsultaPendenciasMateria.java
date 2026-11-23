package model;

/**
 * Representa indicadores de tarefas agrupadas por matéria.
 *
 * @author Camila
 * @version 1.0
 */
public class ConsultaPendenciasMateria {
    private String materia;
    private int pendentes;
    private int atrasadas;
    private String proximaEntrega;

    /** Construtor padrão. */
    public ConsultaPendenciasMateria() {}

    /** @return nome da matéria. */
    public String getMateria() { return materia; }
    /** @param materia nome da matéria. */
    public void setMateria(String materia) { this.materia = materia; }
    /** @return quantidade de tarefas não concluídas. */
    public int getPendentes() { return pendentes; }
    /** @param pendentes quantidade de tarefas não concluídas. */
    public void setPendentes(int pendentes) { this.pendentes = pendentes; }
    /** @return quantidade de tarefas vencidas e não concluídas. */
    public int getAtrasadas() { return atrasadas; }
    /** @param atrasadas quantidade de tarefas vencidas e não concluídas. */
    public void setAtrasadas(int atrasadas) { this.atrasadas = atrasadas; }
    /** @return data da próxima entrega, formatada, ou texto informativo. */
    public String getProximaEntrega() { return proximaEntrega; }
    /** @param proximaEntrega data da próxima entrega. */
    public void setProximaEntrega(String proximaEntrega) { this.proximaEntrega = proximaEntrega; }
}
