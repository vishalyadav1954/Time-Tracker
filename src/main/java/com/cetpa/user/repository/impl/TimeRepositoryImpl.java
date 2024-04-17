package com.cetpa.user.repository.impl;

import org.hibernate.*;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.cetpa.entity.TimeInfo;
import com.cetpa.user.repository.TimeRepository;

@Repository
public class TimeRepositoryImpl implements TimeRepository
{
	private Session session;
	private Transaction transaction;
	
	public TimeRepositoryImpl(SessionFactory factory)
	{
		session=factory.openSession();
		transaction=session.getTransaction();
	}
	public void saveOuttime(TimeInfo timeInfo) 
	{
		transaction.begin();		
		session.persist(timeInfo);
		transaction.commit();
	}
	public TimeInfo getTimeInfo(int eid) 
	{
		Query<TimeInfo> query=session.createQuery("from TimeInfo where eid=:arg1 and intime=:arg2",TimeInfo.class);
		query.setParameter("arg1",eid);
		query.setParameter("arg2","Not in yet");
		return query.uniqueResult();
	}
	public void updateIntime(String intime, String totaltime,TimeInfo timeInfo)
	{
		transaction.begin();
		timeInfo.setIntime(intime);
		timeInfo.setTotaltime(totaltime);
		transaction.commit();
	}
}
