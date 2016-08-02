/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Lin
 */
public class Comment implements Comparable, Serializable{
    private long cid;
    private Date publishDate;
    private String title;
    private String content;
    private long bid;
    private long pid;
    private boolean status;

    public Comment() {
    }

    public Comment(long cid, Date publishDate, String title, String content, long bid, long pid, boolean status) {
        this.cid = cid;
        this.publishDate = publishDate;
        this.title = title;
        this.content = content;
        this.bid = bid;
        this.pid = pid;
        this.status = status;
    }

    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getBid() {
        return bid;
    }

    public void setbId(long bid) {
        this.bid = bid;
    }

    public long getPid() {
        return pid;
    }

    public void setpId(long pid) {
        this.pid = pid;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public int compareTo(Object o) {
        Comment other = (Comment)o;
        if (this.getPublishDate() != other.getPublishDate()) {
            return other.getPublishDate().compareTo(this.getPublishDate());
        } else {
            return (int) (this.getCid() - other.getCid());
        }
    }
}
