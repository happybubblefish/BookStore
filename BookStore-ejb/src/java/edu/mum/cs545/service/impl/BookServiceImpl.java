/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.service.impl;

import edu.mum.cs545.dao.BookDao;
import edu.mum.cs545.model.Book;
import edu.mum.cs545.service.BookService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Lin
 */
@Stateless
public class BookServiceImpl implements BookService {
    
    @EJB
    private BookDao bookDao;
    
    @Override
    public void save(Book book) {
        bookDao.save(book);
    }

    @Override
    public void delete(long id) {
        bookDao.delete(id);
    }

    @Override
    public Book findOne(long id) {
        return bookDao.findOne(id);
    }

    @Override
    public Book update(Book book) {
        return bookDao.update(book);
    }

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public List<Book> findBooksByName(String name) {
        String searchStr = name.trim().toLowerCase();
        List<Book> res = new ArrayList<Book>();
        
        List<Book> books = findAll();
        
        for(Book bk : books){
            if(bk.getTitle().toLowerCase().contains(searchStr) || bk.getISBN().toLowerCase().contains(searchStr)){
                res.add(bk);
            }
        }
        
        return res;
    }

    @Override
    public Map<Long, Book> getBookMap() {
        return bookDao.getMap();
    }
    
    
}
