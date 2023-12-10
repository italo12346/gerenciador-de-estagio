package com.ifpb.estagio.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ifpb.estagio.model.Orientador;
import com.ifpb.estagio.servic.OrientadorService;
import com.ifpb.estagio.utility.Message;
import com.ifpb.estagio.utility.NegocioException;

@Named("orientadorBean")
@SessionScoped
public class OrientadorBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Orientador orientador;

    @Inject
    private OrientadorService service;

    private List<Orientador> orientadores;
    
    private String termoPesquisa;

    public void pesquisar() {
        orientadores = service.buscarOrientadorPorTermo(termoPesquisa);
    }
    
    @PostConstruct
	 public void carregar() {
       termoPesquisa = "";
       orientadores = service.todosOsOrientadores();
   }

    public Orientador getOrientador() {
        return orientador;
    }

    public void setOrientador(Orientador orientador) {
        this.orientador = orientador;
    }

    public List<Orientador> getOrientadores() {
        return orientadores;
    }

    public void adicionar() {
        try {
            service.salvar(orientador);
            orientador = new Orientador();
            carregar();
            Message.info("Orientador salvo com Sucesso");
        } catch (NegocioException e) {
            Message.erro("Erro em Salvar");
        }
    }

    public void excluir() {
        try {
            service.remover(orientador);
            carregar();
            Message.info(orientador.getNome() + " foi removido");
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
