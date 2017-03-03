/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mindtree.relations;

import java.lang.*;
import java.util.*;
/**
 *
 * @author smakkar
 */
public class RowData {
    private ArrayList<TabField> rData;
    
    public RowData()
    {
        this.rData=new ArrayList<>();
    }
    
    public void addField(TabField field)
    {
        TabField fld=field;
        fld.setVal();
        rData.add(fld);
    }
    
    
    public ArrayList<TabField> retRow()
    {
        return rData;
    }
    
}
