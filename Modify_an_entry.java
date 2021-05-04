/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Orginal_Project;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Mugundhan.S
 */
public class Modify_an_entry
{
    JLabel l,l_username;
    JTextField t_username;
    JButton b_search,b_back;
    JComboBox combo;
    public Modify_an_entry(String username)
            
    {   JFrame f=new JFrame();
        f.setBounds(500,300,800,400);
        f.getContentPane().setBackground(new Color(42, 43, 41));
        
        f.setResizable(false);
   
        
        l=new JLabel("MODIFY ENTRY");
        l_username=new JLabel("SELECT ID");
        t_username=new JTextField();
        b_search=new JButton("Search Entry");
        b_back=new JButton("Back");            
        
        l.setBounds(230,50,300,40);
        l.setForeground(Color.white);
        l.setFont(new Font("serif",Font.BOLD,35));
        
        
        l_username.setBounds(50,130,200,40);
        l_username.setFont(new Font("Times new roman",Font.BOLD,25));
        l_username.setForeground(Color.white);
        
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
        b_search.setBounds(290,250,250,40);
        b_search.setFont(new Font("Times new Roman",Font.BOLD,25));
        b_search.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        b_back.setBounds(570,250,150,40);
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
            public void actionPerformed(ActionEvent e)
            {
                String email=(String)combo.getSelectedItem();
                if(email.equals(""))
                {
                    JOptionPane.showMessageDialog(f,"This field is mandatory");
                }
                else
                {
                
                int flag=0;
                try
                {
                    Connection con=Database_Connection.getConnection(username);
                    Statement st=con.createStatement();
                    String pass_man="_PasswordManager";
                    String query="select * from "+username+pass_man;
                    ResultSet rs=st.executeQuery(query);
                    //System.out.println("success");
                    while(rs.next())
                    {   
                        if(email.equals(rs.getString("email")))
                        {  flag=1;
                           break;
                        }
                        
                    }
                }
                catch(Exception ae)
                {
                    System.out.println(ae);
                }
                if(flag==0)
                {
                    
                    
                            JFrame f1=new JFrame();
                            f1.setTitle("WARNING!");
                            f1.setBounds(600,400,400,200);
                            f1.getContentPane().setBackground(new Color(138, 185, 219));
                            JLabel l=new JLabel("User not found!");
                            l.setBounds(120,50,150,30);
                            l.setFont(new Font("Sans Serif",Font.BOLD,20));
                            
                            JButton b_tryagain=new JButton("Try again!");
                            JButton b1=new JButton("Cancel");
                            
                            b_tryagain.setBounds(80,100,100,30);
                            b1.setBounds(200,100,100,30);
                            
                            b_tryagain.addActionListener(new ActionListener()
                            {
                                public void actionPerformed(ActionEvent e)
                                {
                                    f1.setVisible(false);
                                    f.setVisible(true);
                                    
                                }
                            });
                            
                            
                            f1.add(l);
                            f1.add(b_tryagain);
                            f1.add(b1);
                            f1.setLayout(null);
                           // f.setVisible(false);
                            f1.setVisible(true);
                        }
                if(flag==1)
                {
                   
                            f.setVisible(false);
                            JFrame f2=new JFrame();
                           // f2.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Tharanya Chikku/chest.jpg")));
                            f2.setTitle("MODIFY");
                            f2.setBounds(310,120,1020,900);
                            f2.getContentPane().setBackground(new Color(42, 43, 41));
                            
                            JLabel l2=new JLabel("Modify an Entry");
                            l2.setBounds(300,20,350,50);
                            l2.setForeground(Color.white);
                            l2.setFont(new Font("serif",Font.BOLD,45));
                            
                            JLabel l2_password=new JLabel("Password");
                            l2_password.setBounds(50,120,150,40);
                            l2_password.setForeground(Color.white);
                            l2_password.setFont(new Font("Times new Roman",Font.BOLD,35));
                            
                            
                            JTextField p_password=new JTextField();
                            p_password.setBounds(420,120,280,50);
                            p_password.setFont(new Font("Times new Roman",Font.BOLD,25));
                            
                            JButton b_pwned=new JButton("Pwned?");
                            b_pwned.setBounds(750,120,150,50);
                            
                            b_pwned.setFont(new Font("Times new Roman",Font.BOLD,25));
                            
                            JButton b_strong=new JButton("Generate Strong Password");
                            JButton b1_personalized=new JButton("Generate Personalized Password");
                            
                            b_strong.setBounds(100,220,350,50);
                            b1_personalized.setBounds(490,220,390,50);
                            
                            b_strong.setFont(new Font("Times new Roman",Font.BOLD,25));
                            b1_personalized.setFont(new Font("Times new Roman",Font.BOLD,25));
                            
                            JLabel l2_websites=new JLabel("Associated Websites");
                            l2_websites.setBounds(50,360,350,40);
                            l2_websites.setForeground(Color.white);
                            l2_websites.setFont(new Font("serif",Font.BOLD,35));
                            
                            JRadioButton r_append=new JRadioButton("Add to existing");
                            r_append.setBounds(50,430,230,30);
                            r_append.setFont(new Font("Times new Roman",Font.BOLD,25));
                            r_append.setForeground(Color.white);
                            r_append.setBackground(new Color(42, 43, 41));
                            
                            JRadioButton r_rewrite=new JRadioButton("Re-write");
                            r_rewrite.setBounds(330,430,130,30);
                            r_rewrite.setForeground(Color.white);
                            r_rewrite.setFont(new Font("Times new Roman",Font.BOLD,25));
                            r_rewrite.setBackground(new Color(42, 43, 41));
                            
                            ButtonGroup bg=new ButtonGroup();
                            bg.add(r_append);
                            bg.add(r_rewrite);
                            
                            JTextField t2_websites=new JTextField();
                            t2_websites.setBounds(420,360,280,50);
                            t2_websites.setFont(new Font("Times new Roman",Font.BOLD,25));
                            
                            JLabel l2_notes=new JLabel("Notes");
                            l2_notes.setBounds(50,500,150,30);
                            l2_notes.setForeground(Color.white);
                            l2_notes.setFont(new Font("serif",Font.BOLD,35));
                            
                            JTextField t2_notes=new JTextField();
                            t2_notes.setBounds(420,500,280,50);
                            t2_notes.setFont(new Font("Times new Roman",Font.BOLD,25));
                            
                            
                            JRadioButton r_append2=new JRadioButton("Add to existing");
                            r_append2.setBounds(50,570,230,30);
                            r_append2.setForeground(Color.white);
                            r_append2.setFont(new Font("Times new Roman",Font.BOLD,25));
                            r_append2.setBackground(new Color(42, 43, 41));
                            
                            JRadioButton r_rewrite2=new JRadioButton("Re-write");
                            r_rewrite2.setBounds(330,570,130,30);
                            r_rewrite2.setForeground(Color.white);
                            r_rewrite2.setFont(new Font("Times new Roman",Font.BOLD,25));
                            r_rewrite2.setBackground(new Color(42, 43, 41));
                            
                            ButtonGroup bg2=new ButtonGroup();
                            bg2.add(r_append2);
                            bg2.add(r_rewrite2);
                            
                            JButton b3_update=new JButton("UPDATE");
                            b3_update.setBounds(450,670,200,40);
                            b3_update.setFont(new Font("Times new Roman",Font.BOLD,35));
                            
                            JButton b3_back=new JButton("BACK");
                            b3_back.setBounds(700,670,150,40);
                            b3_back.setFont(new Font("Times new Roman",Font.BOLD,35));
                            
                            b3_back.addActionListener(new ActionListener() {

                                @Override
                                public void actionPerformed(ActionEvent e) {
                                  //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                                f2.setVisible(false);
                                f.setVisible(true);
                                }
                            });
                            b_strong.addActionListener(new ActionListener()
                            {
                                public void actionPerformed(ActionEvent x)
                                {
                                    String caps="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                                    String small="abcdefghijklmnopqrstuvwxyz";
                                    String special="!@#$%^&*()_+";
                                    String numbers="1234567890";
                                    
                                    String str=caps+small+special+numbers;
                                    Random rand=new Random();
                                    
                                    char arr[]=new char[10];
                                    for(int i=0;i<10;i++)
                                    {
                                        arr[i]=str.charAt(rand.nextInt(str.length()));
                                    }
                                    
                                   String strpass=arr.toString();
                                   p_password.setText(strpass);
                                   
                                }
                            });
                            
                            b1_personalized.addActionListener(new ActionListener()
                            {
                                public void actionPerformed(ActionEvent y)
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
                                                //System.out.println(personalized_pass);
                                                p_password.setText(personalized_pass);
                                          }         
                                            
                                            
                                        
                                        
                                        
                                        catch(Exception exe)
                                        {
                                            System.out.println("308");
                                            System.out.println(exe);
                                        }
                                }
                                
                            });
                            
                            b_pwned.addActionListener(new ActionListener()
                            {
                                public void actionPerformed(ActionEvent xx)
                                {
                                    try 
                                    {
                                      Desktop.getDesktop().browse(new URI("https://haveibeenpwned.com/"));
                                    }
                                    catch (Exception ae) 
                                    {
                                    }
            
                                }
        
                                
                            });
                                    
                            b3_update.addActionListener(new ActionListener()
                            {
                                public void actionPerformed(ActionEvent aa)
                                {
                                    String website=t2_websites.getText();
                                    String notes=t2_notes.getText();   
                                    String password=p_password.getText();
                                    
                                    int p=0;
                                    if(password.equals(""))
                                    {
                                        p=1;
                                    }
                                    if(p==0)
                                    {
                                        password=new encryption().encrypt(password);
                                        try{
                                            Connection con=Database_Connection.getConnection(username);
                                            Statement st=con.createStatement();
                                            String pass_man="_PasswordManager";
                                            String query="Update "+ username+pass_man+" set password='"+password+"' where email='"+email+"'";
                                            
                                            int rs=st.executeUpdate(query);
                                            JOptionPane.showMessageDialog(f, "Password Updated");
                                        
                                        }
                                       catch(Exception ee)
                                        {
                                            System.out.println("362");
                                            System.out.println(ee);
                                        }
                                        
                                    }
                                   
                                    
                                    int choice1=0;
                                    if(r_rewrite.isSelected())
                                    {
                                         choice1=1;
                                    }
                                    int choice2=0;
                                    if(r_append.isSelected())
                                    {
                                        choice2=1;
                                    }
                                    
                                    int choice3=0;
                                    if(r_rewrite2.isSelected())
                                    {
                                         choice3=1;
                                    }
                                    int choice4=0;
                                    if(r_append2.isSelected())
                                    {
                                        choice4=1;
                                    }
                                    
                                    
                                                                                                           
                                    int fl=0;
                                    if(website.equals(""))
                                    {  fl=1;
                                   }
                                    if(fl==0)
                                    {  //System.out.println("hi");
                                       if(choice1==1)//rewrite
                                       {
                                        
                                        website=new encryption().encrypt(website);
                                        try{
                                            Connection con=Database_Connection.getConnection(username);
                                            Statement st=con.createStatement();
                                            String pass_man="_PasswordManager";
                                            String query="Update "+username+pass_man+" set website='"+website+"' where email='"+email+"'";
                                           
                                            int rs=st.executeUpdate(query);
                                        JOptionPane.showMessageDialog(f, "Website Updated");
                                        
                                        }
                                       catch(Exception ee)
                                        {
                                            System.out.println(ee);
                                        }
                                    }
                                    
                                       if(choice2==1)
                                       {
                                           try{
                                               
                                            Connection con=Database_Connection.getConnection(username);
                                            Statement st=con.createStatement();
                                            String pass_man="_PasswordManager";
                                            String query="select * from "+username+pass_man+" where email='"+email+"'";
                                            ResultSet ss=st.executeQuery(query);
                                            String s="";
                                            while(ss.next())
                                            {
                                                 s=ss.getString("website");
                                            }
                                            System.out.println("welcome");
                                            s=new encryption().decrypt(s);
                                            String append=s+","+website;
                                            //rs.close();
                                            append=new encryption().encrypt(append);
                                            String newquery="Update "+username+pass_man+" set website='"+append+"' where email='"+email+"'";
                                            int res=st.executeUpdate(newquery);
                                            JOptionPane.showMessageDialog(f, "Website Updated");
                                        
                                        
                                        }
                                        catch(Exception exe)
                                        {
                                            System.out.println(exe+"hello");
                                        }
                                       }
                               }
                                    
                                    int f1=0;
                                    if(notes.equals(""))
                                    {
                                        f1=1;
                                    }
                                    if(f1==0)
                                    {
                                        if(choice3==1)
                                        {
                                            notes=new encryption().encrypt(notes);
                                        try{
                                            Connection con=Database_Connection.getConnection(username);
                                            Statement st=con.createStatement();
                                            String pass_man="_PasswordManager";
                                            String query="Update "+username+pass_man+ " set notes='"+notes+"' where email='"+email+"'";
                                            int pp=st.executeUpdate(query);
                                              JOptionPane.showMessageDialog(f, "Notes Updated");
                                        
                                        }
                                        catch(Exception ze)
                                        {
                                            System.out.println(ze);
                                        }
                                        
                                        }
                                        
                                        if(choice4==1)
                                        {
                                            try{
                                            Connection con=Database_Connection.getConnection(username);
                                            Statement st=con.createStatement();
                                            String pass_man="_PasswordManager";
                                            String query="select * from "+username+pass_man+" where email='"+email+"'";
                                            ResultSet sr=st.executeQuery(query);
                                            
                                            String string="";
                                            while(sr.next())
                                            {
                                            string=sr.getString("notes");
                                            }
                                            //System.out.println("welcome");
                                            string=new encryption().decrypt(string);
                                            String app=string+","+notes;
                                            //rs.close();
                                            app=new encryption().encrypt(app);
                                            String nquery="Update "+username+pass_man+" set notes='"+app+"' where email='"+email+"'";
                                            int rsq=st.executeUpdate(nquery);
                                           
                                             JOptionPane.showMessageDialog(f, "Notes Updated");
                                        
                                        
                                        }
                                        catch(Exception z)
                                        {
                                            System.out.println(z);
                                        }
                                        }
                                       
                                    }
                                    f2.setVisible(false);
                                    new new_View_table(username);
                                }
                            });
                            
                            
                            f2.add(l2);
                            f2.add(l2_password);
                            f2.add(b_pwned);
                            f2.add(p_password);
                            f2.add(b_strong);
                            f2.add(b1_personalized);
                            f2.add(l2_websites);
                            f2.add(t2_websites);
                            f2.add(l2_notes);
                            f2.add(t2_notes);
                            f2.add(b3_update);
                            f2.add(b3_back);
                            f2.add(r_append);
                            f2.add(r_rewrite);
                            f2.add(r_append2);
                            f2.add(r_rewrite2);
                            f2.setLayout(null);
                            f2.setVisible(true);
                            
                            
                        }
                        
                        
                    }
                    
                }
                
            });
        
        
        
        
        
        f.add(l);
        f.add(l_username);
        f.add(t_username);
        f.add(b_search);
        f.add(b_back);
        f.add(combo);
        f.setLayout(null);
         f.setVisible(true);
    }
    
    
    public static void main(String args[])
    {
     
        
    }
}
