package com.ifpb.estagio.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ifpb.estagio.model.AvaliacaoDoOrientador;

@Dependent
public class QuestionarioDAO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static EntityManager manager = ConnectionFactory.getEntityManager();

    public AvaliacaoDoOrientador buscarPorId(Long id) {
        try {
            return manager.find(AvaliacaoDoOrientador.class, id);
        } finally {
            System.out.println("busca ok");
        }
    }

    public static void salvar(AvaliacaoDoOrientador respostas) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            if (respostas.getId() == null) {
                manager.persist(respostas);
            } else {
                manager.merge(respostas);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println(e);
        } finally {
            System.out.println("salvar ok");
        }
    }

    public void remover(Long id) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            AvaliacaoDoOrientador respostas = manager.find(AvaliacaoDoOrientador.class, id);
            if (respostas != null) {
                manager.remove(respostas);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            System.out.println("remover ok");
        }
    }

    @SuppressWarnings("unchecked")
    public List<AvaliacaoDoOrientador> buscarTodos(String jpql) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            Query query = manager.createQuery(jpql);
            return query.getResultList();
        } finally {
            transaction.commit();
            System.out.println("listar ok");
        }
    }
}