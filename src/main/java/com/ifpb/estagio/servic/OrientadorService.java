package com.ifpb.estagio.servic;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

import com.ifpb.estagio.dao.DAO;
import com.ifpb.estagio.model.Orientador;
import com.ifpb.estagio.utility.NegocioException;

public class OrientadorService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private DAO<Orientador> dao;

    public void salvar(Orientador orientador) throws NegocioException {
        if (orientador.getNome() == null || orientador.getNome().length() < 3) {
            throw new NegocioException("O nome do orientador deve ter pelo menos 3 caracteres. Nome atual: "
                    + (orientador.getNome() != null ? orientador.getNome().length() : 0) + " caracteres.");
        }
        dao.salvar(orientador);
    }

    public void remover(Orientador orientador) throws NegocioException {
        dao.remover(Orientador.class, orientador.getId());
    }

    public List<Orientador> todosOsOrientadores() {
        return dao.buscarTodos("select o from Orientador o order by o.nome");
    }
}
