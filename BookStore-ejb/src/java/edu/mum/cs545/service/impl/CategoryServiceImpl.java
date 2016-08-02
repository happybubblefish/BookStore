/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.service.impl;

import edu.mum.cs545.dao.BookDao;
import edu.mum.cs545.dao.CategoryDao;
import edu.mum.cs545.model.Book;
import edu.mum.cs545.model.Category;
import edu.mum.cs545.service.CategoryService;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Lin
 */
@Stateless
public class CategoryServiceImpl implements CategoryService {

    @EJB
    private CategoryDao categoryDao;
    
    @EJB
    private BookDao bookDao;
    
    @Override
    public void save(Category category) {
        categoryDao.save(category);
    }

    @Override
    public void delete(long id) {
        categoryDao.delete(id);
    }

    @Override
    public Category findOne(long id) {
        return categoryDao.findOne(id);
    }

    @Override
    public Category update(Category category) {
        return categoryDao.update(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public Category findOneByBookId(long id) {
        Book book = bookDao.findOne(id);
        
        return categoryDao.findOne(book.getCgId());
    }

    @Override
    public long getCategoryIdByName(String categoryName) {
        List<Category> categories = categoryDao.findAll();
        
        for(Category c : categories){
            if(c.getCgName().equals(categoryName)){
                return c.getCgId();
            }
        }
        
        return 0;
    }

    @Override
    public Map<Long, Category> getCategoryMap() {
        return categoryDao.getMap();
    }
}
