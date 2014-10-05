package com.alex.loader;

import org.apache.log4j.Logger;

import com.alex.menu.*;
import com.alex.myloader.MyLoader;


public class Loader {
	private static Logger logger = Logger.getLogger("Loader");
	public static void main(String args[])
    {
		
	
		MyLoader.DIR= "d:\\myapp.jar";
		MyLoader.CLASS_PASS = "com/alex/myapp/MyApp.class";
		
		
		MyMenu.startMenu();
		
    }

}
