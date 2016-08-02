/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.dao.impl;

import edu.mum.cs545.dao.BookDao;
import edu.mum.cs545.model.Book;
import edu.mum.cs545.model.Category;
import edu.mum.cs545.utils.Utilities;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.servlet.ServletContext;

/**
 *
 * @author Lin
 */
@Stateless
public class BookDaoImpl implements BookDao {

    private Map<Long, Book> bookMap;
    private List<Category> categories;

    public BookDaoImpl() {
        bookMap = getMap();
    }

    @Override
    public void save(Book book) {
        bookMap = getMap();
        long bId = book.getBid();
        bookMap.put(bId, book);
        setBookMap();
    }

    //Does not really delete the book from repository, just set the status to false.
    @Override
    public void delete(long id) {
        bookMap = getMap();
        Book book = bookMap.get(id);
        book.setStatus(false);
        bookMap.put(id, book);
        setBookMap();
    }

    @Override
    public Book findOne(long id) {
        bookMap = getMap();
        Book bk = bookMap.get(id);

        if (bk != null && bk.isStatus()) {
            return bk;
        }

        return null;
    }

    @Override
    public Book update(Book book) {
        bookMap = getMap();
        long bId = book.getBid();
        bookMap.put(bId, book);
        setBookMap();

        return book;
    }

    public List<Book> findAll() {
        bookMap = getMap();
        List<Book> books = new ArrayList<Book>(bookMap.values());
        List<Book> res = new ArrayList<Book>();

        for (Book bk : books) {
            if (bk.isStatus()) {
                res.add(bk);
            }
        }

        return res;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public Map<Long, Book> getMap() {
        ServletContext sct = Utilities.getServletContext();
        return (HashMap<Long, Book>) sct.getAttribute("bookMap");
    }

    private void setBookMap() {
        ServletContext sct = Utilities.getServletContext();
        sct.setAttribute("bookMap", this.bookMap);
    }
}
