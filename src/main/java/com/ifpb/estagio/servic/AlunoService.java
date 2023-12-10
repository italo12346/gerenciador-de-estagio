package com.ifpb.estagio.servic;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ifpb.estagio.dao.ConnectionFactory;
import com.ifpb.estagio.dao.DAO;
import com.ifpb.estagio.model.Aluno;
import com.ifpb.estagio.model.Empresa;
import com.ifpb.estagio.utility.NegocioException;

public class AlunoService implements Serializable {

	private static final long serialVersionUID = 1L;
	private static EntityManager manager = ConnectionFactory.getEntityManager();

	@Inject
	private DAO<Aluno> dao;

	public void salvar(Aluno aluno) throws NegocioException {
		if (aluno.getNome() == null || aluno.getNome().length() < 3) {
			throw new NegocioException("O nome do aluno deve ter pelo menos 3 caracteres. Nome atual: "
					+ (aluno.getNome() != null ? aluno.getNome().length() : 0) + " caracteres.");
		}
		dao.salvar(aluno);
	}

	public void remover(Aluno aluno) throws NegocioException {
		dao.remover(Aluno.class, aluno.getId());
	}

	public List<Aluno> todosOsAlunos() {
		return dao.buscarTodos("select a from Aluno a order by a.nome");
	}

	public List<Aluno> buscarAlunoPorTermo(String termo) {
		String jpql = "SELECT e FROM Aluno e WHERE LOWER(e.nome) LIKE LOWER(:termo) ORDER BY e.nome";
		Query query = manager.createQuery(jpql, Aluno.class);
		query.setParameter("termo", "%" + termo + "%");
		return query.getResultList();
	}
}
