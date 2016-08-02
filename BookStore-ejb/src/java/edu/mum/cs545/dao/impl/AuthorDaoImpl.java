/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.dao.impl;

import edu.mum.cs545.dao.AuthorDao;
import edu.mum.cs545.model.Author;
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
public class AuthorDaoImpl implements AuthorDao {

    Map<Long, Author> authorMap;

    public AuthorDaoImpl() {
        authorMap = getMap();
    }

    @Override
    public void save(Author author) {
        authorMap = getMap();
        long auId = author.getAuId();
        authorMap.put(auId, author);

        setAuthorMap();
    }

    @Override
    public void delete(long id) {
        authorMap = getMap();
        Author au = authorMap.get(id);
        au.setStatus(false);
        authorMap.put(id, au);
        setAuthorMap();
    }

    @Override
    public Author findOne(long id) {
        authorMap = getMap();
        Author au = authorMap.get(id);

        if (au != null && au.isStatus()) {
            return au;
        }

        return null;
    }

    @Override
    public Author update(Author author) {
        authorMap = getMap();
        long auId = author.getAuId();
        authorMap.put(auId, author);
        setAuthorMap();

        return author;
    }

    @Override
    public List<Author> findAll() {
        authorMap = getMap();
        List<Author> authors = new ArrayList<Author>(authorMap.values());
        List<Author> res = new ArrayList<Author>();

        for (Author bk : authors) {
            if (bk.isStatus()) {
                res.add(bk);
            }
        }

        return res;
    }

    public Map<Long, Author> getMap() {
        ServletContext sct = Utilities.getServletContext();
        return (HashMap<Long, Author>) sct.getAttribute("authorMap");
    }

    private void setAuthorMap() {
        ServletContext sct = Utilities.getServletContext();
        sct.setAttribute("authorMap", authorMap);
    }

}
