/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginWeb.Infra.infra.Repositorios;

import LoginWeb.Infra.Factory.SessionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Fabricio Ramos
 */
public class Repository{     
    
   protected Connection con = null;  
    protected PreparedStatement ps= null;  
    protected ResultSet rs = null;  
     
    protected Connection getConnection() throws SQLException{  
    Connection conn;  
    conn = SessionFactory.getInstance().getConnection();  
    return conn;   
      
   } 
  
}
