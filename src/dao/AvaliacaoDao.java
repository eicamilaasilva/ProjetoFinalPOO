package dao;

import java.util.ArrayList;
import java.util.List;
import model.Avaliacao;

public class AvaliacaoDao {
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public void inserir(Avaliacao a) {
        avaliacoes.add(a);
        System.out.println("[Dao] Avaliação salva no sistema.");
    }

    public void atualizar(Avaliacao a) {
        System.out.println("[Dao] Avaliação atualizada no banco.");
    }

    public void excluir(Avaliacao a) {
        avaliacoes.remove(a);
        System.out.println("[Dao] Avaliação removida do banco.");
    }

    public List<Avaliacao> listar() {
        return avaliacoes;
    }
}