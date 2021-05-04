//Main-Login -->Login with UserName and Masterkey
package Orginal_Project;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
public class Main_Login extends JFrame 
{
    JLabel l1_name,l2_enter,l3_key;
    JTextField t1_username;
    JPasswordField p1_pass;
    JButton b1_go,b2_create;
    Main_Login()
    {
        
        setBounds(550,250,700,500);
        getContentPane().setBackground(new Color(43, 41, 42));
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        
        l1_name = new JLabel("MASTERKEY");
        l1_name.setBounds(200, 30,300,40);
        l1_name.setForeground(Color.white);
        l1_name.setFont(new Font("Times new Roman",Font.BOLD,35));
        add(l1_name);
        l1_name.setVisible(true);
        
        l2_enter = new JLabel("Enter your Username");
        l2_enter.setBounds(200, 120,300,25);
        l2_enter.setForeground(Color.white);
        l2_enter.setFont(new Font("Times new Roman",Font.BOLD,25));
        add(l2_enter);
        l2_enter.setVisible(true);
        
        
        t1_username =  new JTextField();
        t1_username.setBounds(180,160,290,40);
        t1_username.setFont(new Font("Times new Roman",Font.BOLD,25));
        t1_username.setForeground(Color.black);
        add(t1_username);
        t1_username.setVisible(true);
        
        l3_key = new JLabel("Enter your Masterkey");
        l3_key.setBounds(200, 260,300,25);
        l3_key.setForeground(Color.white);
        l3_key.setFont(new Font("Times new Roman",Font.BOLD,25));
        add(l3_key);
        l3_key.setVisible(true);
        
        p1_pass =new JPasswordField();
        p1_pass.setBounds(180,300,290,40);
        p1_pass.setFont(new Font("Times new Roman",Font.BOLD,25));
        p1_pass.setForeground(Color.black);
        add(p1_pass);
        p1_pass.setVisible(true);
        
        
        b1_go =new JButton("GO");
        b1_go.setBounds(380,400,250,40);
        b1_go.setForeground(Color.black);
        b1_go.setFont(new Font("Times new Roman",Font.BOLD,25));
        add(b1_go);
        b1_go.setVisible(true);
        
        b2_create =new JButton("Create new Account");
        b2_create.setBounds(30,400,250,40);
        b2_create.setFont(new Font("Times new Roman",Font.BOLD,25));
        b2_create.setForeground(Color.black);
        add(b2_create);
        b2_create.setVisible(true);
        
        // When Username and Masterkey is correct it redirects to View_Table 
        b1_go.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String username = t1_username.getText();
                String mast = p1_pass.getText();
               
                //Database Connection ---->main_database and table-->general
                 try
                    {
                        Connection con=Database_Connection.getConnection("main_database");
                        Statement stmt=con.createStatement();  
                        String query1 = "select * from general";
                        ResultSet s = stmt.executeQuery(query1);
                        int flag = 0;
                        while(s.next())
                        {
                           
                            
                            if(username.equals(s.getString("username")) && mast.equals(s.getString("masterkey")) )
                            {
                                flag = 1;
                              break;
                          
                            }     
                        }
                        if(flag == 0)
                        {
                            JOptionPane jn = new JOptionPane();
                              JOptionPane.showMessageDialog(jn,"Your username or passwrd is incorrect!");
                        }
                        else
                        {
                              JOptionPane jn = new JOptionPane();
                              setVisible(false);
                              new new_View_table(username);
                            
                        }
                            
                    }  
                    catch(Exception exe)
                    {
                       System.out.println(exe);
                    }
                   }
                
               
            
        });
        //Creates new Account For a new user
        
         b2_create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Register_Form();
               
            }
        });
        
        
        setVisible(true);
    }
     public static void main(String args[])
     {
        new Main_Login();
         
     }  
          
}
