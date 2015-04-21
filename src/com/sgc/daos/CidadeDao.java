package com.sgc.daos;

import javax.ejb.Stateless;

import com.sgc.models.Cidade;

@Stateless
public class CidadeDao extends BaseDao<Cidade> {

	public CidadeDao() {
		super(Cidade.class);
	}
}
