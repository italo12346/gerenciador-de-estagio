package com.ifpb.estagio.servic;

import java.util.List;

import com.ifpb.estagio.dao.QuestionarioDAO;
import com.ifpb.estagio.model.AvaliacaoDaEmpresa;

public class AvaliacaoEmpresaService {

    private QuestionarioDAO<AvaliacaoDaEmpresa, Long> questionarioDAO;

    public AvaliacaoEmpresaService() {
        this.questionarioDAO = new QuestionarioDAO<>(AvaliacaoDaEmpresa.class);
    }

    public AvaliacaoDaEmpresa buscarAvaliacaoPorId(Long id) {
        return questionarioDAO.buscarPorId(id);
    }

    public void salvarAvaliacao(AvaliacaoDaEmpresa avaliacao) {
        questionarioDAO.salvar(avaliacao);
    }

    public void removerAvaliacao(Long id) {
        questionarioDAO.remover(id);
    }

    public List<AvaliacaoDaEmpresa> listarTodasAvaliacoes(String jpql) {
        return questionarioDAO.buscarTodos(jpql);
    }
}
