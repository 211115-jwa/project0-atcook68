package com.revature.app;

import io.javalin.Javalin;
import io.javalin.http.HttpCode;
import static io.javalin.apibuilder.ApiBuilder.*;	// static path import


import java.util.Set;
public class App {

	public static void main(String[] args) {
		
		Javalin app = Javalin.create().start(8080);
		
		app.start();
		app.routes(() -> {
			
			path("/bike", () -> {;
			
				get(ctx -> {
					Set<Bike> bike = userServ.viewAvailableBike();
					if (bike != null) {
						ctx.json(bike);
					}
				})
		});
		
		
		
	}

}

	
	/*
	 what endpoints do we need?
	 in other words, what actions would a user need to do
	 and what address + HTTP method combo would represent
	 each of those actions?
	 (in your p0, these endpoints are provided to you.)
	*/