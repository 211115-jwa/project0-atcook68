package com.revature.data;

import java.util.Set;

import com.revature.models.Bike;

public interface BikeDAO {
	 
	public Bike getById(int id);
	public Set<Bike> getByColor(String color);
	public Set<Bike> getByBrand(String brand);
	public Set<Bike> getByModel(String model);
	public int create(Bike dataToAdd);
	public void update(Bike dataToUpdate);
	public void delete(Bike dataToDelete);
	public Bike getByID(int id);
}
