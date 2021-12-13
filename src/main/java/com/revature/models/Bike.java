package com.revature.models;

import java.util.Objects;

public class Bike {
	private int id;
	private int year;
	private String name;
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
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public int hashCode() {
		return Objects.hash(color, id, name, year);
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
		return Objects.equals(color, other.color) && id == other.id && Objects.equals(name, other.name)
				&& year == other.year;
	}
	@Override
	public String toString() {
		return "Bike [id=" + id + ", year=" + year + ", name=" + name + ", color=" + color + "]";
	}
	
}
