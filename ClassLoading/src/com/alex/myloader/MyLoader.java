package com.alex.myloader;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.log4j.Logger;

public class MyLoader extends ClassLoader {

	private static Logger logger = Logger.getLogger("LoadingLogger");

	public static String DIR; 
	public static String CLASS_PASS; 

	/**
	 * 
	 * @param parent
	 */
	public MyLoader(ClassLoader parent) {
		super(parent);

	}

	/**
	 * 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Class findClass(String name) throws ClassNotFoundException {
		Class loadedClass = findLoadedClass(name);

		if (loadedClass == null) {

			try {
				@SuppressWarnings("resource")
				JarFile jarFile = new JarFile(DIR);
				JarEntry entry = jarFile.getJarEntry(CLASS_PASS);

				java.io.InputStream is = jarFile.getInputStream(entry); 
				
				DataInputStream dS = new DataInputStream(is);
				byte[] classBytes = new byte[(int) entry.getSize()];
				dS.readFully(classBytes);

				loadedClass = defineClass(name, classBytes, 0,
						classBytes.length);

			} catch (IOException e) {
				logger.error("Error ))): " + e);
			}

		}

		return loadedClass;
	}

	public static String getClassName(String classPass) {

		classPass.replaceAll("/", ".").replaceFirst(".class", "");

		return classPass.replaceAll("/", ".").replaceFirst(".class", "");
	}

}
