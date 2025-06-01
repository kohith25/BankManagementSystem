
package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Cash extends JFrame implements ActionListener{

    JButton deposit,cashw,fastcash,mini,exit;
    String pin;
    Cash(String pin){
        this.pin = pin;
        setLayout(null);      
        setTitle("TRANSACTION");
        setSize(600,600);
        setLocation(500,120);
        setVisible(true);
        
        JLabel head =  new JLabel("PLEASE SELECT YOUR TRANSACTION");
        head.setBounds(100,20,800,30);
        head.setFont(new Font("Raleway",Font.BOLD,20));
        add(head);
        
        deposit = new JButton("Rs 100");
        deposit.setBounds(200,90,180,40);
        deposit.addActionListener(this);
        add(deposit);
        
        cashw = new JButton("Rs 200 ");
        cashw.setBounds(200,140,180,40);
        cashw.addActionListener(this);
        add(cashw);
        
        fastcash = new JButton("Rs 500");
        fastcash.setBounds(200,190,180,40);
        fastcash.addActionListener(this);
        add(fastcash);
        
        mini = new JButton("Rs 2000");
        mini.setBounds(200,240,180,40);
        mini.addActionListener(this);
        add(mini);
        
        exit = new JButton("Back");
        exit.addActionListener(this);
        exit.setBounds(350,340,100,40);
        add(exit);   
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== exit){
            setVisible(false);
            new transaction(pin).setVisible(true);
        }else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            connect c = new connect();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
                int balance =0;
                while(rs.next()){
                    if(rs.getString("type").equals("DEPOSIT")){
                        balance = balance+Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance=balance-Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"INSUFFICIENT BALANCE !!!");
                    return;
                }else{
                    Date date = new Date();
                    String query = "insert into bank values('"+pin+"','"+date+"','WITHDRAWL','"+amount+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+amount+" WITHDRAWL SUCCESSFULL");
                    setVisible(false);
                    new transaction(pin).setVisible(true);  
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String args[]) {
        new Cash("");
    }
}
