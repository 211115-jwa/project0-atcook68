package com.revature.data;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Set;

import org.junit.jupiter.api.Test;

import com.revature.beans.Bike;
import com.revature.data.postgres.BikePostgres;

public class BikeDAOTest {
	private BikeDAO bikeDao = new BikePostgres();
	
	@Test
	public void create() {
		Bike dataInput = new Bike();
		int indexOutput = bikeDao.create(dataInput);
		assertNotEquals(0,indexOutput);
	}
	@Test
	public void getAll() {
		Set<com.revature.models.Bike> givenOutput = bikeDao.getAll();
		assertNotNull(givenOutput);
	}
}
