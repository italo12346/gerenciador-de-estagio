package com.ifpb.estagio.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ifpb.estagio.model.AvaliacaoDoOrientador;
import com.ifpb.estagio.servic.AvaliacaoOrientadorService;

@ManagedBean
@SessionScoped
public class AvaliacaoOrientadorBean {

	private AvaliacaoOrientadorService avaliacaoService;
	private AvaliacaoDoOrientador avaliacao;
	private List<AvaliacaoDoOrientador> listaAvaliacoes;

	public AvaliacaoOrientadorBean() {
		this.avaliacaoService = new AvaliacaoOrientadorService();
		this.avaliacao = new AvaliacaoDoOrientador();
		this.listaAvaliacoes = avaliacaoService.listarTodasAvaliacoes("SELECT a FROM AvaliacaoDoOrientador a");
	}

	public void carregarAvaliacao(Long id) {
		this.avaliacao = avaliacaoService.buscarAvaliacaoPorId(id);
	}

	public void salvarAvaliacao() {
		avaliacaoService.salvarAvaliacao(avaliacao);
		this.avaliacao = new AvaliacaoDoOrientador(); // Limpar os campos após salvar
		atualizarListaAvaliacoes();
	}

	public void removerAvaliacao(Long id) {
		avaliacaoService.removerAvaliacao(id);
		atualizarListaAvaliacoes();
	}

	private void atualizarListaAvaliacoes() {
		this.listaAvaliacoes = avaliacaoService.listarTodasAvaliacoes("SELECT a FROM AvaliacaoDoOrientador a");
	}

	// Getters e Setters

	public AvaliacaoDoOrientador getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(AvaliacaoDoOrientador avaliacao) {
		this.avaliacao = avaliacao;
	}

	public List<AvaliacaoDoOrientador> getListaAvaliacoes() {
		return listaAvaliacoes;
	}

	public void setListaAvaliacoes(List<AvaliacaoDoOrientador> listaAvaliacoes) {
		this.listaAvaliacoes = listaAvaliacoes;
	}
}
