package com.sgc.daos;

import javax.ejb.Stateless;

import com.sgc.models.Logradouro;

@Stateless
public class LogradouroDao extends BaseDao<Logradouro> {

	public LogradouroDao() {
		super(Logradouro.class);
	}
}
