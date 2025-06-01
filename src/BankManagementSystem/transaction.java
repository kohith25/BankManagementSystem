
package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class transaction extends JFrame implements ActionListener{

    JButton deposit,cashw,fastcash,mini,pinchange,balanceenq,exit;
    String pin;
    transaction(String pin){
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
        
        deposit = new JButton("DEPOSIT");
        deposit.setBounds(200,90,180,40);
        deposit.addActionListener(this);
        add(deposit);
        
        cashw = new JButton("CASH WITHDRAWL");
        cashw.setBounds(200,140,180,40);
        cashw.addActionListener(this);
        add(cashw);
        
        fastcash = new JButton("FAST CASH");
        fastcash.setBounds(200,190,180,40);
        fastcash.addActionListener(this);
        add(fastcash);
        
        mini = new JButton("MINI STATEMENT");
        mini.setBounds(200,240,180,40);
        mini.addActionListener(this);
        add(mini);
        
        pinchange = new JButton("PIN CHANGE");
        pinchange.setBounds(200,290,180,40);
        pinchange.addActionListener(this);
        add(pinchange);
        
        balanceenq = new JButton("BALANCE ENQUIRY");
        balanceenq.setBounds(200,340,180,40);
        balanceenq.addActionListener(this);
        add(balanceenq);
        
        exit = new JButton("EXIT");
        exit.addActionListener(this);
        exit.setBounds(350,440,100,40);
        add(exit);   
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        }else if(ae.getSource()== deposit){
            setVisible(false);
            new Deposit(pin).setVisible(true);
        }else if(ae.getSource()==cashw){
            setVisible(false);
            new Withdraw(pin).setVisible(true);
        }else if(ae.getSource()== fastcash){
            setVisible(false);
            new Cash(pin).setVisible(true);
        }else if(ae.getSource()==pinchange){
            setVisible(false);
            new PinC(pin).setVisible(true);
        }else if(ae.getSource()==balanceenq){
            setVisible(false);
            new Balance(pin).setVisible(true);
        }else if(ae.getSource()==mini){
            setVisible(false);
            new Mini(pin).setVisible(true);
        }
    }
    public static void main(String args[]) {
        new transaction("");
    }
}
