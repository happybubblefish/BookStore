/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author Lin
 */
public class Order implements Serializable{
    private long oid;
    private Date placeDate;
//    private long bid;
    private long pid;
    private Map<Long, Integer> cartBooks;
    private double finalPrice;
    private boolean status;

    public Order() {
    }

    public Order(long oid, Date placeDate, long pid, Map<Long, Integer> cartBooks, double finalPrice, boolean status) {
        this.oid = oid;
        this.placeDate = placeDate;
//        this.bid = bid;
        this.pid = pid;
        this.cartBooks = cartBooks;
        this.finalPrice = finalPrice;
        this.status = status;
    }

    public long getOid() {
        return oid;
    }

    public void setoId(long oid) {
        this.oid = oid;
    }

    public Date getPlaceDate() {
        return placeDate;
    }

    public void setPlaceDate(Date placeDate) {
        this.placeDate = placeDate;
    }

//    public long getBid() {
//        return bid;
//    }
//
//    public void setBid(long bid) {
//        this.bid = bid;
//    }

    public long getPid() {
        return pid;
    }

    public void setpId(long pid) {
        this.pid = pid;
    }

    public Map<Long, Integer> getCartBooks() {
        return cartBooks;
    }

    public void setCartBooks(Map<Long, Integer> cartBooks) {
        this.cartBooks = cartBooks;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
