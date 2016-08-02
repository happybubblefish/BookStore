/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.service.impl;

import edu.mum.cs545.dao.OrderDao;
import edu.mum.cs545.model.Order;
import edu.mum.cs545.service.OrderService;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Lin
 */
@Stateless
public class OrderServiceImpl implements OrderService {
    
    @EJB
    private OrderDao orderDao;
    
    @Override
    public void save(Order order) {
        orderDao.save(order);
    }

    @Override
    public void delete(long id) {
        orderDao.delete(id);
    }

    @Override
    public Order findOne(long id) {
        return orderDao.findOne(id);
    }

    @Override
    public Order update(Order order) {
        return orderDao.update(order);
    }

    @Override
    public List<Order> findAll() {
        return orderDao.findAll();
    }

    @Override
    public Map<Long, Order> getOrderMap() {
        return orderDao.getMap();
    }
}
