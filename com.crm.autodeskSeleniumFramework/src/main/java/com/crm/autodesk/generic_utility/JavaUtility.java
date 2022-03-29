package com.crm.autodesk.generic_utility;

import java.util.Date;
import java.util.Random;
/**
 * this is used for java specific method
 * @author Prathith paul
 * 
 */
public class JavaUtility {
	/**
	 * it is used for generating random number
	 * @return int data 
	 * @author Prathith paul
	 */

	public int getrandomnumber() {
		Random ram=new Random();
		int randomnum = ram.nextInt(10000);
		return randomnum;
	}
	/**
	 * @author Prathith paul
	 * it is used to get system date and time
	 * @return string
	 */
	public String getsystemDateandTime() {
		Date date=new Date();
		return date.toString();
	}
	/**
	 * @author Prathith paul
	 * it is used get the system date and time in YYYY-MM-DD
	 * @return String
	 */
	public String getsystemDateandTimeFormat() {
		Date date=new Date();
		String DateandTime=date.toString().replace(":", "-");

		String year = DateandTime.split(" ")[5];
		String dd = DateandTime.split(" ")[2];
		int month = date.getMonth()+1;

		String finalformat= year+"-"+0+month+"-"+dd;
		System.out.println(finalformat);
		return finalformat;
	}   








}