/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.service.impl;

import edu.mum.cs545.dao.AuthorDao;
import edu.mum.cs545.model.Author;
import edu.mum.cs545.service.AuthorService;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Lin
 */
@Stateless
public class AuthorServiceImpl implements AuthorService {

    @EJB
    private AuthorDao authorDao;
    
    @Override
    public void save(Author author) {
        authorDao.save(author);
    }

    @Override
    public void delete(long id) {
        authorDao.delete(id);
    }

    @Override
    public Author findOne(long id) {
        return authorDao.findOne(id);
    }

    @Override
    public Author update(Author author) {
        return authorDao.update(author);
    }

    @Override
    public List<Author> findAll() {
        return authorDao.findAll();
    }

    @Override
    public Map<Long, Author> getAuthorMap() {
        return authorDao.getMap();                
    }
}
