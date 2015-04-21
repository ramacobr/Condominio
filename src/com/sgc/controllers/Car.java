package com.sgc.controllers;

public class Car {

	private String Id;
	private String Brand;
	private String Color;
	private int Year;
	private int Price;
	private boolean SoldState;
	
	public Car(String Id, String Brand, int Year, String Color, int Price, boolean SoldState) {
		this.Id = Id;
		this.Brand = Brand;
		this.Year = Year;
		this.Color = Color;
		this.Price = Price;
		this.SoldState = SoldState;
	}
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public boolean isSoldState() {
		return SoldState;
	}
	public void setSoldState(boolean soldState) {
		SoldState = soldState;
	}
}
