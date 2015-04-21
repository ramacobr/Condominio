package com.sgc.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

import org.primefaces.event.ColumnResizeEvent;

import com.sgc.daos.UserDao;
import com.sgc.models.User;
 
@ManagedBean(name="UserController")
@ViewScoped
public class UserController implements Serializable {
    
	private static final long serialVersionUID = -151497351362583161L;
	
	private ListDataModel<User> users;
	private String name = "";
	private String login = "";
     
    @EJB
    private UserDao userService;
    
    @PostConstruct
    public void init() {
    	users = new ListDataModel<User>(userService.ListAll());
    }
    
    public ListDataModel<User> getUsers() {
        return users;
    }
    public String getName() {
		return name;
	}
    public void setName(String name) {
		this.name = name;
	}
    public String getLogin() {
		return login;
	}
    public void setLogin(String login) {
		this.login = login;
	}
    
    public void save() {
		User user = new User();
		user.setLogin(login);
		user.setName(name);
		userService.save(user);
	}
    
    public void onResize(ColumnResizeEvent event) {
        FacesMessage msg = new FacesMessage("Column " + event.getColumn().getClientId() + " resized", "W:" + event.getWidth() + ", H:" + event.getHeight());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
