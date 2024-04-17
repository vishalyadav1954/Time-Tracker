package com.cetpa.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.admin.service.UserService;
import com.cetpa.entity.User;

@Controller
@RequestMapping("user/login")
public class UserLoginController 
{
	@Autowired private UserService userService;
	
	@RequestMapping("")
	public String getLoginView(HttpSession ses)
	{
		if(ses.getAttribute("user")!=null)
		{
			return "redirect:/user";
		}
		return "user/login";
	}
	@RequestMapping("authenticate-user")
	public String authenticateUser(String userid,String password,Model model,HttpSession ses)
	{
		User user=userService.getUserById(userid);
		if(user!=null)
		{
			String dbpassword=user.getPassword();
			if(password.equals(dbpassword))
			{
				ses.setAttribute("user",user.getName());
				return "redirect:/user";
			}
			else
				model.addAttribute("msg","Entered password is wrong");		
		}
		else
			model.addAttribute("msg","Entered userid does not exist");
		model.addAttribute("id",userid);
		return "user/login";
	}
	@RequestMapping("logout")
	public String signOut(HttpSession ses)
	{
		if(ses.getAttribute("user")==null)
		{
			return "redirect:/user";
		}
		ses.invalidate();
		return "user/login";
	}
}
