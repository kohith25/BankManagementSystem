
package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener{

    String formno;
    JRadioButton type1,type2,type3,type4;
    JButton submit,cancel;
    JRadioButton a,b,c,d,e,f,i;
    Signup3(String formno){
        this.formno=formno;
        setLayout(null);
        JLabel hed= new JLabel("PAGE 3: ACCOUNT DETAILS");
        hed.setBounds(160,30,900,40);
        hed.setFont(new Font("Raleway",Font.BOLD,38));
        add(hed);
        
        JLabel subhed = new JLabel("Account Type :");
        subhed.setBounds(100,100,400,30);
        subhed.setFont(new Font("Raleway",Font.BOLD,18));
        add(subhed);
        
        type1 = new JRadioButton("Savings Account");
        type1.setBounds(100,140,200,25);
        add(type1);
        
        type2 = new JRadioButton("Fixed Deposit Account");
        type2.setBounds(400,140,200,25);
        add(type2);
        
        type3 = new JRadioButton("Current Account");
        type3.setBounds(100,175,200,25);
        add(type3);
        
        type4 = new JRadioButton("Recurring Deposit Account");
        type4.setBounds(400,175,200,25);
        add(type4);
        
        ButtonGroup group = new ButtonGroup();
        group.add(type1);
        group.add(type2);
        group.add(type3);
        group.add(type4);
        
        JLabel card = new JLabel("Card Number          :");
        card.setBounds(100,220,250,30);
        card.setFont(new Font("Raleway",Font.BOLD,18));
        add(card);
        
        JLabel cardnum = new JLabel("XXXX-XXXX-XXXX-1430");
        cardnum.setBounds(300,222,300,30);
        cardnum.setFont(new Font("osward",Font.BOLD,20));
        add(cardnum);
        
        JLabel cardnum2 = new JLabel("(Your 16 Digit Card Number)");
        cardnum2.setBounds(90,242,300,20);
        cardnum2.setFont(new Font("osward",Font.BOLD,10));
        add(cardnum2);
        
        JLabel pin = new JLabel("PIN Number             :");
        pin.setBounds(100,270,250,30);
        pin.setFont(new Font("Raleway",Font.BOLD,18));
        add(pin);
        
        JLabel pinnum = new JLabel("XXXX");
        pinnum.setBounds(300,272,300,30);
        pinnum.setFont(new Font("osward",Font.BOLD,20));
        add(pinnum);
        
        JLabel pin2 = new JLabel("(Your 4 Digit PIN Number)");
        pin2.setBounds(90,292,300,20);
        pin2.setFont(new Font("osward",Font.BOLD,10));
        add(pin2);
        
        JLabel serve = new JLabel("SERVICES REQUIRED :");
        serve.setBounds(90,330,300,30);
        serve.setFont(new Font("Raleway",Font.BOLD,18));
        add(serve);
        
        a = new JRadioButton("ATM Card");
        a.setBounds(100,370,250,30);
        a.setFont(new Font("osward",Font.BOLD,20));
        add(a);
        
        b = new JRadioButton("INERNET BANKING");
        b.setBounds(400,370,250,30);
        b.setFont(new Font("osward",Font.BOLD,20));
        add(b);
        
        c = new JRadioButton("MOBILE BANKING");
        c.setBounds(100,430,250,30);
        c.setFont(new Font("osward",Font.BOLD,20));
        add(c);
        
        d = new JRadioButton("Cheque Book");
        d.setBounds(400,430,250,30);
        d.setFont(new Font("osward",Font.BOLD,20));
        add(d);
        
        e = new JRadioButton("E-Statements");
        e.setBounds(100,490,250,30);
        e.setFont(new Font("osward",Font.BOLD,20));
        add(e);

        f= new JRadioButton("EMAIL & SMs ALERTS");
        f.setBounds(400,490,250,30);
        f.setFont(new Font("osward",Font.BOLD,20));
        add(f);

        i = new JRadioButton("I here by declare that all above details are correct to the best of my Knowledge");
        i.setBounds(100,555,600,20);
        i.setFont(new Font("osward",Font.BOLD,12));
        add(i);
        
        submit = new JButton("SUBMIT");
        submit.setBounds(200,620,100,30);
        submit.setFont(new Font("Raleway",Font.BOLD,12));
        add(submit);
        submit.addActionListener(this);
        
        cancel = new JButton("CANCEL");
        cancel.setBounds(450,620,100,30);
        cancel.setFont(new Font("Raleway",Font.BOLD,12));
        add(cancel);
        cancel.addActionListener(this);
        
        setSize(800,750);
        setVisible(true);
        setLocation(350,50);
        getContentPane().setBackground(Color.WHITE);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== submit){
            String acctype=null;
            if(type1.isSelected()){
                acctype="Savings Account";
            }else if(type2.isSelected()){
                acctype="Fixed Deposit Account";
            }else if(type3.isSelected()){
                acctype="Current Account";
            }else if(type4.isSelected()){
                acctype="Recurring Deposit Account";
            }
            Random random = new Random();
            String cardnumber = ""+Math.abs((random.nextLong()%90000000L)+8328239300000000L);
            
            String pinnumber = " "+Math.abs((random .nextLong()%9000L)+1000L);
            
            String facility="";
            if(a.isSelected()){
                facility = facility+"ATM card";
            }
            if(b.isSelected()){
                facility=facility+"INTERNET Banking";
            }
            if(c.isSelected()){
                facility=facility+"MOBILE Banking";
            }
            if(e.isSelected()){
                facility=facility+"E-Statements";
            }
            if(f.isSelected()){
                facility=facility+"Email & Sms Alert";
            }
            try{
                if(acctype.equals("")){
                    JOptionPane.showMessageDialog(null,"PLEASE Enter ACCOUNT TYPE");
                }else if(facility.equals("")){
                    JOptionPane.showMessageDialog(null,"PLEASE FILL Facilities"); 
                }else if(!i.isSelected()){
                    JOptionPane.showMessageDialog(null,"PLEASE Select the Declaration!!");
                }else{
                    connect c = new connect();
                    String query3 = "insert into signup3 values('"
                            +formno+"','"
                            +acctype+"','"
                            +cardnumber+"','"
                            +pinnumber+"','"
                            +facility+"')";
                    String query4 = "insert into login values('"
                            +formno+"','"
                            +cardnumber+"','"
                            +pinnumber+"')";
                    c.s.executeUpdate(query4);
                    c.s.executeUpdate(query3);
                    JOptionPane.showMessageDialog(null,"Card Number :"+cardnumber+"\n PIN :"+pinnumber);
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(false);
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource()== cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String args[]) {
       new Signup3("");
    }
}
