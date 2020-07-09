package com.micr0.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * @author Micr0 (iliq zlatanov)
 */
public final class Config
{
	protected static final Logger _log = Logger.getLogger(Config.class.getName());

	public static final String CONFIG = "Config.properties";
	public static String DATABASE_DRIVER;
	public static String DATABASE_URL;
	public static String DATABASE_LOGIN;
	public static String DATABASE_PASSWORD;
	
	@SuppressWarnings("null")
	public static void load()
	{
		
		_log.info("Конфигорационен файл...");
		InputStream is = null;
		try
		{
			try
			{
				Properties serverSettings = new Properties();
				is = new FileInputStream(new File(CONFIG));
				serverSettings.load(is);
				
				DATABASE_DRIVER = serverSettings.getProperty("Driver", "com.mysql.cj.jdbc.Driver");
				DATABASE_URL = serverSettings.getProperty("URL", "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
				DATABASE_LOGIN = serverSettings.getProperty("Login", "root");
				DATABASE_PASSWORD = serverSettings.getProperty("Password", "");
				
			}
			catch (Exception e)
			{
				e.printStackTrace();
				throw new Error("Failed to Load " + CONFIG + " File.");
			}
		}
		finally
		{
			try
			{
				is.close();
			}
			catch (Exception e)
			{
			}
		}
	}
}