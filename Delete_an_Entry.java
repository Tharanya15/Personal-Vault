package Orginal_Project;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Delete_an_Entry 
{
   JLabel l, l_username;
    JTextField t_username;
    JButton b_search,b_back;
      JComboBox combo;
    public Delete_an_Entry(String username)
    {
        JFrame f=new JFrame();
        f.setBounds(500,300,800,400);
        f.getContentPane().setBackground(new Color(42, 43, 41));
        f.setResizable(false);
        
        l=new JLabel("DELETE ENTRY");
        l_username=new JLabel("SELECT ID");
        b_search=new JButton("Search Entry");
        b_back=new JButton("Back");
            
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
                    String pass_man="_PasswordManager";
                    String query="select * from "+username+pass_man;
                    ResultSet res=stmt.executeQuery(query);
                     while(res.next())
                       {
                            combo.addItem(res.getString("email"));
                       }
                    con.close();
                  }
                  catch(Exception ae)
                  {
                      ae.printStackTrace();
                      System.out.println();
                  }
        
        l.setBounds(250,50,300,30);
        l.setForeground(Color.white);
        l.setFont(new Font("serif",Font.BOLD,35));
        
        
        l_username.setBounds(50,130,200,30);
        l_username.setFont(new Font("Times new roman",Font.BOLD,25));
        l_username.setForeground(Color.white);
        
      
        
        b_search.setBounds(270,250,250,40);
        b_search.setFont(new Font("Times new roman",Font.BOLD,25));
        b_search.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
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
                    String pass_man="_PasswordManager";
                    String query="select * from "+username+pass_man;
                    ResultSet rs=st.executeQuery(query);
                    while(rs.next())
                    {
                    
                        if(email.equals(rs.getString("email")))
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
                      
                  {  
                      f.setVisible(false);
                      JFrame f1=new JFrame();
                     f1.setTitle("CONFIRMATION");
                     f1.setBounds(650,350,500,400);
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
                                String pass_man="_PasswordManager";
                                String query="Delete from "+username+pass_man+" where email='"+email+"'";
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
       
    } 
}
