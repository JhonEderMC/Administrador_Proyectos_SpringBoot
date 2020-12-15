package com.konecta.proyectos.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


import javax.servlet.http.HttpSession;




import com.konecta.proyectos.model.User;



public class Util {
	
	
	/**
	 * Method for check use login data
	 * @param name 
	 * @param password
	 * @param users
	 * @param session
	 * @return 
	 */
	public static String [] checkLogin(String name, String password,List<User> users, HttpSession session) {
		String[] login = new String[2];
		for(User user: users) { //list
			login[0]="Credenciales incorrectas!"; //default
			login[1]="False";			
			if (user.getName().equalsIgnoreCase(name)) { //name				
				if(user.getPassword().equals(password)) { //password									
					if(user.getState().equals("Activo")) { 
						login[1]="True";
						session.setAttribute("id", user.getId());
						return login;
					}					
				}
			}
		}
		return login;
		
	}
	
	/**
	 * return date with format
	 */
	public static Date  newDateToday() {
		Calendar cal = new GregorianCalendar();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setTimeZone(cal.getTimeZone());	
		//System.out.println(dateFormat.format(cal.getTime()));
		try {
			///return dateFormat.parse(dateFormat.format(cal.getTime()));
			return new SimpleDateFormat("dd-MM-yyyy").parse(dateFormat.format(cal.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	


}
