package com.ifpb.estagio.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ifpb.estagio.model.Aluno;

@Named
@ViewScoped
public class GestaoAlunosBean implements Serializable {
	private static final long serialVersionUID = 1L;

	public String voltar() {
		return "index?faces-redirect=true";
	}

	Aluno aluno = new Aluno();

	public String Salvar() {
		return "index?faces-redirect=true";
	}
}
