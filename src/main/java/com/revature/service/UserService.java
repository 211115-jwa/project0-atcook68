package com.revature.service;

import java.util.Set;

import com.revature.models.Bike;

public interface UserService {

	public int addNewBike(Bike newBike);
	public Bike getBikeById(int id);
	public Bike updateBike(Bike BikeToEdit);
	public Set<Bike> getBikeByBrand(String bikeBrand);
	public Set<Bike> getBikeByModel(String bikeModel);
	public Set<Bike> getBikeByColor(String bikeColor);
	public Set<Bike> viewAvailableBikes();
	
}
