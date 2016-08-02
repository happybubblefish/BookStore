/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.service;

import edu.mum.cs545.model.Category;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Lin
 */
public interface CategoryService {

    void save(Category category);

    void delete(long id);

    Category findOne(long id);

    Category update(Category category);

    List<Category> findAll();
    
    Map<Long, Category> getCategoryMap();

    Category findOneByBookId(long id);

    long getCategoryIdByName(String categoryName);
}
