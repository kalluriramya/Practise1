package com.infosys.practice.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.practice.UserData;
import com.infosys.practice.util.DBUtil;

@RestController
public class SaveDataController 
{
	public static Connection conn; 
	
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String Data(@RequestBody UserData userData) 
	{
		System.out.println("user data"+userData);
				
		//jdbc  table insert 	
		
		try 
		{
			// Step1: Loading the PostgreSQL drivers 
			conn=DBUtil.getConn();
			String sql="insert into student(no,uname,address,salary) values(?,?,?,?)";
			// Step3: Defining a statement object 
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, userData.getId());
			stmt.setString(2, userData.getUname());
			stmt.setString(3, userData.getAddress());
			stmt.setInt(4, userData.getSalary());
			
		      stmt.executeUpdate();
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	finally 
	{ 
		try { 
			
			conn.close(); 
			}
		catch (SQLException e) 
		{ 
			e.printStackTrace(); 
		} 
		
	}

		return "success";
}
}
