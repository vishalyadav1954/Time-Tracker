package com.cetpa.user.service.impl;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.admin.repository.EmployeeRespository;
import com.cetpa.entity.TimeInfo;
import com.cetpa.user.repository.TimeRepository;
import com.cetpa.user.service.TimeService;
import com.cetpa.utility.Utility;

@Service
public class TimeServiceImpl implements TimeService
{
	@Autowired private TimeRepository timeRepository;
	@Autowired private EmployeeRespository employeeRespository;

	public void recordOuttime(int eid) 
	{
		TimeInfo timeInfo=new TimeInfo();
		timeInfo.setEid(eid);
		timeInfo.setDate(LocalDate.now());
		timeInfo.setOuttime(Utility.getCurrentTime());
		timeRepository.saveOuttime(timeInfo);
		employeeRespository.updateStatus("out",timeInfo.getEid());
	}
	public void updateIntime(int eid) 
	{
		TimeInfo timeInfo=timeRepository.getTimeInfo(eid);
		String intime=Utility.getCurrentTime();
		String outtime=timeInfo.getOuttime();
		String totaltime=Utility.getTotalTime(intime,outtime);
		timeRepository.updateIntime(intime,totaltime,timeInfo);
		employeeRespository.updateStatus("in",eid);
	}
}
