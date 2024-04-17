package com.cetpa.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.admin.service.EmployeeService;
import com.cetpa.entity.Employee;
import com.cetpa.entity.TimeInfo;
import com.cetpa.user.service.TimeService;

@Controller
@RequestMapping("user/manage/time")
public class TimeController 
{
	@Autowired private EmployeeService employeeService;
	@Autowired private TimeService timeService;
	private String na;
	private int eid;
	
	@RequestMapping("out")
	public String getEmployeeNameInList(Model model)
	{
		List<Employee> empList=employeeService.getList("in");
		model.addAttribute("elist",empList);
		return "user/time/out/employee-list";
	}
	@RequestMapping("record-outtime")
	public String recordEmployeeOuttime(String name,Model model)
	{
		getNameAndEid(name);
		timeService.recordOuttime(eid);
		model.addAttribute("name",na);
		return "user/time/out/record-outtime";
	}
	@RequestMapping("in")
	public String getEmployeeNameOutList(Model model)
	{
		List<Employee> empList=employeeService.getList("out");
		model.addAttribute("elist",empList);
		return "user/time/in/employee-list";
	}
	@RequestMapping("update-intime")
	public String updateEmployeeIntime(String name,Model model)
	{
		getNameAndEid(name);
		timeService.updateIntime(eid);
		model.addAttribute("name",na);
		return "user/time/in/update-intime";
	}
	private void getNameAndEid(String name)
	{
		na=name.substring(0,name.indexOf('('));
		eid=Integer.parseInt(name.substring(name.indexOf('(')+1,name.indexOf(')')));
	}
}
