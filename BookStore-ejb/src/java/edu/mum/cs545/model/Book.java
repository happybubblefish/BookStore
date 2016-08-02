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
public class Book implements Comparable<Book>, Serializable {
    private long bid;
    private String ISBN;
    private String title;
    private int year;
    private long authorId;
    private long cgId;
    private int stockCount;
    private Date importDate;
    private double price;
    private boolean status;
    private String category;
    private String imageName;
    private List<Comment> commentList;
    
    public Book(){}
    
    public Book(long bid, String ISBN, String title, int year, long authorId, long cgId, int stockCount, Date importDate, double price, String imageName, List<Comment> commentList, boolean status){
        this.bid = bid;
        this.ISBN = ISBN;
        this.title = title; 
        this.year = year;
        this.authorId = authorId;
        this.cgId = cgId;
        this.stockCount = stockCount;
        this.importDate = importDate;
        this.price = price;
        this.imageName = imageName;
        this.commentList = commentList;
        this.status = status;
    }

    public long getBid() {
        return bid;
    }

    public void setBid(long bid) {
        this.bid = bid;
    }

    public String getISBN() {
        return ISBN;
        
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public long getCgId() {
        return cgId;
    }

    public void setCgId(long cgId) {
        this.cgId = cgId;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }

    public Date getImportDate() {
        return importDate;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @Override
    public int compareTo(Book o) {
        return this.getPrice() - o.getPrice() >= 0 ? 1 : -1;
    }
}
