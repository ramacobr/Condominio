package com.sgc.daos;

import javax.ejb.Stateless;

import com.sgc.models.Pais;

@Stateless
public class PaisDao extends BaseDao<Pais> {

	public PaisDao() {
		super(Pais.class);
	}
}
