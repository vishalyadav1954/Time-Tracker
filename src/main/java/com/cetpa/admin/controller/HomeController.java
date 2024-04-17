package com.cetpa.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class HomeController 
{
	@RequestMapping("")
	public String getHomeView(HttpSession ses)
	{
		if(ses.getAttribute("user")==null)
		{
			return "redirect:/admin/login";
		}
		return "admin/home";
	}
}
