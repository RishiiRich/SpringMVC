package com.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	@RequestMapping("/welcome")
	public ModelAndView welcomemsg()
	{
		String msg="Welcome to MVC";
		return new ModelAndView("welcomepage","message",msg);
		
	}
}
