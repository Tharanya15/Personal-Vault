/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Orginal_Project;

import Forms.NewClass1;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
/**
 *
 * @author Mugundhan.S
 */
public class View_Of_Account_Details extends JFrame
{
      JLabel l1_head,l2_accountno,l3_holdername,l4_bankname,l5_branch,l6_email,l7_ifsc,l9_acc,l10_hold,l11_bank,l12_bbranch,l13_memail,l14_ifsccode;
    JTable j1_table;
    JButton b1_modify,b2_close;
   
    public View_Of_Account_Details(String str,String account)
    {
       setBounds(380,80,1050,900);
      getContentPane().setBackground(new Color(43, 41, 42));
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setLayout(null);
        setVisible(true);
       
       l1_head = new JLabel("Account Details");
       l1_head.setBounds(350, 30,350,50);
       l1_head.setForeground(Color.white);
       l1_head.setFont(new Font("Times new Roman",Font.BOLD,50));
       add(l1_head);
       l1_head.setVisible(true);
       
       
       l2_accountno = new JLabel("Account Number");
       l2_accountno.setBounds(100,150,300,30);
       l2_accountno.setForeground(Color.white);
       l2_accountno.setFont(new Font("Times new Roman",Font.BOLD,30));
       add(l2_accountno);
       l2_accountno.setVisible(true);
       
       
       l3_holdername = new JLabel("Holder Name");
       l3_holdername.setBounds(100,220,300,30);
       l3_holdername.setForeground(Color.white);
       l3_holdername.setFont(new Font("Times new Roman",Font.BOLD,30));
       add(l3_holdername);
       l3_holdername.setVisible(true);
       
       
       l4_bankname = new JLabel("Bank Name");
       l4_bankname.setBounds(100,290,300,30);
       l4_bankname.setForeground(Color.white);
       l4_bankname.setFont(new Font("Times new Roman",Font.BOLD,30));
       add(l4_bankname);
       l4_bankname.setVisible(true);
       
       
       l5_branch = new JLabel("Branch Name");
       l5_branch.setBounds(100,360,300,30);
       l5_branch.setForeground(Color.white);
       l5_branch.setFont(new Font("Times new Roman",Font.BOLD,30));
       add(l5_branch);
       l5_branch.setVisible(true);
       
       
      
       
       
       l7_ifsc = new JLabel("IFSC Code");
       l7_ifsc.setBounds(100,460,350,30);
       l7_ifsc.setForeground(Color.white);
       l7_ifsc.setFont(new Font("Times new Roman",Font.BOLD,30));
       add(l7_ifsc);
       l7_ifsc.setVisible(true);
       
//        b1_modify =new JButton("MODIFY");
//        b1_modify.setBounds(150,800,200,50);
//        b1_modify.setForeground(Color.black);
//        b1_modify.setFont(new Font("Times new Roman",Font.BOLD,10));
//        add(b1_modify);
//        b1_modify.setVisible(true);
//        
        b2_close =new JButton("CLOSE");
        b2_close.setBounds(700,800,200,50);
        b2_close.setForeground(Color.black);
        b2_close.setFont(new Font("Times new Roman",Font.BOLD,10));
        add(b2_close);
        b2_close.setVisible(true);
        b2_close.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
            //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
               setVisible(false);
               new new_View_table(str);
           }
       });
        l9_acc = new JLabel();
                           l9_acc.setBounds(500,150,300,30);
                           l9_acc.setForeground(Color.white);
                           l9_acc.setFont(new Font("Times new Roman",Font.BOLD,30));
                           add(l9_acc);
                           l9_acc.setVisible(true);
                           
                           
                           l10_hold = new JLabel();
                           l10_hold.setBounds(500,220,300,30);
                           l10_hold.setForeground(Color.white);
                           l10_hold.setFont(new Font("Times new Roman",Font.BOLD,30));
                           add(l10_hold);
                           l10_hold.setVisible(true);
                           
                           l11_bank = new JLabel();
                           l11_bank.setBounds(500,290,300,30);
                           l11_bank.setForeground(Color.white);
                           l11_bank.setFont(new Font("Times new Roman",Font.BOLD,30));
                           add(l11_bank);
                           l11_bank.setVisible(true);
                           
                           l12_bbranch = new JLabel();
                           l12_bbranch.setBounds(500,360,300,30);
                           l12_bbranch.setForeground(Color.white);
                           l12_bbranch.setFont(new Font("Times new Roman",Font.BOLD,30));
                           add(l12_bbranch);
                           l12_bbranch.setVisible(true);
                           
                           
                           
                           
                           l14_ifsccode =new JLabel();
                           l14_ifsccode.setBounds(500,460,300,30);
                           l14_ifsccode.setForeground(Color.white);
                           l14_ifsccode.setFont(new Font("Times new Roman",Font.BOLD,30));
                           add(l14_ifsccode);
                           l14_ifsccode.setVisible(true);
                           
      
        String col[] = {"Card number","Holder name","Expiry date","CVV","card type"};

                 DefaultTableModel m=new DefaultTableModel();
                 m.setColumnIdentifiers(col);
                 JTable table=new JTable();
                 table.setModel(m);
                 table.setFillsViewportHeight(true);
                 table.setEnabled(false);
                 table.setRowHeight(30);
                 table.setRowHeight(3, 60);
                 table.setFont(new Font("Times new Roman",Font.BOLD,15));

                JScrollPane pane=new JScrollPane(table);
