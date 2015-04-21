package com.sgc.daos;

import javax.ejb.Stateless;

import com.sgc.models.Pessoa;

@Stateless
public class PessoaDao extends BaseDao<Pessoa> {

	public PessoaDao() {
		super(Pessoa.class);
	}
}
