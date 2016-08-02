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
public class Person implements Serializable{
    private long pid;
    private String fname;
    private String lname;
    private Date DOB;
    private String phone;
    private String email;
    private boolean status;
    private long roleId;
    private Map<Long, Order> orderMap;
    private Map<Long, Integer> shoppingCart;
    private Map<Long, Map<Long, Integer>> shoppingCartMap;
    private String password;
    private String verifyPassword;
    private boolean isLoggedIn;
    private String gender;

    public Person() {
    }

    public Person(long pid, String fname, String lname, String gender, Date DOB, String phone, String email, String password, long roleId, Map<Long, Order> orderMap, Map<Long, Integer> shoppingCart, Map<Long, Map<Long, Integer>> shoppingCartMap, boolean isLoggedIn, boolean status) {
        this.pid = pid;
        this.fname = fname;
        this.lname = lname;
        this.gender = gender;
        this.DOB = DOB;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.isLoggedIn = isLoggedIn;
        this.status = status;
        this.roleId = roleId;
        this.orderMap = orderMap;
        this.shoppingCart = shoppingCart;
        this.shoppingCartMap = shoppingCartMap;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public Map<Long, Order> getOrderMap() {
        return orderMap;
    }

    public void setOrderMap(Map<Long, Order> orderMap) {
        this.orderMap = orderMap;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

    public boolean isIsLoggedIn() {
        return isLoggedIn;
    }

    public void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Map<Long, Integer> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(Map<Long, Integer> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Map<Long, Map<Long, Integer>> getShoppingCartMap() {
        return shoppingCartMap;
    }

    public void setShoppingCartMap(Map<Long, Map<Long, Integer>> shoppingCartMap) {
        this.shoppingCartMap = shoppingCartMap;
    }
}
