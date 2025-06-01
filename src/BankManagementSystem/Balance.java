
package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Balance extends JFrame implements ActionListener{

    String pin;
    JButton back;
    Balance(String pin){
        this.pin = pin;
        JLabel head =new JLabel("REMAINING BALANCE");
        head.setBounds(140,60,300,30);
        head.setFont(new Font("osward",Font.BOLD,26));
        add(head);

        back = new JButton("BACK");
        back.addActionListener(this);
        back.setBounds(400,300,100,30);
        add(back);
        
        connect c = new connect();
        int balance =0;
        try{
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
            while(rs.next()){
                if(rs.getString("type").equals("DEPOSIT")){
                    balance = balance+Integer.parseInt(rs.getString("amount"));
                }else{
                    balance=balance-Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        JTextField bal = new JTextField(" "+balance);
        bal.setEditable(false);
        bal.setBounds(100,150,300,40);
        add(bal);
        
        
        setLayout(null);
        setSize(600,600);
        setVisible(true);
        setLocation(500,120);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            if(ae.getSource()==back){
                setVisible(false);
                new transaction(pin).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]) {
       new Balance("");
        
    }
}
