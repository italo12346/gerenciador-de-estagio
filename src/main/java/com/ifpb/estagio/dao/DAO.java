package com.ifpb.estagio.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.Dependent; // Importa a anotação Dependent
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ifpb.estagio.model.Base;

@Dependent // Adiciona a anotação @Dependent
public class DAO<T extends Base> implements Serializable {
	private static final long serialVersionUID = 1L;

	private static EntityManager manager = ConnectionFactory.getEntityManager();

	public T buscarPorId(Class<T> clazz, Long id) {
		try {
			return manager.find(clazz, id);
		} finally {
			manager.close();
		}
	}

	public void salvar(T t) {

		try {
			manager.getTransaction().begin();
			if (t.getId() == null) {
				manager.persist(t);
			} else {
				manager.merge(t);
			}
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}

	public void remover(Class<T> clazz, Long id) {
		try {
			manager.getTransaction().begin();
			T t = manager.find(clazz, id);
			if (t != null) {
				manager.remove(t);
			}
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> buscarTodos(String jpql) {
		manager.getTransaction().begin();
		try {
			Query query = manager.createQuery(jpql);
			return query.getResultList();
		} finally {
			manager.close();
		}
	}
}
