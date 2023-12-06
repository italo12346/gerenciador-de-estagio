package com.ifpb.estagio.servic;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.ifpb.estagio.dao.DAO;
import com.ifpb.estagio.model.Empresa;
import com.ifpb.estagio.utility.NegocioException;

public class EmpresaService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private DAO<Empresa> dao;

    public void salvar(Empresa empresa) throws NegocioException {
        if (empresa.getNome() == null || empresa.getNome().length() < 3) {
            throw new NegocioException("A razão social da empresa deve ter pelo menos 3 caracteres.");
        }

        dao.salvar(empresa);
    }

    public void remover(Empresa empresa) throws NegocioException {
        dao.remover(Empresa.class, empresa.getId());
    }

    public List<Empresa> todasAsEmpresas() {
        return dao.buscarTodos("SELECT e FROM Empresa e ORDER BY e.nome");
    }
}
