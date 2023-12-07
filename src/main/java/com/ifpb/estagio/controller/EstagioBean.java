package com.ifpb.estagio.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ifpb.estagio.model.Estagio;
import com.ifpb.estagio.servic.EstagioService;
import com.ifpb.estagio.utility.Message;
import com.ifpb.estagio.utility.NegocioException;

@Named("estagioBean")
@SessionScoped
public class EstagioBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Estagio estagio;

    @Inject
    private EstagioService service;

    private List<Estagio> estagios;

    @PostConstruct
    public void carregar() {
        estagios = service.todosOsEstagios();
    }

    public Estagio getEstagio() {
        return estagio;
    }

    public void setEstagio(Estagio estagio) {
        this.estagio = estagio;
    }

    public List<Estagio> getEstagios() {
        return estagios;
    }

    public void salvar() {
        try {
            service.salvar(estagio);
            estagio = new Estagio();
            carregar();
            Message.info("Estágio salvo com Sucesso");
        } catch (NegocioException e) {
            Message.erro("Erro em Salvar Estágio");
        }
    }

    public void excluir() {
        try {
            service.remover(estagio);
            carregar();
            Message.info(estagio.getNome() + " foi removido");
        } catch (NegocioException e) {
            Message.erro("Erro ao Remover Estágio");
        }
    }

    public void editar() {
        Message.info("Pronto para Editar Estágio");
    }
}
