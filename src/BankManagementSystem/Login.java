
package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton signup,clear,signin;
    JTextField cardfield;
    JPasswordField pinTextField;
    
    Login(){
        setLayout(null);
        
        setTitle("MY BANK");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/kk.jpg"));
        Image i2 = i1.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel label1 = new JLabel(i3);
        label1.setBounds(70,10,120,120);
        add(label1);
        
        JLabel text = new JLabel("WELCOME TO MY BANK");
        text.setFont(new Font("osward",Font.BOLD,38));
        text.setBounds(200,60,800,40);
        add(text);
        
        JLabel cardno = new JLabel("Card NO.");
        cardno.setFont(new Font("osward",Font.BOLD,28));
        cardno.setBounds(120,150,800,40);
        add(cardno);
        
        cardfield = new JTextField();
        cardfield.setBounds(250,160,250,30);
        cardfield.setFont(new Font("Arial",Font.BOLD,14));
        add(cardfield);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("osward",Font.BOLD,28));
        pin.setBounds(180,220,800,40);
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(250,230,250,30);
        pinTextField.setFont(new Font("Areial",Font.BOLD,14));
        add(pinTextField);
        
        signin = new JButton("SIGN IN");
        signin.addActionListener(this);
        signin.setBounds(220,300,120,30);
        add(signin);
        
        clear = new JButton("CLEAR");
        clear.addActionListener(this);
        clear.setBounds(400,300,120,30);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.addActionListener(this);
        signup.setBounds(280,350,200,30);
        add(signup);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(800,480);//defines set size like lenght of 800 and breadth of 480
        setVisible(true);
        setLocation(350,200);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==signin){
            connect c= new connect();
            String cardno= cardfield.getText();
            String pin = pinTextField.getText();
            String query = "Select * from login where Card_Number = '"+cardno+"' and pin ='"+pin+"'";
            try{
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new transaction(pin).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"PLEASE ENTER CORRECT DETAILS");
                }
            }catch(Exception e){
                System.out.println(e);
            }
            
        }else if(ae.getSource()==clear){
            cardfield.setText("");
            pinTextField.setText("");
            
        }else if(ae.getSource()==signup){
            setVisible(false);
            new Signup1().setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        new Login();
    }
}
