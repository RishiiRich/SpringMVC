package com.spring.mvc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dataaccess.UserDAO;

@Controller
public class LoginController {

	@RequestMapping("/Login")
	public ModelAndView AuthenticateUser(HttpServletRequest request,HttpServletResponse response)
	{
		//JdbcTemplate jdbctemplate=null;
		
		String name=request.getParameter("txtuname");
		String pwd=request.getParameter("txtpwd");
		
		//String query="select * from user where id ="+name+"";
		
		List<User> user=new ArrayList<User>();
		
		User obj=new User();
		obj.setName(name);
		obj.setPwd(pwd);
		
		
		ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
		UserDAO dao=(UserDAO)context.getBean("LoginBean");
		user=dao.getUser(obj);
		
		
		for(User u:user)
		{
			
			if(name.equalsIgnoreCase(u.getName()) && pwd.equalsIgnoreCase(u.getPwd()))
			{
			
				return new ModelAndView("Success","message",u.getName());
			}
		/*	else
			{
				System.out.println("hey error");
				return new ModelAndView("error","message","Worng username and password");
			}*/
		}
	
		return new ModelAndView("error","message","Worng username and password");
		
	
	}

	

	
}
