package com.sgc.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="dtSortView")
@ViewScoped
public class SortView implements Serializable {
    
   private static final long serialVersionUID = -706807249673488083L;
	
   private List<Car> cars1;
   private List<Car> cars2;
    
   @ManagedProperty("#{carService}")
   private CarService service;

   @PostConstruct
   public void init() {
       cars1 = service.createCars(10);
       cars2 = service.createCars(50);
   }

   public List<Car> getCars1() {
       return cars1;
   }

   public List<Car> getCars2() {
       return cars2;
   }

   public void setService(CarService service) {
       this.service = service;
   }
}
