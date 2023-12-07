package com.ifpb.estagio.servic;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.ifpb.estagio.dao.DAO;
import com.ifpb.estagio.model.Estagio;
import com.ifpb.estagio.utility.NegocioException;

public class EstagioService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private DAO<Estagio> dao;

    public void salvar(Estagio estagio) throws NegocioException {
        // Adicione suas validações específicas aqui, se necessário
        dao.salvar(estagio);
    }

    public void remover(Estagio estagio) throws NegocioException {
        dao.remover(Estagio.class, estagio.getId());
    }

    public List<Estagio> todosOsEstagios() {
        return dao.buscarTodos("select e from Estagio e order by e.nome");
    }
}
