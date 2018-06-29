package com.maveric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maveric.getset.getsetclass;
import com.maveric.service.logicclass;

@Controller
public class controllerclass {
	
	@Autowired
	private logicclass logobj;
	
	@RequestMapping(value="/")
	public String Register(Model modobj)
	{
		modobj.addAttribute("getsetclass", new getsetclass());
		System.out.println("Hello dispatcher servlet");
		return "Registration";
	}
	
	@RequestMapping(value="/registerProcess")
	
	public String registerProcess(getsetclass getse)
	{
		String login =  null;
		
		boolean result = logobj.compare(getse);
		if (result)
		{
			System.out.println("credentials are proper");
			
			login = "Login";
		}
		else
		{
			 login = "Registration";
		}
		
		return login;
		
		
	}
	@RequestMapping(value="/LoginProcess")
	public String LoginProcess(getsetclass getse)
	{
		
		boolean result1 = logobj.login(getse);
		if (result1)
		{
			System.out.println("Login passed");
		}
		else 
		{System.out.println("Login Failed");}
		
		return null;
		
		
	}
	

}
