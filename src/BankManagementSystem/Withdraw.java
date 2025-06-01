
package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Withdraw extends JFrame implements ActionListener {

    String pin;
    JTextField draw;
    JButton withdraw,back;
    Withdraw(String pin){
        this.pin = pin;
        setLayout(null);
        JLabel with = new JLabel("PLEASE ENTER YOUR AMOUNT");
        with.setBounds(150,30,500,40);
        with.setFont(new Font("Raleway",Font.BOLD,20));
        add(with);
        
        draw = new JTextField();
        draw.setBounds(150,100,300,30);
        add(draw);
        
        withdraw = new JButton("WITHDRAWL");
        withdraw.setBounds(350,160,140,30);
        withdraw.addActionListener(this);
        add(withdraw);
         
        back = new JButton("BACK");
        back.addActionListener(this);
        back.setBounds(350,210,140,30);
        add(back);
        
       setSize(600,600);
       setLocation(500,150);
       setVisible(true);
       
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            if(ae.getSource()==withdraw){
                String number =draw.getText().trim();
                if(number.equals("")){
                    JOptionPane.showMessageDialog(null,"PLEASE ENTER YOUR AMOUNT");
                }else{
                    Date date = new Date();
                    connect c = new connect();
                    String query = "insert into bank values('"+pin+"','" +date+"','WITHDRAWL','" +number+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs"+number+" WITHDRAWL SUCCESSFULL");
                    setVisible(false);
                    new transaction(pin).setVisible(true);
                }
                
            }else if(ae.getSource()==back){
                setVisible(false);
                new transaction(pin).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    public static void main(String args[]) {
        new Withdraw("");
    }
}
