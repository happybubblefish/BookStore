/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.listener;

import edu.mum.cs545.persistence.BookStore;
import edu.mum.cs545.persistence.DataAccess;
import edu.mum.cs545.persistence.DataAccessFacade;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author Lin
 */
public class ApplicationStartup implements ServletContextListener {

    private DataAccess dataAccess = new DataAccessFacade();
    private BookStore bookStore;

    private int userCount = 0;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        init();

        sce.getServletContext().setAttribute("personMap", bookStore.getPersonMap());
        sce.getServletContext().setAttribute("bookMap", bookStore.getBookMap());
        sce.getServletContext().setAttribute("categoryMap", bookStore.getCategoryMap());
        sce.getServletContext().setAttribute("commentMap", bookStore.getCommentMap());
        sce.getServletContext().setAttribute("personRoleMap", bookStore.getPersonRoleMap());
        sce.getServletContext().setAttribute("authorMap", bookStore.getAuthorMap());
        sce.getServletContext().setAttribute("orderMap", bookStore.getOrderMap());
        sce.getServletContext().setAttribute("userCount", userCount);
        sce.getServletContext().setAttribute("bookStore", bookStore);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        dataAccess.saveBookStore(bookStore);
    }

    private void init() {
        this.bookStore = dataAccess.readBookStore();
    }

}
