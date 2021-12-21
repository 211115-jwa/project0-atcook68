package com.revature.app;

import io.javalin.Javalin;
import io.javalin.http.HttpCode;
import static io.javalin.apibuilder.ApiBuilder.*; // static path import
//import static io.javalin.apibuilder.ApiBuilder.get;
//import static io.javalin.apibuilder.ApiBuilder.path;
//import static io.javalin.apibuilder.ApiBuilder.post;
//import static io.javalin.apibuilder.ApiBuilder.put;
import com.revature.models.Bike;
import com.revature.service.UserService;
import com.revature.service.UserServiceImpl;
import java.util.Set;
import org.eclipse.jetty.http.HttpStatus;

public class App {
	private static UserService userServ = new UserServiceImpl();

	public static void main(String[] args) {
		Javalin app = Javalin.create();
		
		app.start();
		app.routes(() -> {		// nesting the paths to make it cleaner
			
			path("/bike", () -> {
			
				get(ctx -> {
					String brandSearch = ctx.queryParam("brand");
					if (brandSearch != null && !"".equals(brandSearch)) {
						Set<Bike> bikeFound = userServ.getBikeByBrand(brandSearch);
						ctx.json(bikeFound);
					}else {
						Set<Bike> bike = userServ.viewAvailableBikes();
						ctx.result("No available bikes");
					}});
				post(ctx -> {
					Bike newBike = ctx.bodyAsClass(Bike.class);
					if (newBike != null) {
						userServ.addNewBike(newBike);
						ctx.status(HttpStatus.CREATED_201);
					}else {
						ctx.status(HttpStatus.BAD_REQUEST_400);
					}
					});
				path("bike/by/{id}",() ->{
					get(ctx ->{
						try {
							int bikeId = Integer.parseInt(ctx.pathParam("id"));
							Bike bike = userServ.getBikeById(bikeId);
							if(bike != null)
								ctx.json(bike);
							else
								ctx.status(404);
						}catch (NumberFormatException e) {
							ctx.status(400);
						}
					});
				put(ctx ->{
					try {
						int bikeId = Integer.parseInt(ctx.pathParam("id"));
						Bike bikeToEdit = ctx.bodyAsClass(Bike.class);
						if (bikeToEdit != null && bikeToEdit.getId() == bikeId) {
							bikeToEdit = userServ.updateBike(bikeToEdit);
							if(bikeToEdit != null)
								ctx.json(bikeToEdit);
							else {
								ctx.status(404);
								ctx.result("Id doesn't exist.");
							}
						}else {
								ctx.status(HttpCode.CONFLICT);
						}}catch(NumberFormatException e) {
							ctx.status(400);
							ctx.result("Invalid, enter a number");
						}
					});
				});
				path("/bike?brand=",() ->{
					get(ctx ->{
						String bikeBrand = ctx.queryParam("brand");
						if (bikeBrand != null && !"".equals(bikeBrand)) {
							Set<Bike> bikesFound = userServ.getBikeByBrand(bikeBrand);
							ctx.json(bikesFound);
						}else {
							Set<Bike> bikesfound = userServ.viewAvailableBikes();
							
							ctx.json(bikesfound);
							}
						});
				});
				path("/bike?Color=",() ->{
					get(ctx ->{
						String bikeColor = ctx.queryParam("bikeColor");
						if (bikeColor != null && !"".equals(bikeColor)) {
							Set<Bike> bikesFound = userServ.getBikeByColor(bikeColor);
							ctx.json(bikesFound);
						}else {
							Set<Bike> bikesFound = userServ.viewAvailableBikes();
							ctx.json(bikesFound);
						}
					});
				});
			});
		});
	}}		
				
				
	
	/*
	 what endpoints do we need?
	 in other words, what actions would a user need to do
	 and what address + HTTP method combo would represent
	 each of those actions?
	 (in your p0, these endpoints are provided to you.)
	*/
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			