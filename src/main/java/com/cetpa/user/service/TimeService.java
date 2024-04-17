package com.cetpa.user.service;

import com.cetpa.entity.TimeInfo;

public interface TimeService 
{
	void recordOuttime(int eid);
	void updateIntime(int eid);
}
