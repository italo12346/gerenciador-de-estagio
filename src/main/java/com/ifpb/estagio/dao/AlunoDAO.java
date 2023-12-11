package com.ifpb.estagio.dao;

import javax.persistence.EntityManager;

import com.ifpb.estagio.model.Aluno;


public class AlunoDAO {

	private static EntityManager manager = ConnectionFactory.getEntityManager();

    public Aluno buscarPorId(Long id) {
        return manager.find(Aluno.class, id);
    }

}	
