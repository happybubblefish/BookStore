/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.persistence;

import edu.mum.cs545.model.Author;
import edu.mum.cs545.model.Book;
import edu.mum.cs545.model.Category;
import edu.mum.cs545.model.Comment;
import edu.mum.cs545.model.Order;
import edu.mum.cs545.model.Person;
import edu.mum.cs545.model.PersonRole;
import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author johnny
 */
public class BookStore implements Serializable{
    private Map<Long, Person> personMap;
    private Map<Long, Book> bookMap;
    private Map<Long, Category> categoryMap;
    private Map<Long, Comment> commentMap;
    private Map<Long, PersonRole> personRoleMap;
    private Map<Long, Author> authorMap;
    private Map<Long, Order> orderMap;

    /**
     * @return the personMap
     */
    public Map<Long, Person> getPersonMap() {
        return personMap;
    }

    /**
     * @param personMap the personMap to set
     */
    public void setPersonMap(Map<Long, Person> personMap) {
        this.personMap = personMap;
    }

    /**
     * @return the bookMap
     */
    public Map<Long, Book> getBookMap() {
        return bookMap;
    }

    /**
     * @param bookMap the bookMap to set
     */
    public void setBookMap(Map<Long, Book> bookMap) {
        this.bookMap = bookMap;
    }

    /**
     * @return the categoryMap
     */
    public Map<Long, Category> getCategoryMap() {
        return categoryMap;
    }

    /**
     * @param categoryMap the categoryMap to set
     */
    public void setCategoryMap(Map<Long, Category> categoryMap) {
        this.categoryMap = categoryMap;
    }

    /**
     * @return the commentMap
     */
    public Map<Long, Comment> getCommentMap() {
        return commentMap;
    }

    /**
     * @param commentMap the commentMap to set
     */
    public void setCommentMap(Map<Long, Comment> commentMap) {
        this.commentMap = commentMap;
    }

    /**
     * @return the personRoleMap
     */
    public Map<Long, PersonRole> getPersonRoleMap() {
        return personRoleMap;
    }

    /**
     * @param personRoleMap the personRoleMap to set
     */
    public void setPersonRoleMap(Map<Long, PersonRole> personRoleMap) {
        this.personRoleMap = personRoleMap;
    }

    /**
     * @return the authorMap
     */
    public Map<Long, Author> getAuthorMap() {
        return authorMap;
    }

    /**
     * @param authorMap the authorMap to set
     */
    public void setAuthorMap(Map<Long, Author> authorMap) {
        this.authorMap = authorMap;
    }

    /**
     * @return the orderMap
     */
    public Map<Long, Order> getOrderMap() {
        return orderMap;
    }

    /**
     * @param orderMap the orderMap to set
     */
    public void setOrderMap(Map<Long, Order> orderMap) {
        this.orderMap = orderMap;
    }
    
}
