package com.revature.service;

import java.util.Set;

import com.revature.data.BikeDAO;
import com.revature.data.postgres.BikePostgres;
import com.revature.models.Bike;

public class UserServiceImpl implements UserService{

	private BikeDAO bikeDao = new BikePostgres();
	
	@Override
	public int addNewBike( Bike newBike) {
		return BikeDAO.create(newBike);
		
	@Override
	public Bike updateBike(Bike bikeToEdit) {
		Bike bikeFromDatabase = bikeDao.getById(bikeToEdit.getId());
		if (bikeFromDatabase != null) {
			bikeDao.update(bikeToEdit);
			return bikeDao.getById(bikeToEdit.getId());
		}
		return null;
		}
	}
	@Override
	public Bike getBikeById(int id) {
		return bikeDao.getById(id);
	}	
	@Override
	public Set<Bike> viewAvailableBikes(){
		return bikeDao.getAll();
	}
	@Override
	public Set<Bike> getBikeByBrand(String brand){
		return bikeDao.getByBrand(brand);
	}
	@Override
	public Set<Bike> getBikeByColor(String color){
		return bikeDao.getByColor(color);
	}
}
