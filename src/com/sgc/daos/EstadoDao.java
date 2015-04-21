package com.sgc.daos;

import javax.ejb.Stateless;

import com.sgc.models.Estado;

@Stateless
public class EstadoDao extends BaseDao<Estado> {

	public EstadoDao() {
		super(Estado.class);
	}
}
