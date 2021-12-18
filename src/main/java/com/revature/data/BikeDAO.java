package com.revature.data;

import java.util.Set;

import com.revature.models.Bike;

public interface BikeDAO extends GenericDAO<Bike> {
	public Set<Bike> getByColor(String color);
	public Set<Bike> getByBrand(String brand);
}
