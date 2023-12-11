package com.ifpb.estagio.dao;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

@Dependent
public class QuestionarioDAO<T, ID extends Serializable> implements Serializable {
    private static final long serialVersionUID = 1L;
    private final Class<T> entityClass;
    private final EntityManager manager = ConnectionFactory.getEntityManager();

    public QuestionarioDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public T buscarPorId(ID id) {
        try {
            return manager.find(entityClass, id);
        } finally {
            System.out.println("busca ok");
        }
    }

    public void salvar(T entity) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            if (getId(entity) == null) {
                manager.persist(entity);
            } else {
                manager.merge(entity);
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

    public void remover(ID id) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            T entity = manager.find(entityClass, id);
            if (entity != null) {
                manager.remove(entity);
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
    public List<T> buscarTodos(String jpql) {
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

    private Serializable getId(T entity) {
        // Implementar lógica para obter o ID da entidade
        // Exemplo: return entity.getId();
        return null;
    }
}
