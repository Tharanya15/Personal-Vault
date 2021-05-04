/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Orginal_Project;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
public class Copy_password_Original extends JFrame
{
     JLabel l1_email,l2_title;
    JButton b1_copy,b_back;
    JComboBox combo;
    public Copy_password_Original(String username) 
    {
    
       l1_email=new JLabel("Select Email");
       l2_title=new JLabel("Copy the Password");
       getContentPane().setBackground(new Color(42, 43, 41));
       l1_email.setBounds(50,200,200,30);
       l2_title.setBounds(250,50,450,50);
       
       l1_email.setForeground(Color.white);
       l2_title.setForeground(Color.white);
       
       l1_email.setFont(new Font("Times new Roman",Font.BOLD,30));
       l2_title.setFont(new Font("Times new Roman",Font.BOLD,45));
       
       b_back=new JButton("Back");
         b_back.setBounds(570,400,150,40);
        b_back.setFont(new Font("Times new roman",Font.BOLD,25));
        b_back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        b_back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              setVisible(false);
              new new_View_table(username);
            }
        });
       b1_copy=new JButton("Copy");
       b1_copy.setBounds(400,400,150,40);
      
       b1_copy.setFont(new Font("Times new Roman",Font.BOLD,25));
      
       
       setBounds(500,300,800,600);
       combo=new JComboBox();
       JScrollPane pane=new JScrollPane();
       pane.setBounds(0,40,250,250);
       
       combo.setBounds(300,200,400,40);
       combo.setFont(new Font("Times new Roman",Font.BOLD,20));
       combo.setBackground(Color.white);
      
       combo.add(pane);
       combo.addItem("Select");
           try
                {
                      Connection con=Database_Connection.getConnection(username);
                      String pass_man="_PasswordManager";
                      String str1="select * from "+username+pass_man;
                      PreparedStatement st=con.prepareStatement(str1);
                     
                      ResultSet rs=st.executeQuery();
                       while(rs.next())
                       {
                            combo.addItem(rs.getString("email"));
                       }
                      con.close();
                  }
                  catch(Exception ae)
                  {
                      
                  }
           b1_copy.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
             String email=(String)combo.getSelectedItem();
             if(email.equals("Select"))
             {
                 JOptionPane.showMessageDialog(rootPane, "Please select the email", "Alert", JOptionPane.WARNING_MESSAGE);
             }
             else
             {
                 
                 String myString="";
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
                             myString=rs.getString("password");
                          }
                         
                      }
                      con.close();
                  }
                  catch(Exception ae)
                  {
                      
                  }
                  myString=new encryption().decrypt(myString);
                  StringSelection stringSelection = new StringSelection(myString);
                  Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                  clipboard.setContents(stringSelection, null);
                  setVisible(false);
                  JOptionPane.showMessageDialog(rootPane, "Copied to the Clipboard");
                  new new_View_table(username);
             }
           }
       });
       add(combo);
       add(l1_email);
       add(b1_copy);
       add(b_back);
       add(l2_title);
       setLayout(null);
       setVisible(true);
    }
    
    public static void main(String[] args)
    {
      
    }
    
}
