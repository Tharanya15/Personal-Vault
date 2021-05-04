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
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Add_an_Entry_Card
{
   JLabel l,l_cardno,l_bank,l_acctype,l_cardtype,l_cardname,l_cvv,l_expiry;
    JTextField t_cardno,t_bank,t_cardname,t_cvv,t_expiry;
    JComboBox c_acctype,c_cardtype;
    JButton b_add,b_cancel;
    public Add_an_Entry_Card(String str)
    {   JFrame f=new JFrame();
        f.setTitle("Card Details");
        f.setBounds(530,50,700,950);
        f.getContentPane().setBackground(new Color(42, 43, 41));
        
        l=new JLabel("Card Details");
        l_cardno=new JLabel("Card Number");
        l_bank=new JLabel("Bank Name");
        l_acctype=new JLabel("Account Type");
        l_cardtype=new JLabel("Card Type");
        l_cardname=new JLabel("Card Holder Name");
        l_cvv=new JLabel("CVV");
        l_expiry=new JLabel("Expiry Date");
        
        l.setBounds(240,30,250,30);
        l_cardno.setBounds(100,100,150,30);
        l_bank.setBounds(100,200,150,30);
        l_acctype.setBounds(100,300,150,30);
        l_cardtype.setBounds(100,400,150,30);
        l_cardname.setBounds(100,500,250,30);
        l_cvv.setBounds(100,600,150,30);
        l_expiry.setBounds(100,700,150,30);
         
        
       // l.setForeground(new Color(245, 90, 66));5, 247, 243
         l.setForeground(new Color(199,22,87));
        l_cardno.setForeground(new Color(199,22,87));
        l_bank.setForeground(new Color(199,22,87));
        l_acctype.setForeground(new Color(199,22,87));
        l_cardtype.setForeground(new Color(199,22,87));
        l_cardname.setForeground(new Color(199,22,87));
        l_cvv.setForeground(new Color(199,22,87));
        l_expiry.setForeground(new Color(199,22,87));
        
        l.setFont(new Font("Dialog",Font.BOLD,40));
        l_cardno.setFont(new Font("serif",Font.BOLD,25));
        l_bank.setFont(new Font("serif",Font.BOLD,25));
        l_acctype.setFont(new Font("serif",Font.BOLD,25));
        l_cardtype.setFont(new Font("serif",Font.BOLD,25));
        l_cardname.setFont(new Font("serif",Font.BOLD,25));
        l_cvv.setFont(new Font("serif",Font.BOLD,25));
        l_expiry.setFont(new Font("serif",Font.BOLD,25));
        
        t_cardno=new JTextField();
        t_bank=new JTextField();
        t_cardname=new JTextField();
        t_cvv=new JTextField();
        t_expiry=new JTextField();
        
        JPanel p=new JPanel();
        p.setBounds(325,95,263,42);
        p.setBackground(new Color(199,22,87));
        
        JPanel p1=new JPanel();
        p1.setBounds(325,195,263,42);
        p1.setBackground(new Color(199,22,87));
        
        JPanel p2=new JPanel();
        p2.setBounds(325,295,263,42);
        p2.setBackground(new Color(199,22,87));
        
        JPanel p3=new JPanel();
        p3.setBounds(325,395,263,42);
        p3.setBackground(new Color(199,22,87));
        
        JPanel p4=new JPanel();
        p4.setBounds(325,495,263,42);
        p4.setBackground(new Color(199,22,87));
        
        JPanel p5=new JPanel();
        p5.setBounds(325,595,263,42);
        p5.setBackground(new Color(199,22,87));
        
        JPanel p6=new JPanel();
        p6.setBounds(325,695,263,42);
        p6.setBackground(new Color(199,22,87));
        
        t_cardno.setBounds(330,100,250,30);
        t_bank.setBounds(330,200,250,30); 
        t_cardname.setBounds(330,500,250,30);
        t_cvv.setBounds(330,600,250,30);
        t_expiry.setBounds(330,700,250,30);
        
        
        String account_type[]={"Savings Account","Current Account"};
        c_acctype=new JComboBox(account_type);
        c_acctype.setBounds(330,300,250,30);
        
        
        String card_type[]={"Visa","Mastercard","American Express","Discover"};
        c_cardtype=new JComboBox(card_type);
        c_cardtype.setBounds(330,400,250,30);
        
        
        b_add=new JButton("Add");
        b_cancel=new JButton("Cancel");
        
        b_add.setBounds(200,800,150,50);
        b_cancel.setBounds(380,800,150,50);
        
        b_add.setBackground(new Color(199,22,87));
        b_cancel.setBackground(new Color(199,22,87));
        
        b_add.setFont(new Font("Monospace",Font.BOLD,35));
        b_cancel.setFont(new Font("Monospace",Font.BOLD,35));
        
        b_cancel.addActionListener(new ActionListener()
        { 
            public void actionPerformed(ActionEvent w)
        {
             f.setVisible(false);
             new new_View_table(str);
        }
           
        });
        
        b_add.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String card_no=t_cardno.getText();
                String bank=t_bank.getText();
                String acc_type=(String) c_acctype.getSelectedItem();
               // System.out.println(acc_type);
                String card_type=(String) c_cardtype.getSelectedItem();
                String card_name=t_cardname.getText();
                String cvv=t_cvv.getText();
                String expiry=t_expiry.getText();
                
                if(card_no.equals("")|| bank.equals("")|| acc_type.equals("")|| card_type.equals("")||card_name.equals("") || cvv.equals("")|| expiry.equals(""))
                {
                    if(card_no.equals(""))
                    {
                        
                      JOptionPane.showMessageDialog(null,"Card number is mandatory!");
                    }
                    else if(bank.equals(""))
                    {
                        JOptionPane.showMessageDialog(null,"Bank name is mandatory!");
                    }
                    else if(acc_type.equals(""))
                    {
                         JOptionPane.showMessageDialog(null,"Account type is mandatory!");
                    }
                    else if(card_type.equals(""))
                    {
                        JOptionPane.showMessageDialog(null,"Card type is mandatory!");
                    }
                    else if(card_name.equals(""))
                    {
                       JOptionPane.showMessageDialog(null,"Card holder name is mandatory!");

                    }
                    else if(cvv.equals(""))
                    {
                      JOptionPane.showMessageDialog(null," CVV is mandatory!");

                    }
                    else if(expiry.equals(""))
                    {
                     JOptionPane.showMessageDialog(null," Expiry date is mandatory!");
                    }
                }
                else
                {  
                    String regex1="^\\d+$";                                                        //REGEX NOT CORRECT!
                    Pattern p=Pattern.compile(regex1);
                    Matcher m=p.matcher(card_no); 
                    Boolean b=m.matches();
                    int flag1=0;
                    if(b==false)
                            {
                                JOptionPane.showMessageDialog(null,"Enter a valid card number!");
                            }
                    else
                    {
                        flag1=1;
                    }
                    
                    String regex2="^[0-9]{3,4}$";
                    Pattern p1=Pattern.compile(regex2);
                    Matcher m1=p1.matcher(cvv);
                    Boolean b1=m1.matches();
                    int flag2=0;
                    if(b1==false)
                    {
                        JOptionPane.showMessageDialog(null,"Enter a valid CVV");
                    }
                    else
                    {
                        flag2=1;
                    }
                           
                    if(flag1==1 && flag2==1)
                    {
                    int flag_cardno=0,flag_cvv=0;
                    try
                      {
                    Connection con=Database_Connection.getConnection(str);
                    Statement st=con.createStatement();
                    String pass_value="_CardDetails";
                    String query="select * from "+str+pass_value;
                    ResultSet rs=st.executeQuery(query);
                    //System.out.println("success");
                    while(rs.next())
                    {   
                        if(card_no.equals(rs.getString("card_num")))
                        {  flag_cardno=1;
                           break;
                        }
                        if(cvv.equals(rs.getString("cvv")))
                        {
                            flag_cvv=1;
                        }
                        
                    }
                    if(flag_cardno==1)
                    {
                        JOptionPane.showMessageDialog(null,"This account already exists!");
                    }
                    if(flag_cvv==1)
                    {
                        JOptionPane.showMessageDialog(null,"You might have entered the wrong CVV!");
                    }
                    if(flag_cardno==0) 
                    {  if(flag_cvv==0)
                        {
                        String q="Insert into "+str+pass_value+" values('"+card_no+"','"+card_name+"','"+expiry+"','"+cvv+"','"+card_type+"')";
                        int r=st.executeUpdate(q);
                         JOptionPane.showMessageDialog(null,"Sucessfully added!");
                         f.setVisible(false);
                     new new_View_table(str);
                         }
                    }
                 }
                        
                    catch(Exception ec)
                    {
                        System.out.println(ec);
                        
                    }    
                    }  
                }  
            }});   
                 
        
        
        
        
        f.add(l);
        f.add(l_cardno);
        f.add(l_bank);
        f.add(l_acctype);
        f.add(l_cardtype);
        f.add(l_cardname);
        f.add(l_cvv);
        f.add(l_expiry);
        f.add(t_cardno);
        f.add(t_bank);
        f.add(t_cardname);
        f.add(t_cvv);
        f.add(t_expiry);
        f.add(c_acctype);
        f.add(c_cardtype);
        f.add(b_add);
        f.add(b_cancel);
        f.add(p);
        f.add(p1);
        f.add(p2);
        f.add(p3);
        f.add(p4);
        f.add(p5);
        f.add(p6);
        f.setLayout(null);
        f.setVisible(true);
        
    }
    public static void main(String args[])
    {
       
    }    
}
