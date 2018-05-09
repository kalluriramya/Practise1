package com.infosys.practice.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.practice.UserData;

@RestController
public class GetDataController 
{
	public static Connection conn; 
	public static Statement stmt; 
	public static ResultSet rset;
	
	@RequestMapping(value = "/getdata", method = RequestMethod.GET)
	public List<UserData> getData()
	{
		List<UserData> users= new ArrayList<UserData>();
	
		
		//jdbc login for retrieve
		try 
		{
			// Step1: Loading the PostgreSQL drivers 
			Class.forName("org.postgresql.Driver");
			
			// Step2: Establish the Database Connection 
			String dbURL = "jdbc:postgresql://localhost:5433/MyDB"; 
			String user = "postgres"; 
			String pass = "postgres"; 
			conn = DriverManager.getConnection(dbURL, user, pass);

			// Step3: Defining a statement object 
			stmt = conn.createStatement();
			
			// Step4: Execute the query to retrieve the data 
			String query = "Select no,uname,address,salary from student"; 
			rset = stmt.executeQuery(query);
			
			// Step5: Read the data from the result set 
			while (rset.next())
			{ 
				System.out.println( "Id: " + rset.getString(1) + "\t Name: " + rset.getString(2) + "\t Url: " + rset.getString(3));
				UserData user1=new UserData();
				user1.setId(rset.getInt(1));
				user1.setUname(rset.getString(2));
				user1.setAddress(rset.getString(3));
				user1.setSalary(rset.getInt(4));
				
				users.add(user1);
			}
	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	finally 
	{ 
		// Step6: Close all the objects 
		try { 
			rset.close(); 
			stmt.close(); 
			conn.close(); 
			}
		catch (SQLException e) 
		{ 
			e.printStackTrace(); 
		} 
		
	}
		return users;
	}
	
	@RequestMapping(value = "/getdata/{name}", method = RequestMethod.GET)
	public List<UserData> getDataByName(@PathParam("name") String name)
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
		//select slaary,name,id from user where name="+name
		//jdbc loginc for ertrevie
		
		return users;
	}
	
	//
	
	
}
