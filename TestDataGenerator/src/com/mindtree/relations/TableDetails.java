/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mindtree.relations;

import java.lang.*;
import java.util.ArrayList;
/**
 *
 * @author smakkar
 */
public class TableDetails {
    private ArrayList<RowData> tabData;
    private ArrayList<TabField>row;
    private String tableName;
    private long recCnt;

    public TableDetails() 
    {
        this.tabData = new ArrayList<>();
    }
    
    public TableDetails(String tName,long rCnt,ArrayList<TabField> r)
    {
        this.tabData = new ArrayList<>();
        this.recCnt=rCnt;
        this.tableName=tName;
        this.row=r;
    }
    
    public void genTabData()
    {
        int i,j;
        for(i=0;i<recCnt;i++)
        {
            RowData rd=new RowData();
            for(j=0;j<row.size();j++)
            {
                rd.addField(row.get(j));
            }
            tabData.add(rd);
        }
    }
    
    public void printData()
    {
        
    }
    
}
