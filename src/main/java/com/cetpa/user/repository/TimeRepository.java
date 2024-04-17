package com.cetpa.user.repository;

import java.time.LocalDate;
import java.util.List;

import com.cetpa.entity.TimeInfo;

public interface TimeRepository 
{
	void saveOuttime(TimeInfo timeInfo);
	TimeInfo getTimeInfo(int eid);
	void updateIntime(String intime, String totaltime,TimeInfo timeInfo);
}
