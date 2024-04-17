package com.cetpa.utility;

import java.time.LocalTime;

public class Utility 
{
	public static String getCurrentTime()
	{
		LocalTime lt=LocalTime.now();
		String time=lt.getHour()+":"+lt.getMinute()+":"+lt.getSecond();
		return time;
	}
	public static String getTotalTime(String intime, String outtime)
	{
		int ins=getTimeInSeconds(intime);
		int ous=getTimeInSeconds(outtime);
		int tts=ins-ous;
		int m=tts/60;
		int s=tts%60;
		String total=m+"min and "+s+"sec"; 
		return total;
	}
	public static int getTimeInSeconds(String time)
	{
		String[] x=time.split(":");
		int total=Integer.parseInt(x[0])*3600+Integer.parseInt(x[1])*60+Integer.parseInt(x[2]);
		return total;
	}
}
