/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.dao;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Lin
 */
public interface GenericDao<T> {
    void save(T t);
    void delete(long id);
    T findOne(long id);
    T update(T t);
    List<T> findAll();
    Map<Long, T> getMap();
}
