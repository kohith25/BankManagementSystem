
package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinC extends JFrame implements ActionListener{

    String pin;
    JButton chan,back;
    JTextField newp1,repin1;
            
    PinC(String pin){
        this.pin = pin;
        setLayout(null);
        
        JLabel head = new JLabel("CHANGE YOUR PIN");
        head.setBounds(180,30,400,40);
        head.setFont(new Font("Raleway",Font.BOLD,22));
        add(head);
        
        JLabel newp = new JLabel("New PIN:");
        newp.setBounds(100,90,200,40);
        newp.setFont(new Font("Raleway",Font.BOLD,18));
        add(newp);
        
        JLabel repin = new JLabel("Re-Enter New PIN:");
        repin.setBounds(100,150,200,40);
        repin.setFont(new Font("Raleway",Font.BOLD,18));
        add(repin);
        
        newp1 = new JTextField();
        newp1.setBounds(300,92,250,30);
        add(newp1);
        
        repin1 = new JTextField();
        repin1.setBounds(300,152,250,30);
        add(repin1);
        
        chan = new JButton("Change");
        chan.setBounds(400,260,120,25);
        chan.addActionListener(this);
        add(chan);
        
        back = new JButton("Back");
        back.setBounds(400,300,120,25);
        back.addActionListener(this);
        add(back);
        
        setSize(600,600);
        setLocation(500,120);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        try{
            if(ae.getSource()==chan){
                String npin = newp1.getText();
                String rpin = repin1.getText();
                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"Entered pin doesn't match Re-Entered pin");
                    return;
                }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter your New Pin");
                }
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please RE-Enter your new Pin");
                }
                connect c = new connect();
                String query1 = "update bank set pin ='"+rpin+"'where pin = '"+pin+"'";
                String query2 = "update login set PIN ='"+rpin+"'where PIN = '"+pin+"'";
                String query3 = "update signup3 set PIN ='"+rpin+"'where PIN = '"+pin+"'";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null,"PIN Changed Successfully");
                setVisible(false);
                new transaction(rpin).setVisible(true);
            }else if(ae.getSource()==back){
                setVisible(false);
                new transaction(pin).setVisible(true);
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    public static void main(String args[]) {
        new PinC("");
    }
}
