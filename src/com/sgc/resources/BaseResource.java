package com.sgc.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

public abstract class BaseResource<T>  {
	
	@GET
	@Path("{id}")
	public T read(@PathParam("id") int id) {
		return null;
	}
	@GET
	@Path("all")
	public void readAll() {
	}
	@POST
	@Path("create")
	public void create() {
	}
	@PUT
	@Path("update")
	public void update() {
	}
	@DELETE
	@Path("delete")
	public void delete() {
	}

}
