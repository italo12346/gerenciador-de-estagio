package com.ifpb.estagio.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ifpb.estagio.model.Aluno;
import com.ifpb.estagio.model.AvaliacaoDoOrientador;
import com.ifpb.estagio.servic.AlunoService;
import com.ifpb.estagio.servic.AvaliacaoOrientadorService;

@Named
@SessionScoped
public class AvaliacaoOrientadorBean {

	private AvaliacaoOrientadorService avaliacaoService;
	private AvaliacaoDoOrientador avaliacao;
	private List<AvaliacaoDoOrientador> listaAvaliacoes;
	@Inject
	private AlunoService service;
	private List<Aluno> listAlunos;	
	
	private Aluno alunoSelecionado;

	public Aluno getAlunoSelecionado() {
	    return alunoSelecionado;
	}

	public void setAlunoSelecionado(Aluno alunoSelecionado) {
	    this.alunoSelecionado = alunoSelecionado;
	}

	public AvaliacaoOrientadorBean() {
		this.avaliacaoService = new AvaliacaoOrientadorService();
		this.avaliacao = new AvaliacaoDoOrientador();
		this.listaAvaliacoes = avaliacaoService.listarTodasAvaliacoes("SELECT a FROM AvaliacaoDoOrientador a");
	}

	public void carregarAvaliacao(Long id) {
		this.avaliacao = avaliacaoService.buscarAvaliacaoPorId(id);
	}

	public void salvarAvaliacao() {
		avaliacao.setAluno(alunoSelecionado);	
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
	@PostConstruct
	public void carregarAlunos(){
		listAlunos = service.todosOsAlunos();
		System.out.println(listAlunos);
	}

	// Getters e Setters

    public List<Aluno> getListAlunos() {
        return listAlunos;
    }

    public void setListAlunos(List<Aluno> listAlunos) {
        this.listAlunos = listAlunos;
    }
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
