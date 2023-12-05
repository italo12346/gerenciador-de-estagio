package com.ifpb.estagio.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ifpb.estagio.model.Aluno;

@Named("alunoBean")
@SessionScoped
public class AlunoMb implements Serializable{

	private static final long serialVersionUID = 1L;
	@Inject
	private Aluno aluno;
	private List<Aluno> alunos = new ArrayList<>();
	
	public String adcionar() {
		alunos.add(aluno);
		limpar();
		return null;
	}
	
	private void limpar() {
		aluno = new Aluno();
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

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	
}
