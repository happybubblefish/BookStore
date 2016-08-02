/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.dao.impl;

import edu.mum.cs545.dao.CategoryDao;
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
public class CategoryDaoImpl implements CategoryDao {

    private Map<Long, Category> categoryMap;

    public CategoryDaoImpl() {
        categoryMap = (HashMap<Long, Category>) Utilities.getServletContext().getAttribute("categoryMap");
    }

    @Override
    public void save(Category category) {
        categoryMap = getMap();
        long id = category.getCgId();
        categoryMap.put(id, category);
        setCategoryMap();
    }

    @Override
    public void delete(long id) {
        categoryMap = getMap();
        Category c = categoryMap.get(id);

        if (c != null && c.isStatus()) {
            c.setStatus(false);
            categoryMap.put(id, c);
        }
        setCategoryMap();
    }

    @Override
    public Category findOne(long id) {
        categoryMap = getMap();
        Category c = categoryMap.get(id);

        if (c != null && c.isStatus()) {
            return c;
        }

        return null;
    }

    @Override
    public Category update(Category category) {
        categoryMap = getMap();
        long id = category.getCgId();
        categoryMap.put(id, category);
        setCategoryMap();

        return category;
    }

    @Override
    public List<Category> findAll() {
        categoryMap = getMap();
        List<Category> categories = new ArrayList<Category>(categoryMap.values());
        List<Category> res = new ArrayList<Category>();

        for (Category c : categories) {
            if (c.isStatus()) {
                res.add(c);
            }
        }

        return res;
    }

    public Map<Long, Category> getMap() {
        ServletContext sct = Utilities.getServletContext();
        return (HashMap<Long, Category>) sct.getAttribute("categoryMap");
    }

    private void setCategoryMap() {
        ServletContext sct = Utilities.getServletContext();
        sct.setAttribute("categoryMap", categoryMap);
    }
}
