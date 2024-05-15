
package travel.management.system;

import java.sql.*;


public class Conn {
    
    Connection c;
    Statement s;
    Conn(){
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travel_management_system", "root", "Palash@1998");
           s = c.createStatement();
       } catch(Exception e){
           e.printStackTrace();
       }
    }
}
