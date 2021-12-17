package com.revature.services;
	import static org.junit.jupiter.api.Assertions.*;
	import static org.mockito.Mockito.doNothing;
	import static org.mockito.Mockito.times;
	import static org.mockito.Mockito.verify;
	import static org.mockito.Mockito.when;

	import java.util.HashSet;
	import java.util.Set;

	import org.junit.jupiter.api.BeforeAll;
	import org.junit.jupiter.api.Test;
	import org.junit.jupiter.api.extension.ExtendWith;
	import org.mockito.InjectMocks;
	import org.mockito.Mock;
	import org.mockito.Mockito;
	import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.data.BikeDAO;
import com.revature.data.PersonDAO;	
	
	
	// telling JUnit that we're using 
@ExtendWith(MockitoExtension.class)
public class BikeServiceTest {
	@Mock
	private BikeDAO bikeDao;
	@Mock
	private PersonDAO personDao;
		
		@Test
		public void searchByBrandExists() {
			String species = "schwin";		// bike brand
			
			when(BikeDAO.getByStatus("Available")).thenReturn(mockAvailableBikes);
			
			// Trying to see if the (species) are not 
			List(Bike) actualSchwin = bikeServ.searchBikesByBrand(species);
			boolean onlyCats = true;
			for (Bike bike : actual) {		// Set
				if (!bike.getBrand().equals(schwin))
					onlyCats = false;
	}
}
