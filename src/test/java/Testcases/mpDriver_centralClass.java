package Testcases;


import Pages.ICD;
import Pages.Login_MP;
import packageDB.dbConnection;

public class mpDriver_centralClass {
	
	public static Login_MP getLogin_MP()
	{
		return new Login_MP();
	}
	public static ICD getICD()
	{
		return new ICD();
	}
	public static Excel getExcel()
	{
		return new Excel();
	}
	public static dbConnection getDbConnection()
	{
		return new dbConnection();
	}
}
