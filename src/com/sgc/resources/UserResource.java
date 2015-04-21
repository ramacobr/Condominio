package com.sgc.resources;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.sgc.daos.UserDao;
import com.sgc.models.User;

@Path("users")
public class UserResource {

    @Context
    private UriInfo context;
    
    @EJB
    private UserDao userDao;
    
    /**
     * Default constructor. 
     */
    public UserResource() {
    }
    
 	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsersJson() {
    	return userDao.ListAll();
    }
 	
 	@GET
 	@Produces(MediaType.APPLICATION_JSON)
 	@Path("{name}")
 	public User getUserJsonFromName(@PathParam("name")String name) {
 		User userResult = null;
 		for (User u : userDao.ListAll()) {
			if (u.getName().equals(name)) {
				userResult = u;
				break;
			}
		}
 		return userResult;
 	}
    
 	@Path("/create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postUserJson(User user) {
    	long userId = userDao.save(user).getId();
    	return Response.ok(userId).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response postUserForm(@FormParam("login") String login, @FormParam("name") String name) {
    	User u = new User();
    	u.setName(name);
    	u.setLogin(login);
    	long userId = userDao.save(u).getId();
    	return Response.ok(userId).build();
    }
    
    /**
     * PUT method for updating or creating an instance of UserResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putUserJson(User user) {
    	userDao.save(user);
    }
    
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void delUserJson(User user) {
    	userDao.remove(user);
    }
}