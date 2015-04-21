package com.sgc.daos;

import javax.ejb.Stateless;

import com.sgc.models.Endereco;

@Stateless
public class EnderecoDao extends BaseDao<Endereco> {

	public EnderecoDao() {
		super(Endereco.class);
	}
}
