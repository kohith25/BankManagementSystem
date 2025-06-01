
package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    JButton deposit,back;
    JTextField enter;
    String pin;
    Deposit(String pin){
        this.pin = pin;
        setLayout(null);
        
        JLabel head = new JLabel("ENTER THE AMOUNT YOU WANT TO DEPOSIT");
        head.setBounds(100,50,500,20);
        head.setFont(new Font("osward",Font.BOLD,18));
        add(head);
        
        enter = new JTextField();
        enter.setBounds(150,100,300,30);
        add(enter);
        
        deposit = new JButton("DEPOSIT");
        deposit.setBounds(350,160,140,30);
        deposit.addActionListener(this);
        add(deposit);
         
        back = new JButton("BACK");
        back.addActionListener(this);
        back.setBounds(350,210,140,30);
        add(back);
         
        setLocation(500,150);
        setSize(600,600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            if(ae.getSource() == deposit){
                String number = enter.getText().trim();
                Date date = new Date();
                if(number.equals("")){
                    JOptionPane.showMessageDialog(null,"PLEASE ENTER YOUR AMOUNT");
                }else{
                    connect c = new connect();
                    String query = "insert into bank values('"+pin+"','" +date+"','DEPOSIT','" +number+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+ number +" DEPOSITED SUCCESSFULLY");
                    setVisible(false);
                    new transaction(pin).setVisible(true);
                }
            }else if(ae.getSource() == back){
                setVisible(false);
                new transaction(pin).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    public static void main(String args[]) {
       new Deposit("");
        
    }
}
