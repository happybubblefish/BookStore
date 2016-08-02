/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Lin
 */
public class Author implements Serializable{
    private long auId;
    private String fname;
    private String lname;
    private Date DOB;
    private String biography;
    private List<Long> publishedBooks;
    private boolean status;
    
    public Author(){}

    public Author(long auId, String fname, String lname, Date DOB, String biography, List<Long> publishedBooks, boolean status) {
        this.auId = auId;
        this.fname = fname;
        this.lname = lname;
        this.DOB = DOB;
        this.biography = biography;
        this.publishedBooks = publishedBooks;
        this.status = status;
    }

    public long getAuId() {
        return auId;
    }

    public void setAuId(long auId) {
        this.auId = auId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public List<Long> getPublishedBooks() {
        return publishedBooks;
    }

    public void setPublishedBooks(List<Long> publishedBooks) {
        this.publishedBooks = publishedBooks;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
