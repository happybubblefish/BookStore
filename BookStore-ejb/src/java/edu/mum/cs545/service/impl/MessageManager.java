/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.service.impl;

import edu.mum.cs545.model.Message;
import edu.mum.cs545.service.MessageManagerLocal;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author Lin
 */
@Singleton
@Startup
public class MessageManager implements MessageManagerLocal {
 Message m=new Message();
    private final List messages =
            Collections.synchronizedList(new LinkedList());;
 
    @Override
    public void sendMessage(Message msg) {
        System.out.println("mum.edu.MessageManager.sendMessage()");
        messages.add(msg);
        msg.setDateSent(new Date());
    }
 
    @Override
    public Message getFirstAfter(Date after) {
        if(messages.isEmpty())
            return null;
        if(after == null)
            return (Message) messages.get(0);
        for (Iterator it = messages.iterator(); it.hasNext();) {
        Message m = (Message) it.next();
           if(m.getDateSent().after(after))
               return m;
        }
      return null;
    }
    
}
