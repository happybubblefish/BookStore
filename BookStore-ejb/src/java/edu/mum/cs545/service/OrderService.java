/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.service;

import edu.mum.cs545.model.Order;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Lin
 */
public interface OrderService {
    
    void save(Order order);

    void delete(long id);

    Order findOne(long id);

    Order update(Order order);

    List<Order> findAll();
    
    Map<Long, Order> getOrderMap();
}
