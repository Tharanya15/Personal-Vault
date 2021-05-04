/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Orginal_Project;

import Forms.filegui;
import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.sql.*;
import java.awt.event.*;

public class File_Creation 
{
   JLabel l1_title,l2_a;
    JTextField t1_field;
    JButton b1_go;

    void filewriting(File dir, String fileName,String user) {
        try {
            Connection con =Database_Connection.getConnection(user);
            Statement stmt = con.createStatement();
            String database="SELECT * FROM "+user+"_PersonalDetails";
            ResultSet resultset = stmt.executeQuery(database);
            int essentialEmpty = 0;
            
            if(resultset!=null){
                while(resultset.next()) {
                    int res=Integer.parseInt(resultset.getString("essential"));
                    System.out.println(res);
                    if(res==1) {
                        essentialEmpty = 1;
                        break;
                    }
                }
                if(essentialEmpty!=0)
                {
                    FileWriter fw = new FileWriter(dir+"\\"+fileName+".txt");
                    System.out.println("Done Creation \n");
                    fw.write("          Printed Copy            \n");
                    fw.write("--------------------------------\n");
                    System.out.println("Done Writing");
                   
                    resultset = stmt.executeQuery(database);
                    while(resultset.next()) {
                         int res=Integer.parseInt(resultset.getString("essential"));
                        if(res==1) {
                            System.out.print(resultset.getString("content")+":"+resultset.getString("value")+"\n");
                            fw.write(resultset.getString("content")+":"+resultset.getString("value")+"\n");
                        }
                    }
                    fw.close();
                    JOptionPane.showMessageDialog(new JFrame(),"File Created Successfully"); 
                
            } else {
                JOptionPane.showMessageDialog(new JFrame(),"Your Personal Info Section is has only encoded messages. Create some fields without them.");
            }
            }
            else {
                JOptionPane.showMessageDialog(new JFrame(),"Your Personal Info Section is Empty. Create some fields.");
            } 
        } catch (Exception exe) {
            exe.printStackTrace();  
        }
        
    }

    void newFrame(String str)
    {   
        JFileChooser f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
        f.showSaveDialog(null);
        
        JFrame fileFrame = new JFrame();
        fileFrame.setBounds(700,350,400,200);
        fileFrame.getContentPane().setBackground(new Color(43, 41, 42));
        fileFrame.setLayout(null);
        fileFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        JLabel note = new JLabel("This option generates a file with you personal info.");
        JLabel note2 = new JLabel("Note that the ENCODED files won't be visible in the file.");
        
        l2_a = new JLabel("Enter the file name");
        l2_a.setBounds(100,20,200,24);
        l2_a.setForeground(Color.white);
        l2_a.setFont(new Font("Calibri",Font.BOLD,24));
        fileFrame.add(l2_a);
        l2_a.setVisible(true);
        
        t1_field = new JTextField("");
        t1_field.setBounds(100,45,190,30);
        t1_field.setForeground(Color.black);
        t1_field.setFont(new Font("Calibri",Font.BOLD,20));
        fileFrame.add(t1_field);
        t1_field.setVisible(true);
        
        b1_go =new JButton("Generate");
        b1_go.setBounds(150,90,95,20);
        b1_go.setFont(new Font("Calibri",Font.BOLD,12));
        b1_go.setForeground(Color.black);
        fileFrame.add(b1_go);
        b1_go.setVisible(true);

        note.setBounds(75,120,250,20);
        note.setFont(new Font("Calibri",Font.BOLD,12));
        note.setForeground(Color.WHITE);
        fileFrame.add(note);
        fileFrame.add(note2);
        note2.setBounds(60,135,300,20);
        note2.setFont(new Font("Calibri",Font.BOLD,12));
        note2.setForeground(Color.WHITE);
        fileFrame.setVisible(true);
        b1_go.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                System.out.println(f.getSelectedFile()+"\\"+t1_field.getText());
                new File_Creation().filewriting(f.getSelectedFile(),t1_field.getText(),str);
                fileFrame.dispose();
            }
        });
    }
    public static void main(String args[])
     {
        new File_Creation().newFrame("Mugundhan");
     }   
}
