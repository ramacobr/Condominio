package com.sgc.daos;

import javax.ejb.Stateless;
import com.sgc.models.User;

@Stateless
public class UserDao extends  BaseDao<User> {

	public UserDao() {
		super(User.class);
	}
}
