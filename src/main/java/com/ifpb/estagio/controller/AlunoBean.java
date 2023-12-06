package com.ifpb.estagio.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ifpb.estagio.model.Aluno;
import com.ifpb.estagio.servic.AlunoService;
import com.ifpb.estagio.utility.Message;
import com.ifpb.estagio.utility.NegocioException;

@Named("alunoBean")
@SessionScoped
public class AlunoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private Aluno aluno;

	@Inject
	private AlunoService service;

	private List<Aluno> alunos;

	@PostConstruct
	public void carregar() {
		alunos = service.todosOsAlunos();
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void adicionar() {
		try {
			service.salvar(aluno);
			aluno = new Aluno();
			carregar();
			Message.info("Salvo com Sucesso");
		} catch (NegocioException e) {
			Message.erro("Erro em Salvar");
		}
	}

	public void excluir() {
		try {
			service.remover(aluno);
			carregar();
			Message.info(aluno.getNome() + " Foi removido");
		} catch (NegocioException e) {
			Message.erro("Erro em Salvar");
		}
	}
	public void editar() {
		Message.info("Pronto para Editar");
	}
	
};
