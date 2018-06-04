package com.healthec.generic;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateCheck 
{
	public static Date dt;
	public static Calendar mCalendar;
	public static LocalDate localDate;
	public static String date;
	public static String month_number;
	public static String date_day_number;
	public static String actual_date;

	public DateCheck(String date) throws Exception
	{
		String[] date1 = date.split("/");
		int month_num = Integer.parseInt(date1[0]);
		int date_day = Integer.parseInt(date1[1]);
		//System.out.println(month_num);
		
		       if(month_num<10)
		         {
			
			       month_number = "0"+month_num;
			       //System.out.println(month_number);
			       actual_date =month_number+"/"+date1[1]+"/"+date1[2];
			       System.out.println("Update month in Date: "+actual_date);
		          }
		       else{
			       actual_date = date;
			       System.out.println("Actual date: "+actual_date);
		          }
		          if(date_day<10)
				  {
					  date_day_number = "0"+date_day;
					  actual_date=month_number+"/"+date_day_number+"/"+date1[2];
					  System.out.println("Updated day in date: "+actual_date);

				  }

		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "MM/dd/yy" );
		localDate = LocalDate.parse( actual_date , formatter );
	}
	
	public int getDay()
	{
		int day = localDate.getDayOfMonth();
		return day;
	}
	public String getMonth()
	{
	String month_complete_name = Month.of(localDate.getMonthValue()).name();
	System.out.println("complete month name: "+month_complete_name);
	String month_name = ((month_complete_name.substring(0, 1).toUpperCase() + month_complete_name.substring(1,(month_complete_name.length())).toLowerCase()).substring(0, 3));
	return month_name;
	}
	public int getYear()
	{
	int year = localDate.getYear();
	return year;
	}

	public static void main(String[] args) throws Exception {
		
		DateCheck dt = new DateCheck("2/5/18");
		System.out.println("month: "+dt.getMonth());
		System.out.println("year: "+dt.getYear());
		System.out.println("day: "+dt.getDay());
		
	}
	
	
	}


