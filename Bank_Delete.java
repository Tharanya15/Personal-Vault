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
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Bank_Delete extends JFrame
{

    JLabel l1_Option;
    JButton b1_card,b2_Bank,b3_back;
    public Bank_Delete(String str) 
    {
        l1_Option=new JLabel("Options");
        l1_Option.setBounds(200,50,200,50);
        l1_Option.setFont(new Font("Times new Roman",Font.BOLD,45));
        b1_card=new JButton("Deleting card");
        b2_Bank=new JButton("Deleting Account");
        
        b1_card.setBounds(140,200,250,50);
        b2_Bank.setBounds(140,300,250,50);
        
        b1_card.setFont(new Font("Times new Roman",Font.BOLD,20));
        b2_Bank.setFont(new Font("Times new Roman",Font.BOLD,20));
        
        //getContentPane().setBackground(Color.cyan);
        setBounds(490,300,600,500);
        add(l1_Option);
        add(b1_card);
        add(b2_Bank);
        b1_card.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                setVisible(false);
                new Delete_an_Entry_Card(str);
            }
        });
        b2_Bank.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                setVisible(false);
             new Delete_an_Entry_Account(str);
            }
        });
        setLayout(null);
        setVisible(true);
     
    }
    
    public static void main(String[] args) 
    {
       
    }
}
