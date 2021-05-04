//Add an Entry to the Password_Manager Table of User

package Orginal_Project;


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
public class Add_an_Entry_Original extends JFrame 
{
    JLabel l1_title,l2_email,l3_password,l4_notes,l5_website,l6_usedin,l7_chck;
    JTextField t2_email,t3_password,t4_notes,t5_website,t6_usedin;
    JButton b1_generate_password,b2_customPassowrd,b3_submit,b4_link,b5_back;
    public Add_an_Entry_Original(String username)
    {
     
       getContentPane().setBackground(new Color(42, 43, 41));
       l1_title=new JLabel("Add an Entry");
       l2_email=new JLabel("Email");
       l3_password=new JLabel("Password");
       l4_notes=new JLabel("Notes");     
       l5_website=new JLabel("Website");
       l6_usedin=new JLabel("Used_in");
       l7_chck=new JLabel("To Check if Your Password is Strong,copy the password and paste it the the Link Provided");
       
       l1_title.setBounds(310,50,350,50);
       l2_email.setBounds(100,160,150,30);
       l3_password.setBounds(100,360,150,30);
       l4_notes.setBounds(100,460,150,30);
       l5_website.setBounds(100,560,150,30);
       l6_usedin.setBounds(100,660,150, 30);
       l7_chck.setBounds(50,400,950,30);
       
       l1_title.setFont(new Font("Times new Roman",Font.BOLD,45));
       l2_email.setFont(new Font("Times new Roman",Font.BOLD,30));
       l3_password.setFont(new Font("Times new Roman",Font.BOLD,30));
       l4_notes.setFont(new Font("Times new Roman",Font.BOLD,30));
       l5_website.setFont(new Font("Times new Roman",Font.BOLD,30));
       l6_usedin.setFont(new Font("Times new Roman",Font.BOLD,30));
       l7_chck.setFont(new Font("Times new Roman",Font.BOLD,20));
       
       l1_title.setForeground(Color.white);
       l2_email.setForeground(Color.white);
       l3_password.setForeground(Color.white);
       l4_notes.setForeground(Color.white);
       l5_website.setForeground(Color.white);
       l6_usedin.setForeground(Color.white);
       l7_chck.setForeground(Color.white);
       
       t2_email=new JTextField();
       t3_password=new JTextField();
       t4_notes=new JTextField();
       t5_website=new JTextField();
       t6_usedin=new JTextField();
       
       t2_email.setBounds(350,150,280,50);
       t3_password.setBounds(350,350,280,50);
       t4_notes.setBounds(350,450,280,50);
       t5_website.setBounds(350,550,280,50);
       t6_usedin.setBounds(350,650,280, 50);
       
       t2_email.setFont(new Font("Times new Roman",Font.BOLD,25));
       t3_password.setFont(new Font("Times new Roman",Font.BOLD,25));
       t4_notes.setFont(new Font("Times new Roman",Font.BOLD,25));
       t5_website.setFont(new Font("Times new Roman",Font.BOLD,25));
       t6_usedin.setFont(new Font("Times new Roman",Font.BOLD,25));
       
       
       
       
       
       
       b1_generate_password=new JButton("Generate Random Passoword");
       b2_customPassowrd=new JButton("Giving Personalize Password");
       b3_submit=new JButton("ADD");
       b4_link=new JButton("Link");
       b5_back=new JButton("Back");
       
       b1_generate_password.setBounds(100,260,320,50);
       b2_customPassowrd.setBounds(470,260,320,50);
       b3_submit.setBounds(350,760,250,50);
       b4_link.setBounds(650,350,160,50);
       b5_back.setBounds(650,760,160,50);
       
       b1_generate_password.setFont(new Font("Times new Roman",Font.BOLD,22));
       b2_customPassowrd.setFont(new Font("Times new Roman",Font.BOLD,22));
       b3_submit.setFont(new Font("Times new Roman",Font.BOLD,32));
       b4_link.setFont(new Font("Times new Roman",Font.BOLD,32));
       b5_back.setFont(new Font("Times new Roman",Font.BOLD,32));       
      
      
       
       
       b5_back.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
             
               setVisible(false);
               new new_View_table(username);
           }
       });
       
       b4_link.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
       
               
                 try 
                 {
                      Desktop.getDesktop().browse(new URL("https://haveibeenpwned.com/").toURI());
                  }
                 catch (Exception ae) 
                 {
                 }
           }
       });
       
       //Generating the Random Password 
       b1_generate_password.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
              
                          int len=10;
                          String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
                          String Small_chars = "abcdefghijklmnopqrstuvwxyz"; 
                          String numbers = "0123456789"; 
                          String symbols = "!@#$%^&*_=+-/.?<>)"; 
  
  
                          String values = Capital_chars + Small_chars + numbers + symbols;
                          Random rndm_method = new Random(); 
  
                          char[] pass = new char[len]; 
  
                          for (int i = 0; i < len; i++) 
                            { 

                                pass[i] = values.charAt(rndm_method.nextInt(values.length())); 
                
                            }

                           String password=pass.toString();
                           t3_password.setText(password);
                           
                         
               
           }
       });
       //Generate Personlized Password Using Relavent data of the User
       b2_customPassowrd.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e)
           {
                  
                 try{
                                            Connection con=Database_Connection.getConnection("main_database");
                                            Statement st=con.createStatement();
                                           
                                            String query="select * from general";
                                            ResultSet sss=st.executeQuery(query);
                                            String string1="";
                                            while(sss.next())
                                            {
                                              if(username.equals(sss.getString("username")))
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
                                               
                                                t3_password.setText(personalized_pass);
                                          }         
                                  
                                        catch(Exception exe)
                                        {
                                            System.out.println("308");
                                            System.out.println(exe);
                                        }
           }
       });
       b3_submit.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e)
           {
               String email=t2_email.getText();
               String password=t3_password.getText();
               String notes=t4_notes.getText();
               String website=t5_website.getText();
               String used_in=t6_usedin.getText();
              
              
               password=new encryption().encrypt(password);
               notes=new encryption().encrypt(notes);
               website=new encryption().encrypt(website);
               used_in=new encryption().encrypt(used_in);
             
               
               if(email.isEmpty() || notes.isEmpty() || website.isEmpty() || used_in.isEmpty()|| password.isEmpty())
               {
                   if(email.isEmpty())
                   {
                       JOptionPane.showMessageDialog(rootPane, "Email Field is Empty", "Alert", JOptionPane.WARNING_MESSAGE);
                   }
                   if(password.isEmpty())
                   {
                        JOptionPane.showMessageDialog(rootPane, "Password Field is Empty", "Alert", JOptionPane.WARNING_MESSAGE);
                   }
                   if(notes.isEmpty())
                   {
                       JOptionPane.showMessageDialog(rootPane, "Notes Field is Empty", "Alert", JOptionPane.WARNING_MESSAGE);
                   }
                   if(website.isEmpty())
                   {
                       JOptionPane.showMessageDialog(rootPane, "Website Field is Empty", "Alert", JOptionPane.WARNING_MESSAGE);
                   }
                   if(used_in.isEmpty())
                   {
                       JOptionPane.showMessageDialog(rootPane, "Used_in Field is Empty", "Alert", JOptionPane.WARNING_MESSAGE);
                   }
               }
               else
               {
                   int x=1;
                  
                try
                  {
                      Connection con=Database_Connection.getConnection(username);
                      Statement st=con.createStatement();
                      String pass_man="_PasswordManager";
                      String str1="select * from "+username+pass_man;
                      ResultSet rs=st.executeQuery(str1);
                      while(rs.next())
                      {
                          if(email.equals(rs.getString("email")))
                          {
                              x=0;
                              break;
                          }
                          
                      }
                      con.close();
                  }
                  catch(Exception ae)
                  {
                      
                  }
                
                     if(x==1)
                     {
                          String regex1="^[A-Za-z0-9+_]+@(.+)";
                          
                          Pattern p1=Pattern.compile(regex1);
                          Matcher matches1=p1.matcher(email);
                          boolean b1=matches1.matches();
                           if(!b1)
                           {
                               JOptionPane.showMessageDialog(rootPane, "Invalid Email", "Alert", JOptionPane.WARNING_MESSAGE);
                           }
                           else
                           {
                            
                                   try
                                    {
                                        Connection con=Database_Connection.getConnection(username);
                                        Statement st=con.createStatement();
                                        String pass_man="_PasswordManager";
                                        String str1="insert into "+username+pass_man+" values('"+email+"','"+password+"','"+notes+"','"+website+"','"+used_in+"')";
                                        int result1=st.executeUpdate(str1);
                                        JOptionPane.showMessageDialog(rootPane, "Success");
                                        setVisible(false);
                                        new new_View_table(username);
                                        System.out.println("Yes");
                                        con.close();
                                    }
                                    catch(Exception ae)

                                    {
                                        System.out.println(ae.getMessage());
                                        JOptionPane.showMessageDialog(rootPane, "Query Failed");
                                    }

                           }
                     }
                     else
                     {
                          JOptionPane.showMessageDialog(rootPane, "Already excited data", "Alert", JOptionPane.WARNING_MESSAGE);
                     }
               }
               
           }
       });
       
       add(l1_title);
       add(l2_email);
       add(l3_password);
       add(l4_notes);
       add(l5_website);
       add(l6_usedin);
       add(l7_chck);
       
       add(t2_email);
       add(t3_password);
       add(t4_notes);
       add(t5_website);
       add(t6_usedin);
       
       add(b1_generate_password);
       add(b2_customPassowrd);
       add(b3_submit);
       add(b4_link);
       add(b5_back);
       setBounds(280,120,1020,900);
       setLayout(null);
       setVisible(true);
        
    }
    
   
    public static void main(String[] args)
    {
      
    }
}
