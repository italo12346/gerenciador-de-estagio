package com.ifpb.estagio.converter;

import javax.enterprise.context.Dependent;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import com.ifpb.estagio.dao.DAO;
import com.ifpb.estagio.model.Empresa;

@FacesConverter(forClass = Empresa.class)
@Dependent
public class EmpresaConverter implements Converter {
	@Inject
	private DAO<Empresa> dao;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty()) {
			return null;
		}

		try {
			Long id = Long.parseLong(value);
			return dao.buscarPorId(Empresa.class, id);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Invalid value: " + value, e);
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return "";
		}

		if (value instanceof Empresa) {
			return String.valueOf(((Empresa) value).getId());
		} else {
			throw new IllegalArgumentException("Invalid object type: " + value.getClass());
		}
	}
}
