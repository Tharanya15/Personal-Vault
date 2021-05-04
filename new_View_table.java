
package Orginal_Project;

import Forms.Instruction1;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class new_View_table extends JFrame
{
     
    JPanel  p1_stable,p2_changable,P3_used,p2_changable1,p2_changable2,p1_stable2;
    JLabel l1_title1,l2_Nodetects,l1_main;
    JButton b1_password_mananger,b2_personal_details,b3_bank_details,b4_instruction;
    JButton b1_addentry,b2_deletentry,b3_modifyentry,b4_copypassword,b5_generatePassword;
    JButton button[];
    JLabel label1[],label2[],label3[];
    JLabel l1_title,l2_S_No,l3_Accountno,l4_Bank_name,l1_Main_Title;
    JButton b1_add,b2_delete,b3_list_of_all_cards,b4_add_an_debit;
    int x,y,z;
    public new_View_table(String str)
    {
       x=0;
       y=0;
       z=0;
       setBounds(270,50,1300,947);
       setVisible(true);
       p1_stable2=new JPanel();
       
       l1_main=new JLabel(new ImageIcon("C:\\Users\\Mugundhan.S\\Desktop\\Project_Pic\\background20.png"));
       l1_main.setBounds(300,100,550,50);
       l1_main.setFont(new Font("Times new Roman",Font.BOLD,45));
       l1_main.setForeground(Color.red);
       p1_stable2.add(l1_main);
       p1_stable2.setBounds(250,0,1050,900);
       p1_stable2.setBackground(Color.DARK_GRAY);
       
       p1_stable=new JPanel();
       p1_stable.setBounds(0,0,250,900);
       p1_stable.setBackground(Color.black);
       
       l1_Main_Title=new JLabel(new ImageIcon("C:\\Users\\Mugundhan.S\\Desktop\\Project_Pic\\background19.png"));
       l1_Main_Title.setBounds(0,80,200,50);
       l1_Main_Title.setForeground(Color.red);
       l1_Main_Title.setFont(new Font("Times new Roman",Font.BOLD,30));
       
       b1_password_mananger=new JButton("Password Manager");
       b2_personal_details=new JButton("Personal-Details");
       b3_bank_details=new JButton("Bank-Details");
       b4_instruction=new JButton("Instructions");
       
       b1_password_mananger.setBounds(30,250,170,50);
       b2_personal_details.setBounds(30,350,170,50);
       b3_bank_details.setBounds(30,450,170,50);
       b4_instruction.setBounds(30,550,170,50);
       
       b1_password_mananger.setFont(new Font("Calibri",Font.BOLD,15));
       b2_personal_details.setFont(new Font("Calibri",Font.BOLD,15));
       b3_bank_details.setFont(new Font("Calibri",Font.BOLD,15));
       b4_instruction.setFont(new Font("Calibri",Font.BOLD,15));
       
       p1_stable.setLayout(null);
       p1_stable.add(b1_password_mananger);
       p1_stable.add(b2_personal_details);
       p1_stable.add(b3_bank_details);
       p1_stable.add(b4_instruction);
       p1_stable.add(l1_Main_Title);
       
       label1=new JLabel[20];
       label2=new JLabel[20];
       label3=new JLabel[10];
               
                button=new JButton[10];
       //Instruction Correspoding to Our Valut         
       b4_instruction.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
            
            new Instruction1();
           }
       });
       
       b1_password_mananger.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
            
               p1_stable2.setVisible(false);
               if(z!=0)
               {
                   p2_changable1.setVisible(false);
               }
               if(y!=0)
               {
                   p2_changable2.setVisible(false);
               }
               x++;
                p2_changable=new JPanel();
                P3_used=new JPanel();
                p2_changable.setBounds(250,35,1050,900);
             
                b1_addentry=new JButton("Add Entry");
                b2_deletentry=new JButton("Delete Entry");
                b3_modifyentry=new JButton("Modify Entry");
                b4_copypassword=new JButton("Copy Password");
                b5_generatePassword=new JButton("Password");
                
                b1_addentry.setBounds(260,50,150,30);
                b2_deletentry.setBounds(460,50,150,30);
                b3_modifyentry.setBounds(660,50,150,30);
                b4_copypassword.setBounds(860,50,150,30);
                b5_generatePassword.setBounds(1060,50,150,30);
                
                b1_addentry.setFont(new Font("Calibri",Font.BOLD,15));
                b2_deletentry.setFont(new Font("Calibri",Font.BOLD,15));
                b3_modifyentry.setFont(new Font("Calibri",Font.BOLD,15));
                b4_copypassword.setFont(new Font("Calibri",Font.BOLD,15));
                b5_generatePassword.setFont(new Font("Calibri",Font.BOLD,15));
                
                b1_addentry.setVisible(true);
                b2_deletentry.setVisible(true);
                b3_modifyentry.setVisible(true);
                b4_copypassword.setVisible(true);
                b5_generatePassword.setVisible(true);
                
                p2_changable.add(b1_addentry);
                
                //In Password Manager Adding an Entry
                b1_addentry.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                        new Add_an_Entry_Original(str);
                    }
                });
                //In Password Manager Delete an Entry
                 b2_deletentry.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                        new Delete_an_Entry(str);
                    }
                });
                 //In Password Manager Modify an Entry
                  b3_modifyentry.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                        new Modify_an_entry(str);
                    }
                });
                  //In Password Manager Copy Password
                  b4_copypassword.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                      setVisible(false);
                      new Copy_password_Original(str);
                    }
                });
                  b5_generatePassword.addActionListener(new ActionListener() {

                   @Override
                   public void actionPerformed(ActionEvent e) {
                       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                   new Password_Generating(str);
                   }
               });
                String columnNames[]={"Email","Password","Notes","Website","Used_in"};
                DefaultTableModel model=new DefaultTableModel();
                model.setColumnIdentifiers(columnNames);
                JTable table=new JTable();
                table.setModel(model);
                table.setFillsViewportHeight(true);
                table.setEnabled(false);
                table.setRowHeight(30);
                table.setRowHeight(3, 60);
                table.setFont(new Font("Comic Sans MS",Font.BOLD,15));

                JScrollPane pane=new JScrollPane(table);

                pane.setBounds(0,50,1050,900);
                p2_changable.add(pane);
                pane.setViewportView(table);

                pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
                String email= "";
                String password= "";
                String notes = "";
                String website= "";
                String usedin="";
                //Connecting Database User Password Manager table
               try
                {
                      Connection con=Database_Connection.getConnection(str);
                      String pass_man="_PasswordManager";
                      String str1="select * from "+str+pass_man;
                      PreparedStatement st=con.prepareStatement(str1);
                     
                      ResultSet rs=st.executeQuery();
                       while(rs.next())
                       {
                            email = rs.getString("email");
                            password = rs.getString("password");
                            notes = rs.getString("notes");
                            website = rs.getString("website"); 
                            usedin=rs.getString("used_in");
                            password="**********";
                            notes=new encryption().decrypt(notes);
                            website=new encryption().decrypt(website);
                            usedin=new encryption().decrypt(usedin);
                            model.addRow(new Object[]{email, password, notes, website,usedin});
                       }
                      con.close();
                  }
                  catch(Exception ae)
                  {
                      System.out.println(ae.getMessage());
                  }
       
                add(b1_addentry);
                add(b2_deletentry);
                add(b3_modifyentry);
                add(b4_copypassword);
                add(b5_generatePassword);
                
                add(p2_changable);
                getContentPane();
                p2_changable.setBackground(Color.cyan);
                p2_changable.setLayout(null);
                p2_changable.setVisible(true);
               
                    
                }
                });
       
                 // Personal Details Button
                b2_personal_details.addActionListener(new ActionListener() {

           @Override
              public void actionPerformed(ActionEvent e) {
                  p1_stable2.setVisible(false);
                  if(x!=0)
                  {
                        p2_changable.setVisible(false);
                        b1_addentry.setVisible(false);
                        b2_deletentry.setVisible(false);
                        b3_modifyentry.setVisible(false);
                        b4_copypassword.setVisible(false);
                        b5_generatePassword.setVisible(false);
                  }
                  if(z!=0)
                  {
                        p2_changable1.setVisible(false);
                  }
                  y++;
                  
                  JButton button1=new JButton("Add Details");
                  JButton button2=new JButton("Add");
                  JButton button3=new JButton("Delete");
                  JButton button4=new JButton("Print");
                  
                  p2_changable2=new JPanel();
                  p2_changable2.setBounds(250,0,1050,900);
                  
                  l1_title1=new JLabel("Personal Details");
                  l2_Nodetects=new JLabel("NoDetects");
                  
                  l1_title1.setBounds(300,50,550,50);
                  l2_Nodetects.setBounds(400,400,150,50);
                  
                  l1_title1.setFont(new Font("Calibri",Font.BOLD,45));
                  l2_Nodetects.setFont(new Font("Calibri",Font.BOLD,25));
                  
                  button1.setBounds(350,700,250,50);
                  button1.setFont(new Font("Calibri",Font.BOLD,20));
                  
                  button2.setBounds(200,150,150,30);
                  button2.setFont(new Font("Calibri",Font.BOLD,20));
                  
                  button3.setBounds(550,150,150,30);
                   button3.setFont(new Font("Times new Roman",Font.BOLD,20));
                  
                   button4.setBounds(750,150,150,30);
                  button4.setFont(new Font("Times new Roman",Font.BOLD,20));
                  //personal details tbale of user
                  try
                  {
                  
                      Connection connection=Database_Connection.getConnection(str);
                      Statement stmt=connection.createStatement();
                      String res_value="_PersonalDetails";
                      String query="select * from "+str+res_value;
                      ResultSet rs=stmt.executeQuery(query);
                      String sample="";
                      while(rs.next())
                      {
                          sample=rs.getString("value");
                      }
                      if(sample.equals(""))
                      {
                          
                           p2_changable2.add(l2_Nodetects);
                           p2_changable2.add(button1);
                           button1.addActionListener(new ActionListener() {

                               @Override
                               public void actionPerformed(ActionEvent e) {
                                   setVisible(false);
                                new Personal_details_RegisterForm(str);
                               }
                           });
                      }
                      else
                      {
                          p2_changable2.add(button2);
                          p2_changable2.add(button3);
                          p2_changable2.add(button4);
                          
                          JLabel label_1[]=new JLabel[40];
                          JLabel label_2[]=new JLabel[40];
                          
                          String pass_value="_PersonalDetails";
                          String query1="select * from "+str+pass_value;
                          ResultSet rs1=stmt.executeQuery(query1);
                          int i=0;
                          while(rs1.next())
                          {
                           
                              String content=rs1.getString("content");
                              String value=rs1.getString("value");
                              label_1[i]=new JLabel();
                              label_2[i]=new JLabel();
                              label_1[i].setBounds(20,200+(i*40),150,50);
                              label_2[i].setBounds(190,200+(i*40),250,50);
                              label_1[i].setFont(new Font("Calibri",Font.BOLD,20));
                              label_2[i].setFont(new Font("Calibri",Font.BOLD,20));
                              label_1[i].setText(content);
                              label_2[i].setText(value);

                               p2_changable2.add(label_1[i]);
                               p2_changable2.add(label_2[i]);

                                i++;
                          }
                          //Add an Entry into Personal
                          button2.addActionListener(new ActionListener() {

                              @Override
                              public void actionPerformed(ActionEvent e) {
                                  setVisible(false);
                              new Add_an_Entry_Personal(str);
                              }
                          });
                          //Delete an Entry into Personal
                          button3.addActionListener(new ActionListener() {

                              @Override
                              public void actionPerformed(ActionEvent e) {
                              
                                  setVisible(false);
                              new Delete_an_Entry_Personal(str);
                              }
                          });
                          button4.addActionListener(new ActionListener() {

                              @Override
                              public void actionPerformed(ActionEvent e) {
                           //       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                             new File_Creation().newFrame(str);
                              }
                          });
                      }
                  }
                  catch(Exception ae)
                  {
                       System.out.print(ae.getMessage());                     
                   }
                  

                  
                   p2_changable2.add(l1_title1);
                  p2_changable2.setLayout(null);
                  p2_changable2.setBackground(Color.cyan);
                  getContentPane();
                  setVisible(true); 
                  p2_changable2.setVisible(true);   
                  add(p2_changable2);

                  
              }
                });
                
                
                
                //Bank Details Adding
           b3_bank_details.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
                p1_stable2.setVisible(false);
               if(x!=0)
               {
               p2_changable.setVisible(false);
               b1_addentry.setVisible(false);
               b2_deletentry.setVisible(false);
               b3_modifyentry.setVisible(false);
               b4_copypassword.setVisible(false);
               b5_generatePassword.setVisible(false);
               }
               if(y!=0)
               {
                   p2_changable2.setVisible(false);
               }
               z++;
               
               p2_changable1=new JPanel();
               p2_changable1.setBounds(250,0,1050,900);
              
               
               
               l1_title=new JLabel("Bank Details");
               l2_S_No=new JLabel("S.No");
               l3_Accountno=new JLabel("Account Number");
               l4_Bank_name=new JLabel("Bank Name");
               
               l1_title.setBounds(300,50,550,50);
               l2_S_No.setBounds(20,250,100,50);
               l3_Accountno.setBounds(140,250,250,50);
               l4_Bank_name.setBounds(450,250,250,50);
               
               l1_title.setFont(new Font("Calibri",Font.BOLD,45));
               l2_S_No.setFont(new Font("Calibri",Font.BOLD,25));
               l3_Accountno.setFont(new Font("Calibri",Font.BOLD,25));
               l4_Bank_name.setFont(new Font("Calibri",Font.BOLD,25));
               
               b1_add=new JButton("Add");
               b2_delete=new JButton("Delete");
               b3_list_of_all_cards=new JButton("List all Atm Cards");
               b4_add_an_debit=new JButton("Add an Debit/Credit Card");
               
               b1_add.setBounds(50,180,100,30);
               b2_delete.setBounds(200,180,100,30);
               b3_list_of_all_cards.setBounds(350,180,200,30);
               b4_add_an_debit.setBounds(350,180,400,30);
               
               b1_add.setFont(new Font("Calibri",Font.BOLD,20));
               b2_delete.setFont(new Font("Calibri",Font.BOLD,20));
               b3_list_of_all_cards.setFont(new Font("Calibri",Font.BOLD,20));
               b4_add_an_debit.setFont(new Font("Calibri",Font.BOLD,20));
               
               
               
               
               p2_changable1.add(l1_title);
               p2_changable1.setVisible(true);
               p2_changable1.add(l2_S_No);
               p2_changable1.add(l3_Accountno);
               p2_changable1.add(l4_Bank_name);
               p2_changable1.add(b1_add);
               p2_changable1.add(b2_delete);
               p2_changable1.add(b4_add_an_debit);
               
               b1_add.addActionListener(new ActionListener() {

                   @Override
                   public void actionPerformed(ActionEvent e) {
                       setVisible(false);
                       new Add_an_Entry_Bank(str);
                   }
               });
               b2_delete.addActionListener(new ActionListener() {

                   @Override
                   public void actionPerformed(ActionEvent e) {
                         setVisible(false);
                       new Bank_Delete(str);
                   }
               });
               b4_add_an_debit.addActionListener(new ActionListener() {

                   @Override
                   public void actionPerformed(ActionEvent e) {
                         setVisible(false);
                       new Add_an_Entry_Card(str);
                   }
               });
               int i=0;
               //Connection Account Details
               try
               {
                   Connection connection=Database_Connection.getConnection(str);
                   Statement stmt=connection.createStatement();
                   String pass_value="_AccountDetails";
                   String query="select * from "+str+pass_value;
                   ResultSet rs=stmt.executeQuery(query);
                   
                   while(rs.next())
                   {
                       String acc_num=rs.getString("acc_number");
                       String bank_name=rs.getString("bank_name");
                        
                       label1[i]=new JLabel();
                       label2[i]=new JLabel();
                       label3[i]=new JLabel();
                         
                       button[i]=new JButton("View");
                         
                       label1[i].setBounds(20,300+(i*70),50,50);
                       label2[i].setBounds(140,300+(i*70),250,50);
                       label3[i].setBounds(440,300+(i*70),250,50);
                       
                       label1[i].setFont(new Font("Calibri",Font.BOLD,20));
                       label2[i].setFont(new Font("Calibri",Font.BOLD,20));
                       label3[i].setFont(new Font("Calibri",Font.BOLD,20));
                       
                       button[i].setBounds(720,300+(i*70),100,30);
                       button[i].setFont(new Font("Calibri",Font.BOLD,20));
                       
                       String st=Integer.toString((i+1));
                       
                       label1[i].setText(st);
                       label2[i].setText(acc_num);
                       label3[i].setText(bank_name);
                       
                       p2_changable1.add(label1[i]);
                       p2_changable1.add(label2[i]);
                       p2_changable1.add(label3[i]);
                       p2_changable1.add(button[i]);
                       i++;
                    System.out.println(acc_num);
                    System.out.println(bank_name);
                   }
                   
               }
               catch(Exception ae)
               {
                   ae.getMessage();
                  System.out.println(ae); 
               }
               
               for(int j=0;j<i;j++)
               {
                   String str1=label2[j].getText();
                   button[j].addActionListener(new ActionListener() {

                       @Override
                        public void actionPerformed(ActionEvent e) {
                            setVisible(false);
                           new View_Of_Account_Details(str, str1);
                       }
                   });
               }
               
               p2_changable1.setLayout(null);
               getContentPane();
               p2_changable1.setBackground(new Color(145,194,186));
              
               p2_changable1.setVisible(true);
               add(p2_changable1);
               setVisible(true);
             }
            });
                
                add(p1_stable);
                add(p1_stable2);
                setLayout(null);
                setVisible(true);
        
    }
    
    public static void main(String[] args)
    {
      
    }
}






           
