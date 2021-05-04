

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Add_an_Entry_Bank 
{
 JLabel l,l_accno,l_holder,l_bank,l_branch,l_ifsc;
    JTextField t_accno,t_holder,t_bank,t_branch,t_ifsc;
    JButton b_add,b_cancel;
    public Add_an_Entry_Bank(String str)
    {
        JFrame f=new JFrame();
        f.setTitle("Bank Details");
        f.setBounds(590,150,700,800);
        f.getContentPane().setBackground(new Color(42, 43, 41));
        
        l=new JLabel("Bank Details");
        l_accno=new JLabel("Account Number");
        l_holder=new JLabel("Account Holder Name");
        l_bank=new JLabel("Bank Name");
        l_branch=new JLabel("Bank Branch");
        l_ifsc=new JLabel("IFSC code");
        
        l.setBounds(240,30,250,30);
        l_accno.setBounds(100,100,200,30);
        l_holder.setBounds(100,200,250,30);
        l_bank.setBounds(100,300,150,30);
        l_branch.setBounds(100,400,150,30);
        l_ifsc.setBounds(100,500,250,30);
        
        
        l.setForeground(new Color(250, 74, 20));
        l_accno.setForeground(new Color(250, 74, 20));
        l_holder.setForeground(new Color(250, 74, 20));
        l_bank.setForeground(new Color(250, 74, 20));
        l_branch.setForeground(new Color(250, 74, 20));
        l_ifsc.setForeground(new Color(250, 74, 20));        
        l.setFont(new Font("Dialog",Font.BOLD,40));
        l_accno.setFont(new Font("serif",Font.BOLD,25));
        l_holder.setFont(new Font("serif",Font.BOLD,25));
        l_bank.setFont(new Font("serif",Font.BOLD,25));
        l_branch.setFont(new Font("serif",Font.BOLD,25));
        l_ifsc.setFont(new Font("serif",Font.BOLD,25));
        
         JPanel p=new JPanel();
        p.setBounds(350,95,260,42);
        p.setBackground(new Color(240, 105, 14));
        
        JPanel p1=new JPanel();
        p1.setBounds(350,195,260,42);
        p1.setBackground(new Color(240, 105, 14));
        
        JPanel p2=new JPanel();
        p2.setBounds(350,295,260,42);
        p2.setBackground(new Color(240, 105, 14));
        
        JPanel p3=new JPanel();
        p3.setBounds(350,395,260,42);
        p3.setBackground(new Color(240, 105, 14));
        
        JPanel p4=new JPanel();
        p4.setBounds(350,495,260,42);
        p4.setBackground(new Color(240, 105, 14));
        
        
        t_accno=new JTextField();
        t_holder=new JTextField();
        t_bank=new JTextField();
        t_branch=new JTextField();
        t_ifsc=new JTextField();
        
        t_accno.setBounds(355,100,250,30);
        t_holder.setBounds(355,200,250,30); 
        t_bank.setBounds(355,300,250,30);
        t_branch.setBounds(355,400,250,30);
        t_ifsc.setBounds(355,500,250,30); 
        
        b_add=new JButton("Add");
        b_cancel=new JButton("Cancel");
        
        b_add.setBounds(200,600,150,50);
        b_cancel.setBounds(380,600,150,50);
        
        b_add.setBackground(new Color(250, 74, 20));
        b_cancel.setBackground(new Color(250, 74, 20));
        
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
            public void actionPerformed(ActionEvent t)
            {
                String acc_no=t_accno.getText();
                String holder=t_holder.getText();
                String bank=t_bank.getText();
                String branch=t_branch.getText();
                String ifsc=t_ifsc.getText();
                
                if(acc_no.equals("")|| holder.equals("")|| bank.equals("")|| branch.equals("")||ifsc.equals(""))
                {
                    if(acc_no.equals(""))
                    {
                        
                      JOptionPane.showMessageDialog(null,"Account number is mandatory!");
                    }
                    else if(holder.equals(""))
                    {
                        JOptionPane.showMessageDialog(null,"Name is mandatory!");
                    }
                    else if(bank.equals(""))
                    {
                         JOptionPane.showMessageDialog(null,"Bank name is mandatory!");
                    }
                    else if(branch.equals(""))
                    {
                        JOptionPane.showMessageDialog(null,"Branch name is mandatory!");
                    }
                    else if(ifsc.equals(""))
                    {
                       JOptionPane.showMessageDialog(null,"IFSC code is mandatory!");

                    }
                }
                    else
                    {
                    String regex1="^\\d{9,18}$";                                                        //REGEX NOTE: CORRECT!
                    Pattern p=Pattern.compile(regex1);
                    Matcher m=p.matcher(acc_no); 
                    Boolean b=m.matches();
                    int flag1=0;
                    if(b==false)
                            {
                                JOptionPane.showMessageDialog(null,"Enter a valid account number!");
                                
                            }
                    else
                    {
                        flag1=1;
                    }
                    String regex2="^[A-Z]{4}0[A-Z0-9]{6}$"; 
                    Pattern p1=Pattern.compile(regex2);
                    Matcher m1=p1.matcher(ifsc);
                    Boolean b1=m1.matches();
                    int flag2=0;
                    if(b1==false)
                    {
                        JOptionPane.showMessageDialog(null,"Enter a valid IFSC code!");
                        
                    }
                    else
                    {
                        flag2=1;
                        System.out.println("valid ifsc");
                    }
                    
                    if(flag1==1 && flag2==1)
                    {
                    int flag_accno=0,flag_ifsc=0;
                    try
                      {
                    Connection con=Database_Connection.getConnection(str);
                    Statement st=con.createStatement();
                    String pass_value="_AccountDetails";
                    String query="select * from "+str+pass_value;
                    ResultSet rs=st.executeQuery(query);
                    //System.out.println("success");
                    while(rs.next())
                    {   
                        if(acc_no.equals(rs.getString("acc_number")))
                        {  flag_accno=1;
                           break;
                        }
                        if(ifsc.equals(rs.getString("ifsc")))
                        {
                            flag_ifsc=1;
                            break;
                        }
                    }
                    
                     if(flag_accno==1)
                     {
                         JOptionPane.showMessageDialog(null,"You might have entered the wrong Account Number!");
                     }
                      if(flag_ifsc==1)
                     {
                         JOptionPane.showMessageDialog(null,"You might have entered the wrong IFSC!");
                     }
                     if(flag_accno==0)
                     {
                         if(flag_ifsc==0)
                         {
                           
                         String q="Insert into "+str+pass_value+" values('"+acc_no+"','"+holder+"','"+bank+"','"+branch+"','"+ifsc+"')";
                         int r=st.executeUpdate(q);
                         System.out.println(r);
                         JOptionPane.showMessageDialog(null,"Sucessfully added!");
                         f.setVisible(false);
                         new new_View_table(str);
                         }
                     }
                      }
                    catch(Exception ee)
                    {
                        System.out.println(ee);
                    }
                        
                        
                    
                    
                }

                
            }
            }});
        
        
        
        
        
        
        
        
        f.add(l);
        f.add(l_accno);
        f.add(l_bank);
        f.add(l_holder);
        f.add(l_branch);
        f.add(l_ifsc);
        f.add(t_accno);
        f.add(t_holder);
        f.add(t_bank);
        f.add(t_branch);
        f.add(t_ifsc);
        f.add(b_add);
        f.add(b_cancel);
        f.add(p);
        f.add(p1);
        f.add(p2);
        f.add(p3);
        f.add(p4);
        f.setLayout(null);
        f.setVisible(true);
    }
    public static void main(String args[])
    {
       
    }    
}
