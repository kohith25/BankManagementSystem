
package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup2 extends JFrame implements ActionListener{
    JButton next;
    JRadioButton acc1,acc2,citizen ,citizen2;
    JTextField addnum,pannum,occ, qua,salary ;
    JComboBox relcom,cast;
    String formno;
    Signup2(String formno){
        this.formno=formno;
        setLayout(null);
        JLabel head = new JLabel("APPLICATION FORM : 2");
        head.setFont(new Font("osward",Font.BOLD,30));
        head.setBounds(200,10,900,40);
        add(head);
        
        JLabel head2 = new JLabel("(ADDITIONAL DETAILS)");
        head2.setFont(new Font("osward",Font.BOLD,20));
        head2.setBounds(260,50,400,30);
        add(head2);
        
        JLabel relegion = new JLabel("Religion :");
        relegion.setBounds(80,120,300,30);
        relegion.setFont(new Font("osward",Font.BOLD,16));
        add(relegion);
        
        JLabel cat = new JLabel("Category");
        cat.setBounds(80,180,300,30);
        cat.setFont(new Font("osward",Font.BOLD,16));
        add(cat);
        
        JLabel income = new JLabel("Income");
        income.setBounds(80,240,300,30);
        income.setFont(new Font("osward",Font.BOLD,16));
        add(income);
        
        JLabel qualify = new JLabel("Qualification");
        qualify.setBounds(80,300,300,30);
        qualify.setFont(new Font("osward",Font.BOLD,16));
        add(qualify);
        
        JLabel Occupation = new JLabel("Occupation");
        Occupation.setBounds(80,360,300,30);
        Occupation.setFont(new Font("osward",Font.BOLD,16));
        add(Occupation);
        
        JLabel pan = new JLabel("PAN Number");
        pan.setBounds(80,420,300,30);
        pan.setFont(new Font("osward",Font.BOLD,16));
        add(pan);
        
        JLabel adhar = new JLabel("Aadhar Number");
        adhar.setBounds(80,480,300,30);
        adhar.setFont(new Font("osward",Font.BOLD,16));
        add(adhar);
        
        JLabel senior = new JLabel("Senior Citizen");
        senior.setBounds(80,540,300,30);
        senior.setFont(new Font("osward",Font.BOLD,16));
        add(senior);
        
        JLabel existacc = new JLabel("Existing Account");
        existacc.setBounds(80,600,300,30);
        existacc.setFont(new Font("osward",Font.BOLD,16));
        add(existacc);
        
        String arr[] = {"HINDU","MUSLIM","CHRISTIAN","OTHERS"};
        relcom = new JComboBox(arr);
        relcom.setBounds(250,128,500,20);
        add(relcom);
        
        String arr2[] = {"Gen","OBC","ST","SC","OTHERS"};
        cast = new JComboBox(arr2);
        cast.setBounds(250,188,500,20);
        add(cast);

        salary = new JTextField();
        salary.setBounds(250,248,500,20);
        add(salary);
        
        qua = new JTextField();
        qua.setBounds(250,308,500,20);
        add(qua);
        
        occ = new JTextField();
        occ.setBounds(250,368,500,20);
        add(occ);
        
        pannum = new JTextField();
        pannum.setBounds(250,428,500,20);
        add(pannum);
        
        addnum = new JTextField();
        addnum.setBounds(250,488,500,20);
        add(addnum);
        
        citizen = new JRadioButton("YES");
        citizen.setBounds(250,548,150,20);
        add(citizen);
        
        citizen2 = new JRadioButton("NO");
        citizen2.setBounds(450,548,150,20);
        add(citizen2);
        
        acc1 = new JRadioButton("YES");
        acc1.setBounds(250,608,150,20);
        add(acc1);
        
        acc2 = new JRadioButton("NO");
        acc2.setBounds(450,608,150,20);
        add(acc2);
        
        next = new JButton("NEXT");
        next.setBounds(620,600,80,30);
        next.addActionListener(this);
        add(next);
        
        setTitle("APPLICATION FORM");
        setSize(800,750);
        setVisible(true);
        setLocation(350,50);
        getContentPane().setBackground(Color.WHITE);
    }
    public void actionPerformed(ActionEvent ae){
        String relegion = (String)relcom.getSelectedItem();
        String cat = (String)cast.getSelectedItem();
        String income = salary.getText();
        String qualify = qua.getText();
        String Occupation = occ.getText();
        String pan = pannum.getText();
        String Aadhar = addnum.getText();
        String senior=null;
        if(citizen.isSelected()){
            senior="yes";
        }else if(citizen2.isSelected()){
            senior="NO";
        }
        String existacc=null;
        if(acc1.isSelected()){
            existacc="YES";
        }else if(acc2.isSelected()){
            existacc="NO";
        }
        try{
            if(income.equals("")){
                JOptionPane.showMessageDialog(null,"PLEASE FILL YOUR INCOME");
            }else if(qualify.equals("")){
                JOptionPane.showMessageDialog(null,"PLEASE FILL YOUR Qualification");
            }else if(Occupation.equals("")){
                JOptionPane.showMessageDialog(null,"PLEASE FILL YOUR Occupation");
            }else if(pan.equals("")){
                JOptionPane.showMessageDialog(null,"PLEASE FILL YOUR pan Number");
            }else if(Aadhar.equals("")){
                JOptionPane.showMessageDialog(null,"PLEASE FILL YOUR AADHAR NUMBER");              
            }else{
                connect c= new connect();
                String query = "Insert into signup2 values('"
                        +formno+"','"
                        +relegion+"','"
                        +cat+"','"
                        +income+"','"
                        +qualify+"','"
                        +Occupation+"','"
                        +pan+"','"
                        +Aadhar+"','"
                        +senior+"','"
                        +existacc+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new Signup3(formno).setVisible(true);
                
            }
        }catch(Exception e){
            System.out.println(e);
        } 
    }
    public static void main(String args[]) {
        new Signup2("");
    }
}
    