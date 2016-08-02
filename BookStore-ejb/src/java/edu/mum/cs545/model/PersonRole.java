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
public class PersonRole implements Serializable{
    private long roleId;
    private String roleName;
    private boolean status;

    public PersonRole() {
    }

    public PersonRole(long roleId, String roleName, boolean status) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.status = status;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
