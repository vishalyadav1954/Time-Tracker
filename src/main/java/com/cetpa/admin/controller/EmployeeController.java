package com.cetpa.admin.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.admin.service.EmployeeService;
import com.cetpa.entity.Employee;

@Controller
@RequestMapping("admin/employee/manage")
public class EmployeeController
{
	@Autowired private EmployeeService employeeService;
	
	@RequestMapping("list")
	public String getEmployeeDashboard(Model model)
	{
		List<Employee> empList=employeeService.getList();
		model.addAttribute("elist",empList);
		return "admin/employee/employee-list";
	}
	@RequestMapping("add")
	public String getAddEmployeeView()
	{
		return "admin/employee/add-employee";
	}
	@PostMapping("save-record")
	public String saveEmployeeRecord(Employee employee)
	{
		employeeService.saveRecord(employee);
		return "redirect:list";
	}
	@RequestMapping("delete-record")
	public String deleteEmployeeRecord(int eid)
	{
		employeeService.deleteRecord(eid);
		return "redirect:list";
	}
	@RequestMapping("edit-record")
	public String editEmployeeRecord(int eid,Model model)
	{
		Employee employee=employeeService.getRecord(eid);
		model.addAttribute("emp",employee);
		List<String> list=Arrays.asList("Training","Marketing","Accounts","Inventory","Sales","Human Resource");
		model.addAttribute("dlist",list);
		return "admin/employee/edit-employee";
	}
	@PostMapping("update-record")
	public String updateEmployeeRecord(Employee employee)
	{
		employeeService.updateRecord(employee);
		return "redirect:list";
	}
}
