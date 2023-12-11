package com.ifpb.estagio.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ifpb.estagio.model.AvaliacaoDaEmpresa;
import com.ifpb.estagio.servic.AvaliacaoEmpresaService;

@ManagedBean
@SessionScoped
public class AvaliacaoEmpresaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private AvaliacaoEmpresaService avaliacaoService;
	private AvaliacaoDaEmpresa avaliacao;
	private List<AvaliacaoDaEmpresa> listaAvaliacoes;

	public AvaliacaoEmpresaBean() {
		this.avaliacaoService = new AvaliacaoEmpresaService();
		this.avaliacao = new AvaliacaoDaEmpresa();
		this.listaAvaliacoes = avaliacaoService.listarTodasAvaliacoes("SELECT a FROM AvaliacaoDaEmpresa a");
	}

	public void carregarAvaliacao(Long id) {
		this.avaliacao = avaliacaoService.buscarAvaliacaoPorId(id);
	}

	public void salvarAvaliacao() {
		avaliacaoService.salvarAvaliacao(avaliacao);
		this.avaliacao = new AvaliacaoDaEmpresa(); // Limpar os campos após salvar
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

	public AvaliacaoDaEmpresa getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(AvaliacaoDaEmpresa avaliacao) {
		this.avaliacao = avaliacao;
	}

	public List<AvaliacaoDaEmpresa> getListaAvaliacoes() {
		return listaAvaliacoes;
	}

	public void setListaAvaliacoes(List<AvaliacaoDaEmpresa> listaAvaliacoes) {
		this.listaAvaliacoes = listaAvaliacoes;
	}
}
