/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Orginal_Project;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Mugundhan.S
 */
public class Database_Connection
{
  private static String str="com.mysql.cj.jdbc.Driver";
    
    private static Connection con;
    public static Connection getConnection(String str1)
    {
        try
        {
          Class.forName(str);
          String database="jdbc:mysql://localhost:3308/"+str1;
        con=DriverManager.getConnection(database, "root", "");
        System.out.println("Connection Established");
        }
        catch(Exception ae)
        {
           System.out.println("Connection Failed"); 
        }
        return con;
    }
    public static void main(String[] args) {
    
       
    }    
}
