/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mindtree.preloaded.random;

/**
 * class Person
 * This class retrieves the personal details from the database. 
 * @author smakkar
 */

import java.io.File;
import java.sql.*;
import java.util.*;

public class Person {
     private Connection con=null;
     private ResultSet rs;
     private Statement st;
     private String qry;
     private int rNum;
     private String fName;
     private String lName;
     private String email;
     private String gender;
     
     public Person()
     {
         String p = new File(".").getAbsolutePath().replace("\\", "\\\\").replace(".", "");
         Random rand=new Random();
         rNum=rand.nextInt(1000)+1;
         qry="SELECT first_name,last_name,Email,Gender FROM PERSON WHERE ID= "+String.valueOf(rNum);
         try{
                    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                    //System.out.println(DriverManager.getDrivers());
                    con=DriverManager.getConnection("jdbc:ucanaccess://"+p+"DB\\TESTDATAGEN.accdb");
                    st=con.createStatement();
                    rs=st.executeQuery(qry);
                    while(rs.next())
                    {
                        this.fName=rs.getString("first_name");
                        this.lName=rs.getString("last_name");
                        this.email=rs.getString("Email");
                        this.gender=rs.getString("Gender");
                    }
                    rs.close();
                    con.close();
                    st.close();
         }
         catch(Exception e)
         {
             System.out.println(e.getMessage());
         }
     }
     
     public String getFName()
     {
         return fName;
     }
     
     public String getLName()
     {
         return lName;
     }
     
     public String getEmail()
     {
         return email;
     }
     
     public  String getGender()
     {
         return gender;
     }
}
