
package Orginal_Project;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.*;
/**
 *
 * @author Mugundhan.S
 */
public class Delete_an_Entry_Personal extends JFrame
{
  JLabel l, l_username;
    JTextField t_username;
    JButton b_search,b_back;
      JComboBox combo;
    public Delete_an_Entry_Personal(String username)
    {
        JFrame f=new JFrame();
        f.setBounds(500,300,800,400);
        f.getContentPane().setBackground(new Color(42, 43, 41));
       
        f.setResizable(false);
        
        l=new JLabel("DELETE ENTRY");
        l_username=new JLabel("Select Content");
    
        b_search=new JButton("Search Entry");
        
            
        combo=new JComboBox();
        JScrollPane pane=new JScrollPane();
        pane.setBounds(0,40,250,250);
     
        combo.setBounds(270,130,350,30);
        combo.setFont(new Font("Times new Roman",Font.BOLD,20));
        combo.setBackground(Color.white);
      
       combo.add(pane);
        
       combo.addItem("Select");
           try
                {
                    Connection con=Database_Connection.getConnection(username);
                    Statement stmt=con.createStatement();
                    String pass_man="_PersonalDetails";
                    String query="select * from "+username+pass_man;
                    ResultSet res=stmt.executeQuery(query);
                     while(res.next())
                       {
                            combo.addItem(res.getString("content"));
                       }
                    con.close();
                  }
                  catch(Exception ae)
                  {
                      ae.printStackTrace();
                      System.out.println();
                  }
        
        l.setBounds(250,50,350,30);
        l.setForeground(Color.white);
        l.setFont(new Font("serif",Font.BOLD,35));
        
        
        l_username.setBounds(50,130,200,30);
        l_username.setFont(new Font("Times new roman",Font.BOLD,20));
        l_username.setForeground(Color.white);
        
        //t_username.setBounds(270,130,350,30);
        
        b_search.setBounds(270,250,250,40);
        b_search.setCursor(new Cursor(Cursor.HAND_CURSOR));
         b_search.setFont(new Font("Times new roman",Font.BOLD,25));
        
        b_back=new JButton("Back");
        b_back.setBounds(550,250,150,40);
        b_back.setFont(new Font("Times new roman",Font.BOLD,25));
        b_back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        b_back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              f.setVisible(false);
              new new_View_table(username);
            }
        });
        
        b_search.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String email=(String)combo.getSelectedItem();
                if(email.equals(""))
                {
                    JOptionPane.showMessageDialog(f,"Madatory Field!");
                }
                else
                {   int flag=0;
                    try{
                    Connection con=Database_Connection.getConnection(username);
                    Statement st=con.createStatement();
                    String pass_man="_PersonalDetails";
                    String query="select * from "+username+pass_man;
                    ResultSet rs=st.executeQuery(query);
                    while(rs.next())
                    {
                     //   String res=new encryption().decrypt(rs.getString("email"));
                        if(email.equals(rs.getString("content")))
                        {
                            flag=1;
                            break;
                        }
                    }
                    
                }
                catch(Exception ex)
                {
                    System.out.println(ex);
                }
                  if(flag==1)
                  {  JFrame f1=new JFrame();
                     f1.setTitle("CONFIRMATION");
                     f1.setBounds(600,400,500,400);
                     f1.getContentPane().setBackground(new Color(42, 43, 41));
                     f1.setResizable(false);
                     
                     JLabel l1=new JLabel("Are you sure?");
                     l1.setBounds(140,50,250,30);
                     l1.setForeground(Color.white);
                     l1.setFont(new Font("serif",Font.BOLD,30));
                     
                     JButton b_yes=new JButton("Yes,I'm sure!");
                     b_yes.setBounds(80,200,150,30);
                     
                     JButton b_cancel=new JButton("Cancel");
                     b_cancel.setBounds(280,200,150,30);
                     
                     
                    b_yes.addActionListener(new ActionListener()
                    {
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                        try{
                                Connection con=Database_Connection.getConnection(username);
                                Statement st=con.createStatement();
                                String pass_man="_PersonalDetails";
                                String query="Delete from "+username+pass_man+" where content='"+email+"'";
                                int rs=st.executeUpdate(query);
                                JOptionPane.showMessageDialog(f1,"Sucessfully deleted!");
                                f.setVisible(false);
                                f1.setVisible(false);
                                new new_View_table(username);
                    
                           }
                   catch(Exception ec)
                      {
                            System.out.println(ec);
                      }
                      }
                  }); 
                    
                    b_cancel.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent es)
                        {
                            f1.setVisible(false);
                            f.setVisible(true);
                        }
                    });
                    
                    
                    
                    f1.add(l1);
                    f1.add(b_yes);
                    f1.add(b_cancel);
                    f1.setLayout(null);
                    f1.setVisible(true);
                }
                  if(flag==0)
                  {
                      JOptionPane.showMessageDialog(f,"user doesn't exist!");
                  }
                      
                    
                    
                    
                    
                    
                    
                }
                
            }
        });
        
        f.add(l);
        f.add(l_username);
        f.add(combo);
        f.add(b_search);
        f.add(b_back);
        f.setLayout(null);
        f.setVisible(true);
        
    }
    
    public static void main(String args[])
    {
        new Delete_an_Entry_Personal("Mugundhan");
    }     
}
