/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author Lin
 */
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        return;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        int userCount = (Integer)se.getSession().getServletContext().getAttribute("userCount");
        userCount--;
        se.getSession().getServletContext().setAttribute("userCount", userCount);
    }
    
}