//
                pane.setBounds(100,550,900,200);
                add(pane);
                
//               
//        
                pane.setViewportView(table);

                pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
                
                String card_num = "";
                String hold_name = "";
                String exp_date = "";
                String cvv = "";
                String card_type = "";

                 String accnt_no = "";
                 String holder_name = "";
                 String bank_name = "";
                 String bank_branch = "";
                 
                 String ifsc_code = "";
                  try
                {
                      Connection con=Database_Connection.getConnection(str);
                        //Statement stmt=con.createStatement();  
                     
                        String pass_value="_AccountDetails";
                        String query1 = "select * from "+str+pass_value+" where acc_number="+account;
                        PreparedStatement st = con.prepareStatement(query1);
                        ResultSet rs=st.executeQuery(query1);
                       while(rs.next())
                       {
                           
                           accnt_no = rs.getString("acc_number");
                           holder_name = rs.getString("acc_holder");
                           bank_name = rs.getString("bank_name");
                           bank_branch = rs.getString("branch_name");
                           ifsc_code = rs.getString("ifsc");
                           
                           System.out.println(accnt_no);
                           System.out.println(holder_name);
                           System.out.println(bank_name);
                           System.out.println(bank_branch);
                           System.out.println(ifsc_code);
                          
                           l9_acc.setText(accnt_no);
                           l10_hold.setText(holder_name);
                           l11_bank.setText(bank_name);
                           l12_bbranch.setText(bank_branch);
                           l14_ifsccode.setText(ifsc_code);
                           
                           
                           

                          
                       }
                       rs.close();
                       Statement stmt1=con.createStatement();
                       String pass_value3="_CardDetails";
                        String query2 = "select * from "+str+pass_value3;
                        ResultSet rs1=stmt1.executeQuery(query2);
                        while(rs1.next())
                        {
                             card_num = rs1.getString("card_num");
                            hold_name = rs1.getString("holder");
                            exp_date = rs1.getString("expiry");
                            cvv = rs1.getString("cvv");
                            card_type = rs1.getString("card_type");
                           
                            
                            m.addRow(new Object[]{card_num,hold_name,exp_date,cvv,card_type});
                        }
                        
                        
                     con.close();
                  }
                  catch(Exception ae)
                  {
                      System.out.println(ae);
                  }
               
      setVisible(true); 
       
        
    }
    
    public static void main(String[] args)
    {
       
    }
}
