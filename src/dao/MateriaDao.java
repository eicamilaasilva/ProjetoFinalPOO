package dao;

import java.util.ArrayList;
import java.util.List;
import model.Materia;

public class MateriaDao {
    private List<Materia> materias = new ArrayList<>();

    public void inserir(Materia m) {
        materias.add(m);
        System.out.println("[Dao] Matéria salva no sistema.");
    }

    public void atualizar(Materia m) {
        System.out.println("[Dao] Matéria atualizada no banco.");
    }

    public void excluir(Materia m) {
        materias.remove(m);
        System.out.println("[Dao] Matéria excluída do banco.");
    }

    public List<Materia> listar() {
        return materias;
    }
}