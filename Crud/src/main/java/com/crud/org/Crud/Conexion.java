package com.crud.org.Crud;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class Conexion 
{
	
  private String host="jdbc:mysql://localhost/usuarios?autoReconnect=true&useSSL=false";
	
  private String  usuario="root";
  
  private String pass="";
  
  public Connection con=null;
	
	public  Conexion()
	{
	
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con=(Connection) DriverManager.getConnection(host,usuario,pass);
			
			
			
		}
		catch (Exception e) 
		{
	    
			System.out.println(e);
			
		}
		
		
	}
	
	public Connection GetCon()
	{
		return con;
	}
	 
	 public void CloseCon() 
	 {
		 if(con!=null)
		 {
			 try
			 {
				con.close();
				con=null;
				
			} catch (SQLException e) 
			 {
				System.out.println(e);
			}
		 }
	 }
	 


}
