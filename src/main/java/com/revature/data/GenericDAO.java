package com.revature.data;

import java.util.Set;

import com.revature.beans.Bike;

public interface GenericDAO<D> {
	
	public Set<DAO> getAll();
	public void update(D dataToUpdate);
	public int create(Bike dataInput);
	public int getById(int id);
	public void delete(D dataToDelete);
}
