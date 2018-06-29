package com.maveric.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.maveric.db.dbclass;
import com.maveric.getset.getsetclass;

@Service
public class logicclass {
	
	@Autowired
	 dbclass dbc;
	
	
	boolean result = false;
	boolean result1 = false;
	public boolean compare (getsetclass modelobj)
	{
		if ((modelobj.getname().length()>4) && (modelobj.getPassword().length()>5)&& (modelobj.getconfirmpassword().length()>5)&& (modelobj.getEmail().length()>5)) {
		
		if (modelobj.getPassword().equalsIgnoreCase(modelobj.getconfirmpassword()))
		{
			 
			System.out.println("entered passcode");
			int resu = dbc.Checkreg(modelobj);
			if (resu > 0 )
			{
				System.out.println("Email ID is already in use");
			}else
			{
				
				dbc.addregistertodb(modelobj);
				result = true;
				
			}
			
		}
		else {System.out.println("Password mismatch");}
		}
		else {
			System.out.println("All fields are mandatory");
		}
		
		return result;
		
		
		
	}
	
	public boolean login (getsetclass modelobj) 
	
	{
		int resdb = dbc.LoginCheck(modelobj);
		if (resdb > 0)
		{
			result1 = true;
			
		}
		else
		{
			System.out.println("Login Failed");
		}
		return result1;
		
	}
     
}
