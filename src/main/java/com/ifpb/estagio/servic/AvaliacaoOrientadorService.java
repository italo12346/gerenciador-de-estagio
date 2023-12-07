package com.ifpb.estagio.servic;

import java.util.List;

import com.ifpb.estagio.dao.QuestionarioDAO;
import com.ifpb.estagio.model.AvaliacaoDoOrientador;

public class AvaliacaoOrientadorService {

    private QuestionarioDAO questionarioDAO;

    public AvaliacaoOrientadorService() {
        this.questionarioDAO = new QuestionarioDAO();
    }

    public AvaliacaoDoOrientador buscarAvaliacaoPorId(Long id) {
        return questionarioDAO.buscarPorId(id);
    }

    public void salvarAvaliacao(AvaliacaoDoOrientador avaliacao) {
        QuestionarioDAO.salvar(avaliacao);
    }

    public void removerAvaliacao(Long id) {
        questionarioDAO.remover(id);
    }

    public List<AvaliacaoDoOrientador> listarTodasAvaliacoes(String jpql) {
        return questionarioDAO.buscarTodos(jpql);
    }
}
