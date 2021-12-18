package com.revature.data;

import java.util.Set;

public interface GenericDAO<D> {
	
	public Set<D> getAll();
	public void update(D dataToUpdate);
	public int create(D dataToAdd);
	public D getById(int id);
	public void delete(D dataToDelete);
}
