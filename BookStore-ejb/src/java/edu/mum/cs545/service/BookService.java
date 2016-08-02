/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.service;

import edu.mum.cs545.model.Book;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Lin
 */
public interface BookService {

    void save(Book book);

    void delete(long id);

    Book findOne(long id);

    Book update(Book book);

    List<Book> findAll();
    
    Map<Long, Book> getBookMap();

    List<Book> findBooksByName(String name);
}
