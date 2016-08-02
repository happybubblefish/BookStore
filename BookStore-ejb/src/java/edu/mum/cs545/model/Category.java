/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.model;

import java.io.Serializable;

/**
 *
 * @author Lin
 */
public class Category implements Serializable{
    private long cgId;
    private String cgName;
    private boolean status;
    
    public Category(){}
    
    public Category(long cgId, String cgName, boolean status){
        this.cgId = cgId;
        this.cgName = cgName;
        this.status = status;
    }

    public long getCgId() {
        return cgId;
    }

    public void setCgId(long cgId) {
        this.cgId = cgId;
    }

    public String getCgName() {
        return cgName;
    }

    public void setCgName(String cgName) {
        this.cgName = cgName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
