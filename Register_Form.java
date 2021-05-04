
//Register--Form 
package Orginal_Project;

import java.io.*;
import java.sql.*;
import java.awt.*;
import java.util.regex.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.HeadlessException;
import javax.swing.*;
public class Register_Form  extends JFrame
{
    JLabel l1_user,l2_masterkey,l3_first,l4_last,l5_date,l6_anydata,l7_head,l8_warning,l9_remas,l10_dt,l11_mnth,l12_year;
    JTextField t1_username,t2_mast,t3_name,t4_lst,t5_birth,t6_data,t7_reenter;
    JButton b1_genkey,b2_warning;
    JComboBox c1_date,c2_month,c3_year;
    JPasswordField p1_pass,p2_reenter;
    
    public Register_Form()throws HeadlessException
    {
        setBounds(350,50,850,950);
        getContentPane().setBackground(new Color(43, 41, 42));
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        
        
        
        l7_head = new JLabel("New Registration");
        l7_head.setBounds(250, 20, 350,50);
        l7_head.setForeground(Color.white);
        l7_head.setFont(new Font("Times new Roman",Font.BOLD,40));
        add(l7_head);
        l7_head.setVisible(true);
        
        
        l1_user=new JLabel("Username");
        l1_user.setBounds(100, 100, 350,50);
        l1_user.setForeground(Color.white);
        l1_user.setFont(new Font("Times new Roman",Font.BOLD,30));
        add(l1_user);
        l1_user.setVisible(true);
        
        
        t1_username =  new JTextField();
        t1_username.setBounds(350,110,350,40);
        t1_username.setForeground(Color.black);
        t1_username.setFont(new Font("Times new Roman",Font.BOLD,30));
        add(t1_username);
        t1_username.setVisible(true);
        
        
        l2_masterkey = new JLabel("Masterkey");
        l2_masterkey.setBounds(100, 200, 350,50);
        l2_masterkey.setForeground(Color.white);
        l2_masterkey.setFont(new Font("Times new Roman",Font.BOLD,30));
        add(l2_masterkey);
        l2_masterkey.setVisible(true);
        
        p1_pass =new JPasswordField();
        p1_pass.setBounds(350,210,350,40);
        p1_pass.setForeground(Color.black);
        p1_pass.setFont(new Font("Times new Roman",Font.BOLD,30));
        add(p1_pass);
        p1_pass.setVisible(true);
        
        l9_remas = new JLabel("Confirm Masterkey");
        l9_remas.setBounds(100, 300, 350,50);
        l9_remas.setForeground(Color.white);
        l9_remas.setFont(new Font("Times new Roman",Font.BOLD,30));
        add(l9_remas);
        l9_remas.setVisible(true);
        
        p2_reenter =new JPasswordField();
        p2_reenter.setBounds(350,310,350,40);
        p2_reenter.setForeground(Color.black);
        add(p2_reenter);
        p2_reenter.setFont(new Font("Times new Roman",Font.BOLD,30));
        p2_reenter.setVisible(true);
        
        
        
        l3_first = new JLabel("First Name");
        l3_first.setBounds(100, 400, 350,50);
        l3_first.setForeground(Color.white);
        l3_first.setFont(new Font("Times new Roman",Font.BOLD,30));
        add(l3_first);
        l3_first.setVisible(true);
        
        
        t3_name =  new JTextField();
        t3_name.setBounds(350,410,350,40);
        t3_name.setForeground(Color.black);
        add(t3_name);
        t3_name.setFont(new Font("Times new Roman",Font.BOLD,30));
        t3_name.setVisible(true);
        
        
        
        l4_last = new JLabel("Last Name");
        l4_last.setBounds(100, 500, 350,50);
        
        l4_last.setForeground(Color.white);
        l4_last.setFont(new Font("Times new Roman",Font.BOLD,30));
        add(l4_last);
        l4_last.setVisible(true);
        
        
        t4_lst =  new JTextField();
        t4_lst.setBounds(350,510,350,40);
        t4_lst .setForeground(Color.black);
        t4_lst.setFont(new Font("Times new Roman",Font.BOLD,30));
        add(t4_lst);
        t4_lst.setVisible(true);
       
        
        l5_date = new JLabel("Date of Birth");
        l5_date.setBounds(100, 600, 350,50);
        l5_date.setForeground(Color.white);
        l5_date.setFont(new Font("Times new Roman",Font.BOLD,30));
        add( l5_date);
        l5_date.setVisible(true);
        
        l10_dt=new JLabel("DATE");
        l10_dt.setBounds(350, 570, 150,50);
        l10_dt.setForeground(Color.white);
        l10_dt.setFont(new Font("Times new Roman",Font.BOLD,20));
        add(l10_dt);
        l10_dt.setVisible(true);
        
        
        l11_mnth=new JLabel("MONTH");
        l11_mnth.setBounds(450, 570, 150,50);
        l11_mnth.setForeground(Color.white);
        l11_mnth.setFont(new Font("Times new Roman",Font.BOLD,20));
        add(l11_mnth);
        l11_mnth.setVisible(true);
        
        
        l12_year=new JLabel("YEAR");
        l12_year.setBounds(550, 570, 150,50);
        l12_year.setForeground(Color.white);
        l12_year.setFont(new Font("Times new Roman",Font.BOLD,20));
        add(l12_year);
        l12_year.setVisible(true);
        
        
        String date[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        c1_date = new JComboBox(date);
        c1_date.setBounds(350,610,50,40);    
        add(c1_date);        
        c1_date.setLayout(null);        
        c1_date.setVisible(true);
        
    
       
        
        String month[] = {"1","2","3","4","5","6","7","8","9","10","11","12"};
        c2_month = new JComboBox(month);
        c2_month.setBounds(450,610,50,40);    
        add(c2_month);        
        c1_date.setLayout(null);        
        c1_date.setVisible(true);
        
        
        String year[] = {"1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002"};
        c3_year = new JComboBox(year);
        c3_year.setBounds(550,610,50,40);    
        add(c3_year);        
        c3_year.setLayout(null);        
        c3_year.setVisible(true);
        
        
        
        l6_anydata = new JLabel("Relevant Data");
        l6_anydata.setBounds(100, 700, 350,50);
        l6_anydata.setForeground(Color.white);
        l6_anydata.setFont(new Font("Times new Roman",Font.BOLD,30));
        add(l6_anydata);
        l6_anydata.setVisible(true);
        
        
        t6_data =  new JTextField();
        t6_data.setBounds(350,710,350,40);
        t6_data .setForeground(Color.black);
        t6_data.setFont(new Font("Times new Roman",Font.BOLD,30));
        add(t6_data);
        t6_data.setVisible(true);
        
        
        b1_genkey =new JButton("Create User");
        b1_genkey.setBounds(300,800,200,50);
        b1_genkey.setFont(new Font("Times new Roman",Font.BOLD,30));
        b1_genkey.setForeground(Color.black);
        add(b1_genkey);
        b1_genkey.setVisible(true);
        setVisible(true);
        
        
         b1_genkey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String user = t1_username.getText();
                String mast = p1_pass .getText();
                String reenter = p2_reenter .getText();
                String name = t3_name.getText();
                String lst = t4_lst.getText();
                String data = t6_data.getText();
                String date1 = c1_date.getSelectedItem().toString();
                String month1 = c2_month.getSelectedItem().toString();
                String year1 = c3_year.getSelectedItem().toString();
             
                
                if(user.isEmpty() || mast.isEmpty() || name.isEmpty() || lst.isEmpty() || data.isEmpty() )
                {
                    if(user.isEmpty())
                    {
                        JOptionPane j = new JOptionPane();
                        j.showMessageDialog(rootPane, "Your username cannot be Empty!","Alert",JOptionPane.WARNING_MESSAGE);
                        JFrame f=new JFrame();
                        b2_warning=new JButton("OK");
                        b2_warning.setBounds(120,140,80,30);
                        b2_warning.setForeground(Color.black);
                        b2_warning.setFont(new Font("Times new Roman",Font.BOLD,20));
                        f.add(b2_warning);
                        
                        
                        b2_warning.addActionListener(new ActionListener() {
                         @Override
                         public void actionPerformed(ActionEvent e) {
                           f.setVisible(false);
                         }
                     });
                     f.setLayout(null);
                     f.setVisible(true);
                    }
                    else if(mast.isEmpty())
                    {
                        JOptionPane je = new JOptionPane();
                        je.showMessageDialog(rootPane, "Please enter the masterkey!","Alert",JOptionPane.WARNING_MESSAGE);
                        JFrame f=new JFrame();
                        b2_warning=new JButton("OK");
                        b2_warning.setBounds(120,140,80,30);
                        b2_warning.setForeground(Color.black);
                        b2_warning.setFont(new Font("Times new Roman",Font.BOLD,20));
                        f.add(b2_warning);
                        
                        
                        b2_warning.addActionListener(new ActionListener() {
                         @Override
                         public void actionPerformed(ActionEvent e) {
                           f.setVisible(false);
                         }
                     });
                     f.setLayout(null);
                     f.setVisible(true);
                    }
                    else if(name.isEmpty())
                     {
                        JOptionPane je = new JOptionPane();
                        je.showMessageDialog(rootPane, "Please enter the first name!","Alert",JOptionPane.WARNING_MESSAGE);
                        JFrame f=new JFrame();
                        b2_warning=new JButton("OK");
                        b2_warning.setBounds(120,140,80,30);
                        b2_warning.setForeground(Color.black);
                        b2_warning.setFont(new Font("Times new Roman",Font.BOLD,20));
                        f.add(b2_warning);
                        
                        
                        b2_warning.addActionListener(new ActionListener() {
                         @Override
                         public void actionPerformed(ActionEvent e) {
                           f.setVisible(false);
                         }
                     });
                     f.setLayout(null);
                     f.setVisible(true);
                    }
                    else if(lst.isEmpty())
                    {
                        JOptionPane jef = new JOptionPane();
                        jef.showMessageDialog(rootPane, "Please enter the last name!","Alert",JOptionPane.WARNING_MESSAGE);
                        JFrame f=new JFrame();
                        b2_warning=new JButton("OK");
                        b2_warning.setBounds(120,140,80,30);
                        b2_warning.setForeground(Color.black);
                        b2_warning.setFont(new Font("Times new Roman",Font.BOLD,20));
                        f.add(b2_warning);
                        
                        
                        b2_warning.addActionListener(new ActionListener() {
                         @Override
                         public void actionPerformed(ActionEvent e) {
                           f.setVisible(false);
                         }
                     });
                     f.setLayout(null);
                     f.setVisible(true);
                    }
                    else if(data.isEmpty())
                    {
                        JOptionPane jef = new JOptionPane();
                        jef.showMessageDialog(rootPane, "Please enter the relevant data!","Alert",JOptionPane.WARNING_MESSAGE);
                       
                        JFrame f=new JFrame();
                        b2_warning=new JButton("OK");
                        b2_warning.setBounds(120,140,80,30);
                        b2_warning.setForeground(Color.black);
                        b2_warning.setFont(new Font("Times new Roman",Font.BOLD,20));
                        f.add(b2_warning);
                        
                        
                        b2_warning.addActionListener(new ActionListener() {
                         @Override
                         public void actionPerformed(ActionEvent e) {
                           f.setVisible(false);
                         }
                     });
                     f.setLayout(null);
                     f.setVisible(true);
                    }  
                    
                }
                else
                {
                    String pattern = "^[a-zA-Z0-9_.-]*$";
                    Pattern p =  Pattern.compile(pattern);
                    Matcher m = p.matcher(user);
                    
                    
                    String pattern_for_masterkey = "^(?=\\S*[a-z])(?=\\S*[A-Z])(?=\\S*\\d)(?=\\S*[^\\w\\s])\\S{8,16}$";
                    Pattern ps =  Pattern.compile(pattern_for_masterkey);
                    Matcher mq = ps.matcher(mast);
                    
                    
                    String pattern_first_name = "[a-zA-Z]{5,15}";
                    Pattern pi = Pattern.compile(pattern_first_name);
                    Matcher ma = pi.matcher(name);
                    
                    
                    String pattern_last_name = "[a-zA-Z]{4,15}";
                    Pattern pic = Pattern.compile(pattern_last_name);
                    Matcher mac = pic.matcher(name);
                    
                    
                   if(!m.find())
                   {
                       JOptionPane jefr = new JOptionPane();
                       jefr.showMessageDialog(rootPane, "Your username should contain only characters and digits!","Alert",JOptionPane.WARNING_MESSAGE);
                   }
                   else if(!mq.find())
                   {
                       JOptionPane jefre = new JOptionPane();
                       jefre.showMessageDialog(rootPane, "Your masterkey must have 8-16 characters,numbers,letters and special characters!","Alert",JOptionPane.WARNING_MESSAGE);
                   }
                   else if(!ma.find())
                   {
                      JOptionPane jf = new JOptionPane();
                       jf.showMessageDialog(rootPane, "Your first name should only contain alphabhets!","Alert",JOptionPane.WARNING_MESSAGE); 
                   }
                   else if(!mac.find())
                   {
                       JOptionPane jk = new JOptionPane();
                       jk.showMessageDialog(rootPane, "Your last name should only contain alphabhets!","Alert",JOptionPane.WARNING_MESSAGE); 
                   }
                   else if(!mast.equals(reenter))
                    {
                        JOptionPane jl = new JOptionPane();
                        jl.showMessageDialog(rootPane, "Please ensure that masterkey and confirm masterkey must be the same!","Alert",JOptionPane.WARNING_MESSAGE);
                       
                        JFrame f=new JFrame();
                        b2_warning=new JButton("OK");
                        b2_warning.setBounds(120,140,80,30);
                        b2_warning.setForeground(Color.white);
                        b2_warning.setFont(new Font("Times new Roman",Font.BOLD,20));
                        f.add(b2_warning);
                        
                        
                        b2_warning.addActionListener(new ActionListener() {
                         @Override
                         public void actionPerformed(ActionEvent e) {
                           f.setVisible(false);
                         }
                     });
                     f.setLayout(null);
                     f.setVisible(true);
                    }
                   else
                   {
                    try
                    {
                        Connection con=Orginal_Project.Database_Connection.getConnection("main_database");
                        Statement stmt=con.createStatement();  
                        String query1 = "select * from general";
                        ResultSet s = stmt.executeQuery(query1);
                        System.out.println("Quesry exe");
                       int flag = 0;
                        while(s.next())
                        {
                           
                           
                            if(user.equals(s.getString("username")))
                            {
                              flag = 1;
                              
                               JOptionPane jm = new JOptionPane();
                               JOptionPane.showMessageDialog(rootPane, "You already have an account!","Alert",JOptionPane.WARNING_MESSAGE);
                               break;
                            }
                           
                        }
//                     
                        System.out.println("Good ones");
                    if(flag == 1)
                    {
                        JOptionPane jm = new JOptionPane();
                        JOptionPane.showMessageDialog(rootPane, "This user name already exist please try with another one!","Alert",JOptionPane.WARNING_MESSAGE);
                        
                    }
                    if(flag ==0)
                    {
                       
                            
                              try
                              {
                                  try (Connection con1 = Database_Connection.getConnection("main_database")) {
                                      Statement stmt1=con1.createStatement();
                                      String temp=name+","+lst+","+data+","+date1+","+month1+","+year1;
                                      String qu="insert into general values('"+user+"','"+mast+"','"+temp+"')";
                                      int res=stmt1.executeUpdate(qu);
                                  }
                                  
                                  Class.forName("com.mysql.cj.jdbc.Driver");
                                  String string="jdbc:mysql://localhost:3308/";
                                  Connection connection=DriverManager.getConnection(string, "root", "");
                                  Statement statement=connection.createStatement();
                                  String query="create database "+user;
                                  int n=statement.executeUpdate(query);
                                  connection.close();
                                  
                                  Connection connection1=Database_Connection.getConnection(user);
                                  Statement statement1=connection1.createStatement();
                                  String pass_value="_PasswordManager";
                                  String query2="create table "+user+pass_value+"(email varchar(255),password varchar(255),notes varchar(255),website varchar(255),used_in varchar(255))";
                                  int n1=statement1.executeUpdate(query2);
                                  
                                  String pass_value1="_PersonalDetails";
                                  String query3="create table "+user+pass_value1+"(content varchar(255),value varchar(255),essential varchar(255))";
                                  int n2=statement1.executeUpdate(query3);
                                  
                                  
                                  
                                  String pass_value2="_AccountDetails";
                                  String query4="create table "+user+pass_value2+"(acc_number varchar(255),acc_holder varchar(255),bank_name varchar(255),branch_name varchar(255),ifsc varchar(255))";
                                  int n3=statement1.executeUpdate(query4);
                                  
                                  String pass_value3="_CardDetails";
                                  String query5="create table "+user+pass_value3+"(card_num varchar(255),holder varchar(255),expiry varchar(255),cvv varchar(255),card_type varchar(255))";
                                  int n4=statement1.executeUpdate(query5);
                                  connection1.close();
                                  
                                  JOptionPane.showMessageDialog(rootPane,"Success");
                                  setVisible(false);
                                  Main_Login main_Login = new Main_Login();
                              }
                              catch(SQLException | ClassNotFoundException | HeadlessException ae)
                              {
                                  
                              }
                         
                    }
                    }
                    catch(SQLException | HeadlessException exe)
                    {
                       System.out.println(exe);
                    }
                   }
                }
               
            }
        });
        
    }
    public static void main(String args[])
    {
       new Register_Form();
    }
}
