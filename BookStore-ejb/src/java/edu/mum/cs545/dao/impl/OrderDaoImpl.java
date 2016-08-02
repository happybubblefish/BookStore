/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.dao.impl;

import edu.mum.cs545.dao.OrderDao;
import edu.mum.cs545.model.Order;
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
public class OrderDaoImpl implements OrderDao {
    
    private Map<Long, Order> orderMap;
    
    public OrderDaoImpl(){
        orderMap = (HashMap<Long, Order>)Utilities.getServletContext().getAttribute("orderMap");
    }
    
    @Override
    public void save(Order order) {
        orderMap = getMap();
        long id = order.getOid();
        orderMap.put(id, order);
        setOrderMap();
    }

    @Override
    public void delete(long id) {
        orderMap = getMap();
        Order order = orderMap.get(id);
        order.setStatus(false);
        orderMap.put(id, order);
        setOrderMap();
    }

    @Override
    public Order findOne(long id) {
        orderMap = getMap();
        Order order = orderMap.get(id);

        if (order != null && order.isStatus()) {
            return order;
        }

        return null;
    }

    @Override
    public Order update(Order order) {
        orderMap = getMap();
        long oId = order.getOid();
        orderMap.put(oId, order);
        setOrderMap();

        return order;
    }

    @Override
    public List<Order> findAll() {
        orderMap = getMap();
        List<Order> orders = new ArrayList<Order>(orderMap.values());
        List<Order> res = new ArrayList<Order>();

        for (Order o : orders) {
            if (o.isStatus()) {
                res.add(o);
            }
        }

        return res;
    }
    
    
    public Map<Long, Order> getMap() {
        ServletContext sct = Utilities.getServletContext();
        return (HashMap<Long, Order>) sct.getAttribute("orderMap");
    }

    private void setOrderMap() {
        ServletContext sct = Utilities.getServletContext();
        sct.setAttribute("orderMap", orderMap);
    }
}
