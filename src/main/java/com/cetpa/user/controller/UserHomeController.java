package com.cetpa.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.admin.service.UserService;
import com.cetpa.entity.User;

@Controller
@RequestMapping("user")
public class UserHomeController 
{
	@RequestMapping("")
	public String getHomeView(HttpSession ses)
	{
		if(ses.getAttribute("user")==null)
		{
			return "redirect:/user/login";
		}
		return "user/home";
	}
}
