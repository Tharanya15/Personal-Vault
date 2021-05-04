/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Orginal_Project;

/**
 *
 * @author Mugundhan.S
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class Add_an_Entry_Personal extends JFrame
{

    JLabel l1_Field ,l2_value,l3_title;
    JTextField t1_Field ,t2_value;
    JButton b1_sumbit,b2_back;
    JCheckBox c1_check;
    public Add_an_Entry_Personal(String str)
    {
    
        setBounds(450,320,700,600);
        
        l1_Field=new JLabel("Field Name");
        l2_value=new JLabel("Value");
        l3_title=new JLabel("Add an Entry");
        
        l1_Field.setBounds(100,100,150,50);
        l2_value.setBounds(100,200,150,50);
        l3_title.setBounds(200,20,300,50);
        
        l1_Field.setFont(new Font("Times new Roman",Font.BOLD,22));
        l2_value.setFont(new Font("Times new Roman",Font.BOLD,22));
        l3_title.setFont(new Font("Times new Roman",Font.BOLD,42));
        
        c1_check=new JCheckBox("Essential");
        c1_check.setBounds(100,300,150,50);
        c1_check.setFont(new Font("Times new Roman",Font.BOLD,22));
        t1_Field=new JTextField();
        t2_value=new JTextField();
        
        t1_Field.setBounds(300,100,250,50);
        t2_value.setBounds(300,200,250,50);
     //   l3_title.setBounds(200,20,300,50);
        
        t1_Field.setFont(new Font("Times new Roman",Font.BOLD,22));
        t2_value.setFont(new Font("Times new Roman",Font.BOLD,22));
        
        b1_sumbit=new JButton("Submit");
        b1_sumbit.setBounds(350,300,150,50);
        b1_sumbit.setFont(new Font("Times new Roman",Font.BOLD,22));
        
        b2_back=new JButton("Back");
        b2_back.setBounds(350,400,150,50);
        b2_back.setFont(new Font("Times new Roman",Font.BOLD,22));
        b2_back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                setVisible(false);
                new new_View_table(str);
            }
        });
        b1_sumbit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              String field=t1_Field.getText();
              String value=t2_value.getText();
              if(field.isEmpty() || value.isEmpty())
              {
                  
                  if(field.isEmpty())
                  {
                      JOptionPane.showMessageDialog(rootPane, "Field is Empty", "Alert", JOptionPane.WARNING_MESSAGE);
                  }
                  if(value.isEmpty())
                  {
                      JOptionPane.showMessageDialog(rootPane, "Value is Empty", "Alert", JOptionPane.WARNING_MESSAGE);
                  }
              }
              else
              {
                 try
                 {
                     String st="0";
                     if(c1_check.isSelected())
                     {
                         st="1";
                     }
                     Connection con=Database_Connection.getConnection(str);
                     Statement stmt=con.createStatement();
                     String pass_value="_PersonalDetails";
                     
                     String query="insert into "+str+pass_value+" values('"+field+"','"+value+"','"+st+"')";
                     int n=stmt.executeUpdate(query);
                     JOptionPane.showMessageDialog(rootPane, "Success");
                     setVisible(false);
                     new new_View_table(str);
                     
                 }
                 catch(Exception ae)
                 {
                     System.out.println(ae.getMessage());
                 }
              }
            }
        });
        add(l1_Field);
        add(l2_value);
        add(l3_title);
        add(t1_Field);
        add(t2_value);
        add(b1_sumbit);
        add(b2_back);
        add(c1_check);
        getContentPane().setBackground(Color.cyan);
        setLayout(null);
        setVisible(true);
    }
    
    public static void main(String[] args)
    {
        new Add_an_Entry_Personal("Mugundhan");
    }
    
}
