/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 *
 * @author Lin
 */
public class Utilities<T> {

    public static Date getDate(String dateStr) {
        String pattern = "MM/dd/yyyy";
        SimpleDateFormat format = new SimpleDateFormat(pattern);

        Date date = null;
        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    public static ServletContext getServletContext() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        ServletContext sct = (ServletContext) ctx.getExternalContext().getContext();

        return sct;
    }

    public static String getResourceBundleString(String resourceBundleName, String resourceBundleKey) throws MissingResourceException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ResourceBundle bundle = facesContext.getApplication().getResourceBundle(facesContext, resourceBundleName);
        return bundle.getString(resourceBundleKey);
    }
}
