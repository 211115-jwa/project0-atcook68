package com.revature.data;

import java.util.Set;

import com.revature.models.Bike;

public interface GenericDAO<D> {
	
	public Set<D> getAll();
	public void update(D dataToUpdate);
	public int create(D dataInput);
	public D getById(int id);
	public void delete(D dataToDelete);
	public Set<D> getByBrand(String brand);
	public Set<D> getByModel(String model);
	public Set<D> getByColor(String color);
	public Set<D> getByStatus(String status);
	
	
}
