/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginWeb.Infra.Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Fabricio Ramos
 */
public class SessionFactory {
    private String driver = "com.mysql.jdbc.Driver"; 
    private String connectionStr = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";  
    private String username = "root";
    private String password = "";
	
    private static SessionFactory connectionFactory = null;  

	private SessionFactory(){  
		try{  
			Class.forName(driver);  
		}catch(ClassNotFoundException e){  
			e.printStackTrace();  
		}  
	}  

	public Connection getConnection() throws SQLException{  
		Connection conn = null;  
		try{  
			conn = DriverManager.getConnection(connectionStr, username, password);  
		}catch(SQLException e){  
			e.printStackTrace();  
		}  
		return conn;  
	}  

	public static SessionFactory getInstance(){  
		if(connectionFactory == null)  
			connectionFactory = new SessionFactory();  

		return connectionFactory;  
	}   
}
