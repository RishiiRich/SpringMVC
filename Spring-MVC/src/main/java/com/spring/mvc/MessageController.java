package com.spring.mvc;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MessageController {
	
	@RequestMapping("/message")
	public ModelAndView getmessage()
	{
		String msg="Rishi Arora";
		return new ModelAndView("hellopage","msg",msg);
		
	}
	
	
	@RequestMapping("/login222")
	public ModelAndView authenticateLogin(HttpServletRequest request,HttpServletResponse response)
	{
		String name=request.getParameter("txtuname");
		String pwd=request.getParameter("txtpwd");
		
		if(pwd.equalsIgnoreCase("ADMIN"))
		{
			String msg="Hello "+ name;
			return new ModelAndView("Success","message",msg);
		}
		else
		{
			return new ModelAndView("error","message","Wrong Username or Password");
		}
	}

}
