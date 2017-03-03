/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mindtree.preloaded.random;

import java.io.File;
import java.sql.*;
import java.util.*;
/**
 *
 * @author smakkar
 */
public class Address {
    private Connection con=null;
    private ResultSet rs;
    private Statement st;
    private String qry;
    private int rNum;
    private String streetNo;
    private String street;
    private String city;
    private String state;
    private String country;
    private String phone;
    private String zip;
    
    public Address()
    {
        String p = new File(".").getAbsolutePath().replace("\\", "\\\\").replace(".", "");
         Random rand=new Random();
         rNum=rand.nextInt(1000)+1;
         qry="SELECT Street_no,Street,City,State,Country,Zip,Phone FROM ADDRESS WHERE ID= "+String.valueOf(rNum);
         try{
                    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                    //System.out.println(DriverManager.getDrivers());
                    con=DriverManager.getConnection("jdbc:ucanaccess://"+p+"DB\\TESTDATAGEN.accdb");
                    st=con.createStatement();
                    rs=st.executeQuery(qry);
                    while(rs.next())
                    {
                        this.streetNo=rs.getString("Street_no");
                        this.street=rs.getString("Street");
                        this.city=rs.getString("City");
                        this.state=rs.getString("State");
                        this.country=rs.getString("Country");
                        this.zip=rs.getString("Zip");
                        this.phone=rs.getString("Phone");
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
    
    public String getStreetNo()
    {
        return streetNo;
    }
    
    public String getStreet()
    {
        return street;
    }
    
    public String getCity()
    {
        return city;
    }
    
    public String getCountry()
    {
        return country;
    }
    
    public String getState()
    {
        return state;
    }
    
    public String getZip()
    {
        return zip;
    }
    
    public String getPhone()
    {
        return phone;
    }
}
