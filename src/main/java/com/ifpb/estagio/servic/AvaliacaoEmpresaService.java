package com.ifpb.estagio.servic;

import java.util.List;

import com.ifpb.estagio.dao.QuestionarioDAO;
import com.ifpb.estagio.model.AvaliacaoDoOrientador;


public class AvaliacaoEmpresaService {

    private QuestionarioDAO questionarioDAO;

    public AvaliacaoEmpresaService() {
        this.questionarioDAO = new QuestionarioDAO();
    }

    public AvaliacaoDoOrientador buscarAvaliacaoPorId(Long id) {
        return questionarioDAO.buscarPorId(id);
    }

    public void salvarAvaliacao(AvaliacaoEmpresaService avaliacao) {
        questionarioDAO.salvar(avaliacao);
    }

    public void removerAvaliacao(Long id) {
        questionarioDAO.remover(id);
    }

    public List<AvaliacaoEmpresaService> listarTodasAvaliacoes(String jpql) {
        return questionarioDAO.buscarTodos(jpql);
    }
}
