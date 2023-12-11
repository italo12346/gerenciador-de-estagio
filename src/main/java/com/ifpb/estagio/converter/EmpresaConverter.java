package com.ifpb.estagio.converter;

import java.util.logging.Logger;

import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

import com.ifpb.estagio.dao.DAO;
import com.ifpb.estagio.model.Empresa;

@Named  // Adicione a anotação Named
@FacesConverter(forClass = Empresa.class)
@ViewScoped 
public class EmpresaConverter implements Converter {
    private static final Logger logger = Logger.getLogger(EmpresaConverter.class.getName());

    @Inject
    private DAO<Empresa> dao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }

        try {
            Long id = Long.parseLong(value);
            logger.info("ID para busca: " + id);

            if (dao == null) {
                logger.warning("Injeção de dependência 'dao' é nula!");
               
                return null;
            }

            Empresa empresa = dao.buscarPorId(Empresa.class, id);
            logger.info("Empresa encontrada: " + empresa);

            return empresa;
        } catch (NumberFormatException e) {
            logger.severe("Erro ao converter para objeto. Valor inválido: " + value);
            throw new IllegalArgumentException("Invalid value: " + value, e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }

        if (value instanceof Empresa) {
            String id = String.valueOf(((Empresa) value).getId());
            logger.info("ID convertido para String: " + id);
            return id;
        } else {
            logger.severe("Tipo de objeto inválido: " + value.getClass());
            throw new IllegalArgumentException("Invalid object type: " + value.getClass());
        }
    }
}
