package com.revature.service;

import java.util.Set;

import com.revature.data.BikeDAO;
import com.revature.data.postgres.BikePostgres;
import com.revature.models.Bike;

public class UserServiceImpl implements UserService{

	private BikeDAO bikeDao = new BikePostgres();
	
	
	@Override
	public Bike getBikeById(int id) {
		return bikeDao.getById(id);
	}
	@Override
	public int addNewBike( Bike newBike) {
		return bikeDao.create(newBike);
		}
	@Override
	public Set<Bike> getBikeByBrand(String brand){
		return bikeDao.getByBrand(brand);
	}
	@Override
	public Set<Bike> getBikeByColor(String color){
		return bikeDao.getByColor(color);
	}
	@Override
	public Bike updateBike(Bike BikeToEdit) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Set<Bike> getBikeByModel(String bikeModel) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Set<Bike> getBikeByStatus(String bikeStatus) {
		return bikeDao.getByStatus("Available");
	}
	@Override
	public Set<Bike> viewAvailableBikes() {
		return bikeDao.getByStatus("Available");
	}
	@Override
	public Set<Bike> getAll() {
		return bikeDao.getAll();
	}

}
