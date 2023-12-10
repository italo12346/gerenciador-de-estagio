package com.ifpb.estagio.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ifpb.estagio.model.Empresa;
import com.ifpb.estagio.servic.EmpresaService;
import com.ifpb.estagio.utility.Message;
import com.ifpb.estagio.utility.NegocioException;

@Named("empresaBean")
@SessionScoped
public class EmpresaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Empresa empresa;

    @Inject
    private EmpresaService service;

    private List<Empresa> empresas;
    
    private String termoPesquisa;
    
    public void pesquisar() {
        empresas = service.buscarEmpresasPorTermo(termoPesquisa);
    }

    @PostConstruct
    public void carregar() {
        termoPesquisa = "";
        empresas = service.todasAsEmpresas();
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void adicionar() {
        try {
            service.salvar(empresa);
            empresa = new Empresa();
            carregar();
            Message.info("Empresa salva com Sucesso");
        } catch (NegocioException e) {
            Message.erro("Erro em Salvar");
        }
    }

    public void excluir() {
        try {
            service.remover(empresa);
            carregar();
            Message.info(empresa.getNome() + " foi removida");
        } catch (NegocioException e) {
            Message.erro("Erro ao Remover");
        }
    }

    public void editar() {
        Message.info("Pronto para Editar");
    }

	public String getTermoPesquisa() {
		return termoPesquisa;
	}

	public void setTermoPesquisa(String termoPesquisa) {
		this.termoPesquisa = termoPesquisa;
	}
    
}
