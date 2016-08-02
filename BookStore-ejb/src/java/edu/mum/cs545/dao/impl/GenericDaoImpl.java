/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.dao.impl;

import edu.mum.cs545.dao.GenericDao;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Lin
 */

//@Stateless
public abstract class GenericDaoImpl<T> implements GenericDao<T> {
    
    protected Map<Long, T> map;
    protected Class<T> daoType;

    public void setMap(Map<Long, T> map) {
        this.map = map;
    }

    public void setDaoType(Class<T> daoType) {
        this.daoType = daoType;
    }
    
    @Override
    public void save(T t) {
        
    }

    @Override
    public void delete(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T findOne(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T update(T t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    abstract public List<T> findAll();
    
}
