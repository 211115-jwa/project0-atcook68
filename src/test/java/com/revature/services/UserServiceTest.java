package com.revature.services;

import java.util.Set;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.data.BikeDAO;
import com.revature.service.UserService;
@ExtendWith (MockitoExtension.class)
public class UserServiceTest {
	@Mock
	private BikeDAO bikeDao;
	@InjectMocks
	private UserService userServ = UserServiceImpl();
	private static Set<Bike> mockAvailableBikes;
	
	
	
}
