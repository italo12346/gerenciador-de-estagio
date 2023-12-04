package com.ifpb.estagio.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.ifpb.estagio.model.Aluno;
import com.ifpb.estagio.model.Orientador;


@Named
@ViewScoped
public class GestaoAlunosBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Aluno aluno;
	private Orientador orientador;
	
	public void salvar() {
		System.out.println("nome: "+ aluno.getNome()+ "- Curso"+aluno.getCurso());
	}
	
	public Aluno getAluno() {
		return aluno;
	}
	
	public Orientador getOrientador() {
		return orientador;
	}
	
}
