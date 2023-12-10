package com.ifpb.estagio.servic;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ifpb.estagio.dao.ConnectionFactory;
import com.ifpb.estagio.dao.DAO;
import com.ifpb.estagio.model.Empresa;
import com.ifpb.estagio.utility.NegocioException;

public class EmpresaService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private DAO<Empresa> dao;
    
    private static EntityManager manager = ConnectionFactory.getEntityManager();


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
    
    public List<Empresa> buscarEmpresasPorTermo(String termo) {
        String jpql = "SELECT e FROM Empresa e WHERE LOWER(e.nome) LIKE LOWER(:termo) ORDER BY e.nome";
        Query query = manager.createQuery(jpql, Empresa.class);
        query.setParameter("termo", "%" + termo + "%");
        return query.getResultList();
    }
}
