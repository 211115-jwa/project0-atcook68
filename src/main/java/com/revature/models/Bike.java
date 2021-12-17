package com.revature.models;

import java.util.Objects;

public class Bike {
	private int id;
	private int year;
	private String brand;
	private String color;
	
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
	public String getName() {
		return brand;
	}
	public void setName(String name) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public int hashCode() {
		return Objects.hash(color, id, brand, year);
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
		return Objects.equals(color, other.color) && id == other.id && Objects.equals(brand, other.brand)
				&& year == other.year;
	}
	@Override
	public String toString() {
		return "Bike [id=" + id + ", year=" + year + ", brand=" + brand + ", color=" + color + "]";
	}
	
}
