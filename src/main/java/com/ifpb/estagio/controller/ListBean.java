package com.ifpb.estagio.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ifpb.estagio.model.Base;
import com.ifpb.estagio.servic.AlunoService;

@Named
@SessionScoped
public class ListBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private AlunoService alunoService;
    @SuppressWarnings("unused")
    private List<? extends Base> entidades;
    private String entidadeSelecionada;

    @PostConstruct
    public void init() {
        // Inicializar com a lista de alunos por padrão
        entidadeSelecionada = "Alunos";
        carregarEntidade();
    }

    public void carregarEntidade() {
        if ("Alunos".equals(entidadeSelecionada)) {
            entidades = alunoService.todosOsAlunos();
        } else if ("Orientadores".equals(entidadeSelecionada)) {
            // Carregar dados de orientadores
        } else if ("Empresas".equals(entidadeSelecionada)) {
            // Carregar dados de empresas
        } else if ("Estagios".equals(entidadeSelecionada)) {
            // Carregar dados de estágios
        }
    }

    // Métodos getter e setter para entidades e entidadeSelecionada

    // Outros métodos conforme necessário
}
