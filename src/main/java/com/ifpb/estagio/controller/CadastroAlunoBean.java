package com.ifpb.estagio.controller;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ifpb.estagio.model.Aluno;

@ManagedBean
@ViewScoped
public class CadastroAlunoBean {

//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Inject
//    private AlunoMb alunoBean;  
//
//    public void cadastrarAluno() {
//        try {
//            // Iniciando a transação
//            entityManager.getTransaction().begin();
//
//            // Adicionando aluno
//            Aluno aluno = new Aluno();
//            aluno.setNome("luiza");
//            aluno.setCurso("ADS");
//
//            // Realizando o commit da transação
//            entityManager.getTransaction().commit();
//
//            // Adicionando o aluno ao AlunoBean (caso você tenha um)
//            alunoBean.adicionarAluno(aluno);
//
//        } catch (Exception e) {
//            if (entityManager.getTransaction().isActive()) {
//                // Rollback da transação em caso de exceção
//                entityManager.getTransaction().rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            // Fechando o EntityManager
//            entityManager.close();
//        }
//    }
}
