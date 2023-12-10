package com.ifpb.estagio.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ifpb.estagio.model.Base;

@Dependent
public class DAO<T extends Base> implements Serializable {
	private static final long serialVersionUID = 1L;
	private static EntityManager manager = ConnectionFactory.getEntityManager();

	public T buscarPorId(Class<T> clazz, Long id) {
		try {
			return manager.find(clazz, id);
		} finally {
			System.out.println("busca ok");
		}
	}

	public void salvar(T t) {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			if (t.getId() == null) {
				manager.persist(t);
			} else {
				manager.merge(t);
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

	public void remover(Class<T> clazz, Long id) {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			T t = manager.find(clazz, id);
			if (t != null) {
				manager.remove(t);
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
		} finally {
			System.out.println("remover ok");
			// Não feche o EntityManager aqui
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
			// Não feche o EntityManager aqui
		}
	}
}
