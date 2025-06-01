
package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Mini extends JFrame {

    String pin;
    Mini(String pin){
        this.pin = pin;
        setLayout(null);
        
        setSize(600,600);
        setLocation(500,120);
        setVisible(true);
        
        JLabel head = new JLabel("MY BANK");
        head.setBounds(200,30,500,30);
        head.setFont(new Font("osward",Font.BOLD,22));
        add(head);
        
        JLabel side = new JLabel();
        side.setBounds(100,80,700,40);
        side.setFont(new Font("osward",Font.ITALIC,18));
        add(side);
        
        JLabel side2 = new JLabel();
        side2.setBounds(100,120,700,40);
        side2.setFont(new Font("osward",Font.ITALIC,18));
        add(side2);
        
        try{
            connect c = new connect();
            ResultSet rs = c.s.executeQuery("select * from login where PIN ='"+pin+"'");
            while(rs.next()){
                side.setText("Card Number:"+rs.getString("Card_Number"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        try{
            connect c = new connect();
            ResultSet rs = c.s.executeQuery("select * from bank where PIN ='"+pin+"'");
            while(rs.next()){
                side2.setText("Date :"+rs.getString("data"));
            }
        }catch(Exception e){
            System.out.println(e);
            
        }
        
        
    }
    
    public static void main(String args[]) {
        new Mini("");
    }
}
