/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.service;

import edu.mum.cs545.model.Author;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Lin
 */
public interface AuthorService {

    void save(Author author);

    void delete(long id);

    Author findOne(long id);

    Author update(Author author);

    List<Author> findAll();
    
    Map<Long, Author> getAuthorMap();
}
