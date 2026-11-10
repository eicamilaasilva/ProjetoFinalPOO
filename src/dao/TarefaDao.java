package dao;

import java.util.ArrayList;
import java.util.List;

import model.Materia;
import model.Tarefa;

public class TarefaDao {
    private List<Tarefa> tarefas = new ArrayList<>();

    public void inserir(Tarefa t) {
        tarefas.add(t);
        System.out.println("[Dao] Tarefa salva no sistema.");
    }

    public void atualizar(Tarefa t) {
        System.out.println("[Dao] Tarefa atualizada no banco.");
    }

    public void excluir(Tarefa t) {
        tarefas.remove(t);
        System.out.println("[Dao] Tarefa removida do banco.");
    }

    public List<Tarefa> listar() {
        return tarefas;
    }
 // Consulta 1: Retorna todas as tarefas vinculadas a uma Matéria específica (Relacionamento FK)
    public List<Tarefa> buscarPorMateria(Materia materia) {
        List<Tarefa> filtradas = new ArrayList<>();
        for (Tarefa t : listar()) {
            if (t.getMateria() != null && t.getMateria().getId() == materia.getId()) {
                filtradas.add(t);
            }
        }
        return filtradas;
    }

    // Consulta 2: Retorna apenas as tarefas que estão com o status "Pendente" ou "Em Andamento"
    public List<Tarefa> buscarPendentes() {
        List<Tarefa> filtradas = new ArrayList<>();
        for (Tarefa t : listar()) {
            if ("Pendente".equalsIgnoreCase(t.getStatus()) || "Em Andamento".equalsIgnoreCase(t.getStatus())) {
                filtradas.add(t);
            }
        }
        return filtradas;
    }
}