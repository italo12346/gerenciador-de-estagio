package com.ifpb.estagio.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.ifpb.estagio.model.Empresa;
import com.ifpb.estagio.model.TipoEmpresa;

@Named
@ViewScoped
public class GestaoEmpresaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Empresa empresa = new Empresa();
	public void salvar() {
		System.out.println("nome : "+ empresa.getNome() + "Setor: " + empresa.getSetor());
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public TipoEmpresa[] getTiposEmpresa() {
		return TipoEmpresa.values();
	}
}
