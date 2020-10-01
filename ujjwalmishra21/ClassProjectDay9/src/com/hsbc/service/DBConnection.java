package com.hsbc.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
		private static String driver="org.apache.derby.jdbc.EmbeddedDriver";
	    private static String url="jdbc:derby:C:\\Users\\ujjwa\\testDB";

	    static{
		
//		username=resource.getString("username");
//		password=resource.getString("password");
		
		    try {
			Class.forName(driver);
		    } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			
		    e.printStackTrace();
		
		    System.out.println("Unable to load the Driver");
		}
	    }//End of static block
	    public Connection getConnection() {
		try{
		    return DriverManager.getConnection(url);
		}catch(SQLException e){
		    e.printStackTrace();
		}
		return null;

	    }//end of getConnection method
	    
	    public void releaseResources(Connection con,Statement st) {
			if(con!=null){
			    try{
			    	con.close();
			    }catch(SQLException exception){
					exception.printStackTrace();
	
			    }
			}
			if(st!=null){
			    try{
				st.close();
			    }catch(SQLException excption){
			    	excption.printStackTrace();
			    }
			}
	    }//end of release method


}
