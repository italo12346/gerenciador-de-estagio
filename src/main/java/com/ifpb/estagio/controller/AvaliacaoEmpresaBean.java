package com.ifpb.estagio.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class AvaliacaoEmpresaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private AvaliacaoEmpresaBean avaliacaoService;
    private AvaliacaoEmpresaBean avaliacao;
    private List<AvaliacaoEmpresaBean> listaAvaliacoes;

    public AvaliacaoEmpresaBean() {
        this.avaliacaoService = new AvaliacaoEmpresaBean();
        this.avaliacao = new AvaliacaoEmpresaBean();
        this.listaAvaliacoes = avaliacaoService.listarTodasAvaliacoes("SELECT a FROM AvaliacaoDoEstagiario a");
    }

    public void carregarAvaliacao(Long id) {
        this.avaliacao = avaliacaoService.buscarAvaliacaoPorId(id);
    }

    public void salvarAvaliacao() {
        avaliacaoService.salvarAvaliacao(avaliacao);
        this.avaliacao = new AvaliacaoEmpresaBean(); // Limpar os campos após salvar
        atualizarListaAvaliacoes();
    }

    public void removerAvaliacao(Long id) {
        avaliacaoService.removerAvaliacao(id);
        atualizarListaAvaliacoes();
    }

    private void atualizarListaAvaliacoes() {
        this.listaAvaliacoes = avaliacaoService.listarTodasAvaliacoes("SELECT a FROM AvaliacaoDaEmpresa a");
    }

    // Getters e Setters

    public AvaliacaoEmpresaBean getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(AvaliacaoEmpresaBean avaliacao) {
        this.avaliacao = avaliacao;
    }

    public List<AvaliacaoDoEstagiario> getListaAvaliacoes() {
        return listaAvaliacoes;
    }

    public void setListaAvaliacoes(List<AvaliacaoDoEstagiario> listaAvaliacoes) {
        this.listaAvaliacoes = listaAvaliacoes;
    }
}
