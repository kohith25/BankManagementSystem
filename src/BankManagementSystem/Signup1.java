
package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class Signup1 extends JFrame implements ActionListener{
    
    JTextField namefield,fatnamefield,emailfield,addrfield,cityfield,statefield,pinfield;
    JButton next;
    JRadioButton no,yes,omale,fmale,male;
    JDateChooser dateChooser;
    long formno;

    Signup1(){
        
        Random ran = new Random();
        formno = Math.abs((ran.nextLong()%9000L)+1000L);
        

        setTitle("NEW APPLICATION FORM FOR SIGNUP");
        setLayout(null);
        
        JLabel head = new JLabel("APPLICATION FORM:"+formno);
        head.setFont(new Font("osward",Font.BOLD,38));
        head.setBounds(200,10,700,40);
        add(head);
        
        JLabel subhead = new JLabel("Page:1 Personal Details");
        subhead.setFont(new Font("raleway",Font.BOLD,20));
        subhead.setBounds(300,60,500,30);
        add(subhead);
        
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("osward",Font.BOLD,16));
        name.setBounds(80,120,300,20);
        add(name);
        
        namefield = new JTextField();
        namefield.setBounds(300,122,400,20);
        add(namefield);
        
        JLabel fatname = new JLabel("Father's Name:");
        fatname.setFont(new Font("osward",Font.BOLD,16));
        fatname.setBounds(80,160,300,20);
        add(fatname);
        
        fatnamefield = new JTextField();
        fatnamefield.setBounds(300,162,400,20);
        add(fatnamefield);
        
        JLabel birth = new JLabel("Date of Birth:");
        birth.setFont(new Font("osward",Font.BOLD,16));
        birth.setBounds(80,200,300,20);
        add(birth);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,202,400,25);
        dateChooser.setForeground(new Color(200,200,200));
        dateChooser.setFont(new Font("osward",Font.ITALIC,16));
        add(dateChooser);
        
        JLabel Gender = new JLabel("Gender:");
        Gender.setFont(new Font("osward",Font.BOLD,16));
        Gender.setBounds(80,240,300,20);
        add(Gender);
        
        male = new JRadioButton("MALE");
        male.setBounds(300,242,100,20);
        add(male);
        
        fmale = new JRadioButton("FEMALE");
        fmale.setBounds(450,242,100,20);
        add(fmale);
        
        omale = new JRadioButton("OTHER");
        omale.setBounds(600,242,100,20);
        add(omale);
        
        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("osward",Font.BOLD,16));
        email.setBounds(80,280,300,20);
        add(email);
        
        emailfield = new JTextField();
        emailfield.setBounds(300,282,400,20);
        add(emailfield);
        
        JLabel marriage = new JLabel("Maritial Status:");
        marriage.setFont(new Font("osward",Font.BOLD,16));
        marriage.setBounds(80,320,300,20);
        add(marriage);
        
        yes = new JRadioButton("MARRIED");
        yes.setBounds(300,322,100,20);
        add(yes);
        
        no = new JRadioButton("UNMARRIED");
        no.setBounds(500,322,100,20);
        add(no);
        
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("osward",Font.BOLD,16));
        address.setBounds(80,360,300,20);
        add(address);
        
        addrfield = new JTextField();
        addrfield.setBounds(300,362,400,38);
        add(addrfield);
        
        JLabel city = new JLabel("city:");
        city.setFont(new Font("osward",Font.BOLD,16));
        city.setBounds(80,420,300,20);
        add(city);
        
        cityfield = new JTextField();
        cityfield.setBounds(300,422,400,20);
        add(cityfield);
        
        JLabel state = new JLabel("state:");
        state.setFont(new Font("osward",Font.BOLD,16));
        state.setBounds(80,460,300,20);
        add(state);
        
        statefield = new JTextField();
        statefield.setBounds(300,462,400,20);
        add(statefield);
        
        JLabel pin = new JLabel("Pin Code:");
        pin.setFont(new Font("osward",Font.BOLD,16));
        pin.setBounds(80,500,300,20);
        add(pin);
        
        pinfield = new JTextField();
        pinfield.setBounds(300,502,400,20);
        add(pinfield);
        
        next = new JButton("NEXT");
        next.setBounds(620,600,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(800,750);
        setLocation(350,50);
        setVisible(true);
}  
    public void actionPerformed(ActionEvent ae){
        String name=namefield.getText();
        String fatname=fatnamefield.getText();
        String birth;
            if (dateChooser.getDate() != null) {
                birth = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
            } else {
            birth = "";
            }
        String Gender = null;
        if(male.isSelected()){
            Gender="MALE";
        }else if(fmale.isSelected()){
            Gender="FEMALE";
        }else if(omale.isSelected()){
            Gender="Other";
        }
        String email=emailfield.getText();
        String marriage=null;
        if(yes.isSelected()){
            marriage="MARRIED";
        }else if(no.isSelected()){
            marriage="UNMARRIED";
        }
        String address=addrfield.getText();
        String city = cityfield.getText();
        String state = statefield.getText();
        String pin=pinfield.getText();
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"PLEASE FILL YOUR NAME");
            }else if(fatname.equals("")){
                JOptionPane.showMessageDialog(null,"PLEASE FILL YOUR FATHER's NAME");
            }else if(birth.equals("")){
                JOptionPane.showMessageDialog(null,"PLEASE FILL YOUR DATE OF BIRTH");
            }else if(Gender==null){
                JOptionPane.showMessageDialog(null,"PLEASE ENTER YOUR GENDER");
            }else if(email.equals("")){
                JOptionPane.showMessageDialog(null,"PLEASE FILL THE EMAIL");
            }else if(marriage==null){
                JOptionPane.showMessageDialog(null,"PLEASE ENTER YOUR MARRIAGE STATUS");
            }else if(address.equals("")){
                JOptionPane.showMessageDialog(null,"PLEASE ENTER YOUR ADDRESS");
            }else if(city.equals("")){
                JOptionPane.showMessageDialog(null,"PLEASE ENTER YOUR CITY");
            }else if(state.equals("")){
                JOptionPane.showMessageDialog(null,"PLEASE ENTER YOUR STATE");
            }else if(pin.equals("")){
                JOptionPane.showMessageDialog(null,"PLEASE ENTER YOUR PIN CODE");
            }else{
                connect c= new connect();
                String query = "Insert into signup values('"
                        +formno+"','"
                        +name+"','"
                        +fatname+"','"
                        +birth+"','"
                        +Gender+"','"
                        +email+"','"
                        +marriage+"','"
                        +address+"','"
                        +city+"','"
                        +state+"','"
                        +pin+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new Signup2(String.valueOf(formno)).setVisible(true);
            }
        } catch (Exception e){
            System.out.println(e);
        }
        
    }
    
    public static void main(String args[]) {
        new Signup1();
    }
}
