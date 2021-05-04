/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Orginal_Project;

import Forms.NewClass4;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.*; 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
public class Password_Generating extends JFrame
{
    JLabel l1_title;
    JTextField t1_pass;
    JButton b1_generate_password,b2_custom,b3_close;
    Password_Generating(String str)
    {
        setBounds(600,300,500,400);
         getContentPane().setBackground(new Color(43, 41, 42));
         setLayout(null);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
        
         
         
        t1_pass = new JTextField();
        t1_pass.setBounds(100,100,250,30);
        t1_pass.setForeground(Color.black);
        t1_pass.setFont(new Font("Times new Roman",Font.BOLD,30));
        add(t1_pass);
        t1_pass.setVisible(true);
        
        
        b1_generate_password = new JButton("Random password");
        b1_generate_password.setBounds(10,150,190,30);
        b1_generate_password.setForeground(Color.black);
        b1_generate_password.setFont(new Font("Times new Roman",Font.BOLD,20));
        add(b1_generate_password);
        b1_generate_password.setVisible(true);
        
        
        b2_custom = new JButton("Customised password");
        b2_custom.setBounds(230,150,230,30);
        b2_custom.setForeground(Color.black);
        b2_custom.setFont(new Font("Times new Roman",Font.BOLD,20));
        add(b2_custom);
        b2_custom.setVisible(true);
        
        
        b3_close = new JButton("Close");
        b3_close.setBounds(150,280,150,30);
        b3_close.setForeground(Color.black);
        b3_close.setFont(new Font("Times new Roman",Font.BOLD,20));
        add(b3_close);
        b3_close.setVisible(true);
        
        
        b1_generate_password.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                          int len=12;
                          String Capital_char = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
                          String Small_char = "abcdefghijklmnopqrstuvwxyz"; 
                          String number = "0123456789"; 
                          String symbol = "!@#$%^&*_=+-/.?<>)"; 
                          String values = Capital_char + Small_char + number + symbol; 
                          Random random_method = new Random();
                          char[] pass = new char[len];
                          for (int i = 0; i < len; i++) 
                            { 

                                pass[i] = values.charAt(random_method.nextInt(values.length())); 
          

                           String password=pass.toString();
                           t1_pass.setText(password);  
               
                            }
            }
        });
        
        
            b2_custom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                   try{
                                            Connection con=Orginal_Project.Database_Connection.getConnection("main_database");
                                            Statement st=con.createStatement();
                                           
                                            String query="select * from general";
                                            ResultSet sss=st.executeQuery(query);
                                            String string1="";
                                            while(sss.next())
                                            {
                                              if(str.equals(sss.getString("username")))
                                              {
                                             string1=sss.getString("relavent");
                                              }
                                            }
                                            String array[]=string1.split(",");
                                            ArrayList<String>  relevant_details=new ArrayList<String>();
                                             
                                            Random rd=new Random();
                                            for(int i=0;i<array.length;i++)
                                            {
                                                relevant_details.add(array[i].trim());
                                            }
                                            ArrayList<String> temp=relevant_details;
                                            String personalized_pass="";
                                            String charset="._/:!#@$*";
                                            for(int j=0;j<3;j++)
                                            {
                                                int index=rd.nextInt(temp.size());
                                                personalized_pass+=relevant_details.get(index);
                                                if(j!=2) {
                                                personalized_pass+=charset.charAt(rd.nextInt(charset.length()));;    
                                                }
                                                  temp.remove(index);
                                            }   
                                               
                                                t1_pass.setText(personalized_pass);
                                          }         
                                  
                                        catch(Exception exe)
                                        {
                                            System.out.println("308");
                                            System.out.println(exe);
                                        }
               
            }
        });
        
        b3_close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  setVisible(false);
                  setDefaultCloseOperation(EXIT_ON_CLOSE);
            }
        });
        
        
        setVisible(true);
        
        }
        public static void main(String args[])
        {
           new Password_Generating("Mugundhan");
        }
}
