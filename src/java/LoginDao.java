/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Balra
 */
import java.sql.*;
public class LoginDao {
     public static boolean validate_acc(long acco)
     {  
          boolean status=false;
          try
          {  
               Class.forName("oracle.jdbc.driver.OracleDriver");  
               Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","oracle");  
               
               PreparedStatement ps=con.prepareStatement(  
               "select acc from atm_users where acc=?");  
               ps.setDouble(1,acco);  
               ResultSet rs=ps.executeQuery();  
               status=rs.next();  
          }
          catch(Exception e)
          {
               System.out.println(e);
          }  
          return status;  
     } 
     public static boolean validate_pass(long passw)
     {  
          boolean status=false;
          try
          {  
               Class.forName("oracle.jdbc.driver.OracleDriver");  
               Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","oracle");  
               
               PreparedStatement ps=con.prepareStatement(  
               "select acc from atm_users where pass=?");  
               ps.setDouble(1,passw);  
               ResultSet rs=ps.executeQuery();  
               status=rs.next();  
          }
          catch(Exception e)
          {
               System.out.println(e);
          }  
          return status;  
     }  
}
