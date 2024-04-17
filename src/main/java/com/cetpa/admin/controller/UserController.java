package com.cetpa.admin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.entity.User;
import com.cetpa.admin.service.UserService;

@Controller
@RequestMapping("admin/user/manage")
public class UserController 
{
	@Autowired private UserService userService;
	
	@RequestMapping("list")
	public String getUserDashboard(Model model)
	{
		List<User> userList=userService.getList();
		model.addAttribute("ulist",userList);
		return "admin/user/user-list";
	}
	@RequestMapping("add")
	public String getAddUserView(Model model)
	{
		model.addAttribute("user",new User());
		return "admin/user/add-user";
	}
	@RequestMapping("save-record")
	public String saveUserRecord(User user,Model model)
	{
		if(!userService.createUserAccount(user))
		{
			model.addAttribute("user",user);
			model.addAttribute("msg","User already exists...");
			return "admin/user/add-user";
		}
		return "redirect:list";
	}
}
