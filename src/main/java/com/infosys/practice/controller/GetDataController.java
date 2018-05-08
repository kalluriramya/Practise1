package com.infosys.practice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.practice.UserData;

@RestController
public class GetDataController 
{
	@RequestMapping(value = "/getdata", method = RequestMethod.GET)
	public List<UserData> getData()
	{
		List<UserData> users= new ArrayList<UserData>();
		UserData u1 = new UserData();
		u1.setAddress("Hyderabad");
		u1.setSalary(10000);
		u1.setUname("Ramya");
		
		UserData u2 = new UserData();
		u1.setAddress("Guntur");
		u1.setSalary(20000);
		u1.setUname("Ram");
		
		users.add(u1);
		users.add(u2);
		
		//jdbc loginc for ertrevie
		
		return users;
	}
	
	//
	
	
}
