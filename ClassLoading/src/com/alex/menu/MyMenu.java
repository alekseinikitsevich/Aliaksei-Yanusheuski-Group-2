package com.alex.menu;

import java.lang.reflect.Method;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.alex.myapp.IMyApp;
import com.alex.myloader.*;


public class MyMenu {
	
	private static Logger logger = Logger.getLogger("Menu");
	private static String OPEN_MESSAGE = "Enter code id(1-4). For end enter \"x\"";
	private static String EXIT = "x";
	@SuppressWarnings("rawtypes")

	private static Class clazz;
	
	
	public static void startMenu(){
	
		String id = " "; 
		Scanner scanner = new Scanner( System.in );

		try {
			getInfo();
		} catch (Exception e) {
			logger.error("Error ))) : "+e);
		}
		
		while (!id.equalsIgnoreCase(EXIT)){

			logger.info(OPEN_MESSAGE);
			
			try {
				id = scanner.nextLine();
				logger.info("CODE:"+ invoke(id));
			
			} catch (Exception e) {
				logger.error("Error ))) : "+e);
			
			}
		}
	}
	private static void getInfo() throws Exception{
		
		ClassLoader loader = new MyLoader(ClassLoader.getSystemClassLoader());
				 clazz = loader.loadClass(MyLoader.getClassName(MyLoader.CLASS_PASS));
		
		Method[] methods = clazz.getMethods(); 
		logger.info("ClassName: "+clazz.getName() );
		logger.info("Open Methods: " );
		for (Method method : methods) { 
			logger.info("Name: " + method.getName());
			
		} 
		logger.info(" " );
	}
	private static String invoke(String id) throws Exception{
	
		
		IMyApp instanse = (IMyApp) clazz.newInstance();
		
		
		
		
		return instanse.getCode(id);
	}
}
