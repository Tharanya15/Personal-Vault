/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Orginal_Project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

public class Personal_details_RegisterForm extends JFrame
{

    JLabel l1_adhaar_no,l2_adhhar_name,l3_addhhar_address,l4_ration_id,l5_passport,l6_father_name,l7_title,l8;
    JTextField t1_adhaar_no,t2_adhhar_name,t3_addhhar_address,t4_ration_id,t5_passport,t6_father_name;
    JCheckBox c1_adhaar_no,c2_adhhar_name,c3_addhhar_address,c4_ration_id,c5_passport,c6_father_name;
    JButton b1_submit,b2_back;
    public Personal_details_RegisterForm(String str)  
    {
        l1_adhaar_no=new JLabel("Aadhaar-No");
        l2_adhhar_name=new JLabel("Aadhaar-Name");
        l3_addhhar_address=new JLabel("Aadhaar-Address");
        l4_ration_id=new JLabel("Ration-No");
        l5_passport=new JLabel("Passport(if available)");
        l6_father_name=new JLabel("Father's Name");
        l7_title=new JLabel("Add Details");
        l8=new JLabel("if essential tick it");
        
        l1_adhaar_no.setBounds(100,100,150,50);
        l2_adhhar_name.setBounds(100,200,150,50);
        l3_addhhar_address.setBounds(100,300,150,50);
        l4_ration_id.setBounds(100,400,150,50);
        l5_passport.setBounds(100,500,250,50);
        l6_father_name.setBounds(100,600,150,50);
        l7_title.setBounds(350,20,500,50);
        l8.setBounds(700,90,300,50);
        
        
        l1_adhaar_no.setFont(new Font("Times new Roman",Font.BOLD,20));
        l2_adhhar_name.setFont(new Font("Times new Roman",Font.BOLD,20));
        l3_addhhar_address.setFont(new Font("Times new Roman",Font.BOLD,20));
        l4_ration_id.setFont(new Font("Times new Roman",Font.BOLD,20));
        l5_passport.setFont(new Font("Times new Roman",Font.BOLD,20));
        l6_father_name.setFont(new Font("Times new Roman",Font.BOLD,20));
        l7_title.setFont(new Font("Times new Roman",Font.BOLD,40));
        l8.setFont(new Font("Times new Roman",Font.BOLD,30));
        
        t1_adhaar_no=new JTextField();
        t2_adhhar_name=new JTextField();
        t3_addhhar_address=new JTextField();
        t4_ration_id=new JTextField();
        t5_passport=new JTextField();
        t6_father_name=new JTextField();
        
        t1_adhaar_no.setBounds(300,100,250,50);
        t2_adhhar_name.setBounds(300,200,250,50);
        t3_addhhar_address.setBounds(300,300,250,50);
        t4_ration_id.setBounds(300,400,250,50);
        t5_passport.setBounds(300,500,250,50);
        t6_father_name.setBounds(300,600,250,50);
        
        t1_adhaar_no.setFont(new Font("Times new Roman",Font.BOLD,20));
        t2_adhhar_name.setFont(new Font("Times new Roman",Font.BOLD,20));
        t3_addhhar_address.setFont(new Font("Times new Roman",Font.BOLD,20));
        t4_ration_id.setFont(new Font("Times new Roman",Font.BOLD,20));
        t5_passport.setFont(new Font("Times new Roman",Font.BOLD,20));
        t6_father_name.setFont(new Font("Times new Roman",Font.BOLD,20));
        
        c1_adhaar_no=new JCheckBox();
        c2_adhhar_name=new JCheckBox();
        c3_addhhar_address=new JCheckBox();
        c4_ration_id=new JCheckBox();
        c5_passport=new JCheckBox();
        c6_father_name=new JCheckBox();
        
        getContentPane().setBackground(Color.cyan);
        c1_adhaar_no.setBounds(600,100,50,30);
        c2_adhhar_name.setBounds(600,200,50,30);
        c3_addhhar_address.setBounds(600,300,50,30);
        c4_ration_id.setBounds(600,400,50,30);
        c5_passport.setBounds(600,500,50,30);
        c6_father_name.setBounds(600,600,50,30);
        
        b1_submit=new JButton("Submit");
        b1_submit.setBounds(350,700,150,50);
        b1_submit.setFont(new Font("Times new Roman",Font.BOLD,20));
        
        b2_back=new JButton("Back");
        b2_back.setBounds(550,700,150,50);
        b2_back.setFont(new Font("Times new Roman",Font.BOLD,20));
        
        b2_back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new new_View_table(str);
            }
        });
        
        b1_submit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
              String adhaar_no=t1_adhaar_no.getText();
              String adhaar_name=t2_adhhar_name.getText();
              String adhaar_address=t3_addhhar_address.getText();
              String ration_id=t4_ration_id.getText();
              String passport=t5_passport.getText();
              String Father_name=t6_father_name.getText();
              
              try
              {
                  Connection connection=Database_Connection.getConnection(str);
                  Statement stmt=connection.createStatement();
                  
              
              if(!adhaar_no.isEmpty())
              {
                  
                  String regex1="^\\d{4}\\s\\d{4}\\s\\d{4}$";
                          
                  Pattern p1=Pattern.compile(regex1);
                  Matcher matches1=p1.matcher(adhaar_no);
                  boolean b1=matches1.matches();
                 
                  if(!b1)
                  {
                      JOptionPane.showMessageDialog(rootPane, "Enter Aadhaar No Corresctly", "Alert", JOptionPane.WARNING_MESSAGE);
                  }
                  else
                  {
                  String st="0";
                  if(c1_adhaar_no.isSelected())
                  {
                      st="1";
                  }
                  String pass_value="_PersonalDetails";
                  
                  String query="insert into "+str+pass_value+" values('Adharr_No','"+adhaar_no+"','"+st+"')";
                  int n=stmt.executeUpdate(query);
                  }
              }
              if(!adhaar_name.isEmpty())
              {
                  String st="0";
                  if(c2_adhhar_name.isSelected())
                  {
                      st="1";
                  }
                  String pass_value="_PersonalDetails";
                  
                  String query="insert into "+str+pass_value+" values('Adharr_Name','"+adhaar_name+"','"+st+"')";
                  int n=stmt.executeUpdate(query);
                  
              }
            //  ^[2-9]{1}[0-9]{3}\\s[0-9]{4}\\s[0-9]{4}$
              if(!adhaar_address.isEmpty())
              {
                  String st="0";
                  if(c3_addhhar_address.isSelected())
                  {
                      st="1";
                  }
                  String pass_value="_PersonalDetails";
                  
                  String query="insert into "+str+pass_value+" values('Address','"+adhaar_address+"','"+st+"')";
                  int n=stmt.executeUpdate(query);
              }
              if(!ration_id.isEmpty())
              {
                  String st="0";
                  if(c4_ration_id.isSelected())
                  {
                      st="1";
                  }
                  String pass_value="_PersonalDetails";
                  
                  String query="insert into "+str+pass_value+" values('Ration-Id','"+ration_id+"','"+st+"')";
                  int n=stmt.executeUpdate(query);
              }
              if(!passport.isEmpty())
              {
                  String st="0";
                  if(c5_passport.isSelected())
                  {
                      st="1";
                  }
                  String pass_value="_PersonalDetails";
                  
                  String query="insert into "+str+pass_value+" values('Passport No','"+passport+"','"+st+"')";
                  int n=stmt.executeUpdate(query);
              }
              if(!Father_name.isEmpty())
              {
                  String st="0";
                  if(c6_father_name.isSelected())
                  {
                      st="1";
                  }
                  String pass_value="_PersonalDetails";
                  
                  String query="insert into "+str+pass_value+" values('Father Name','"+Father_name+"','"+st+"')";
                  int n=stmt.executeUpdate(query);
              }
              JOptionPane.showMessageDialog(rootPane, "Successfull");
                  setVisible(false);
              new new_View_table(str);
              }
              catch(Exception ae)
              {
                 System.out.println(ae.getMessage());          
              }
              
            }
        });
        add(l1_adhaar_no);
        add(l2_adhhar_name);
        add(l3_addhhar_address);
        add(l4_ration_id);
        add(l5_passport);
        add(l6_father_name);
        add(l7_title);
        add(l8);
      
        add(t1_adhaar_no);
        add(t2_adhhar_name);
        add(t3_addhhar_address);
        add(t4_ration_id);
        add(t5_passport);
        add(t6_father_name);
        
        add(c1_adhaar_no);
        add(c2_adhhar_name);
        add(c3_addhhar_address);
        add(c4_ration_id);
        add(c5_passport);
        add(c6_father_name);
        
        add(b1_submit);
        add(b2_back);
        setBounds(300,100,1000,900);
        setLayout(null);
        setVisible(true);
        
        
        
        
    }
    
    public static void main(String[] args)
    {
      
    }
    
}
