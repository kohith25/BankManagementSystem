
package BankManagementSystem;

import java.sql.*;

public class connect {
    Connection c;
    Statement s;
    public connect(){
        try{
            c = DriverManager.getConnection("jdbc:mysql:///BankManagementSystem","root","Ko@248hith");
            s = c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
