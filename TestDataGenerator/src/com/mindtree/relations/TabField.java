/*
 Class TabField
    This class is used to define a field of a table, It contains information such as field name, type, lenght 
    type of value expected and the value stored in that field.
 */
package com.mindtree.relations;

import com.mindtree.preloaded.random.Address;
import com.mindtree.preloaded.random.Person;
import org.apache.commons.lang.RandomStringUtils;
import java.math.*;
import java.util.*;
import java.text.*;
/**
 *
 * @author smakkar
 */
public class TabField {
    private String colName;
    private String colType;
    private int colLen;
    private String colVal;
    private String expVal;
    
   
    public TabField(String ColName,String ColType,int ColLen,String ExpVal)
    {
        this.colName=ColName;
        this.colLen=ColLen;
        this.colType=ColType;
        this.expVal=ExpVal;
        this.colVal="";
    }
    
    public String retChr(int len)
    {
        String val;
        val= RandomStringUtils.randomAlphabetic(len).toUpperCase();
        return val;
    }
    
    public String retStr(int len)
    {
        String val;
        int num;
        Random rand=new Random();
        val=RandomStringUtils.randomAlphabetic(len).toUpperCase();
        num=rand.nextInt(len)+1;
        return val.substring(0, num-1);
    }
    
    public String retAlphaNum(int len)
    {
        String val;
        val=RandomStringUtils.randomAlphanumeric(len);
        return val;
    }
    
    public  String retNum(int len)
    {
        String val;
        val= RandomStringUtils.randomNumeric(len);
        return val;
    }
    
    public String retFloat(int len)
    {
        float val;
        Random rand=new Random();
        val=Integer.getInteger(RandomStringUtils.randomNumeric(len))* rand.nextFloat();
        return String.valueOf(val);
    }
    
    public String retPerc()
    {
        float val;
        Random rnd=new Random();
        do{
            val=rnd.nextFloat()*rnd.nextInt(101);
        }while(val>100);
        return String.valueOf(val);
    }
    public String retFName()
    {
        Person psn=new Person();
        return psn.getFName();
    }
    
    public String retLName()
    {
        Person psn=new Person();
        return psn.getLName();
    }
    
    public String retEmail()
    {
        Person psn=new Person();
        return psn.getEmail();
    }
    
    public String retGender()
    {
        Person psn=new Person();
        return psn.getGender();
    }
    
    public String retStreetNo()
    {
        Address adr=new Address();
        return adr.getStreetNo();
    }
    
    public String retStreet()
    {
        Address adr=new Address();
        return adr.getStreet();
    }
    
    public String retCity()
    {
        Address adr=new Address();
        return adr.getCity();
    }
    
    public String retState()
    {
        Address adr=new Address();
        return adr.getState();
    }
    
    public String retCountry()
    {
        Address adr=new Address();
        return adr.getCountry();
    }
    
    public String retZip()
    {
        Address adr=new Address();
        return adr.getZip();
    }
    
    public String retDTTS(String format)
    {
        DateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss.SSS");
        DateFormat dtFormatter=new SimpleDateFormat("dd-MMM-yyyy");
        DateFormat tmFormatter=new SimpleDateFormat("HH:mm:ss");
        DateFormat tsFormatter=new SimpleDateFormat("HH:mm:ss.SSS");
        Calendar cal=Calendar.getInstance();
        String str_date1="01-JAN-1990 00:00:00.000";
        String str_date2=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss.SSS").format(new Date());
        String retDate=new String();
        try{
             cal.setTime(formatter.parse(str_date1));
             Long value1 = cal.getTimeInMillis();
             cal.setTime(formatter.parse(str_date2));
             Long value2 = cal.getTimeInMillis();
             long value3 = (long)(value1 + Math.random()*(value2 - value1));
             cal.setTimeInMillis(value3);
             switch(format)
             {
                 case "DTTS":retDate= formatter.format(cal.getTime());
                             break;
                 case "DT":retDate=dtFormatter.format(cal.getTime());
                            break;
                 case "TM":retDate=tmFormatter.format(cal.getTime());
                            break;
                 case "TS":retDate=tsFormatter.format(cal.getTime());
                            break;
                 default:System.out.println("Invalid Format !!!");
                         System.exit(0);
             }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return retDate;
    }
    public void setVal()
    {
        switch(expVal)
        {
            case "CHAR":colVal=retChr(colLen);
                        break;
            case "STR":colVal=retStr(colLen);
                        break;
            case "ALPHANUM":colVal=retAlphaNum(colLen);
                        break;
            case "NUM":colVal=retNum(colLen);
                        break;
            case "FLOAT":colVal=retFloat(colLen);
                        break;
            case "FNAME":colVal=retFName();
                        break;
            case "LNAME":colVal=retLName();
                        break;
            case "EMAIL":colVal=retEmail();
                        break;
            case "GENDER":colVal=retGender();
                        break;
            case "STREETNO":colVal=retStreetNo();
                        break;
            case "STREET":colVal=retStreet();
                        break;
            case "CITY":colVal=retCity();
                        break;
            case "STATE":colVal=retState();
                        break;
            case "COUNTRY":colVal=retCountry();
                        break;
            case "ZIP":colVal=retZip();
                        break;
            case "AGE":colVal=retNum(2);
                        break;
            case "PERC":colVal=retPerc();
                        break;
            case "DATE":colVal=retDTTS("DT");
                        break;
            case "TIME":colVal=retDTTS("TM");
                        break;
            case "TIMESTAMP":colVal=retDTTS("DTTS");
                        break;
            default:System.out.println(expVal+" is an undefined value type!!!");
                    System.exit(0);
        }
    }
}
