package com.sgc.daos;

import javax.ejb.Stateless;

import com.sgc.models.CEP;

@Stateless
public class CEPDao extends BaseDao<CEP> {

	public CEPDao() {
		super(CEP.class);
	}
}
