package com.infosys.practice.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.practice.UserData;

@RestController
public class SaveDataController 
{
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String Data(@RequestBody UserData userData) 
	{
		System.out.println("user data"+userData);
		
		//jdbc  table insert 
		
		return "success";
}
}
