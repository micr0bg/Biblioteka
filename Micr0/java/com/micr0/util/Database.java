package com.micr0.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Micr0 (iliq zlatanov)
 */
public class Database
{
	public static Connection getConnection()
	{
		try
		{
			Class.forName(Config.DATABASE_DRIVER); //com.mysql.cj.jdbc.Driver
			Connection con = DriverManager.getConnection(Config.DATABASE_URL, Config.DATABASE_LOGIN, Config.DATABASE_PASSWORD);
			return con;
		}
		catch (Exception ex)
		{
			System.out.println("Database.getConnection() Error -->" + ex.getMessage());
			return null;
		}
	}
	
	public static void close(Connection con)
	{
		try
		{
			con.close();
		}
		catch (Exception ex)
		{
		}
	}
}