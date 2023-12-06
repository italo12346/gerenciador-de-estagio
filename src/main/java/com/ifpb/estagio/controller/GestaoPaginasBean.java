package com.ifpb.estagio.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class GestaoPaginasBean implements Serializable {
	private static final long serialVersionUID = 1L;

	public String voltar() {
		return "index?faces-redirect=true";
	}


	public String Salvar() {
		return "index?faces-redirect=true";
	}
}
