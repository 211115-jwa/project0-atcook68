package com.revature.beans;

import java.util.Objects;

public class Bike {
	private int id;
	private int year;
	private String brand;
	private String model;
	private String color;
	
	public Bike() {
		id = 0;
		year = 0;
		brand = "Brand";
		model = "Model";
		color = "Color";
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public int hashCode() {
		return Objects.hash(brand, color, id, model, year);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bike other = (Bike) obj;
		return Objects.equals(brand, other.brand) && Objects.equals(color, other.color) && id == other.id
				&& Objects.equals(model, other.model) && year == other.year;
	}
	@Override
	public String toString() {
		return "Bike [id=" + id + ", year=" + year + ", brand=" + brand + ", model=" + model + ", color=" + color + "]";
	}
}
