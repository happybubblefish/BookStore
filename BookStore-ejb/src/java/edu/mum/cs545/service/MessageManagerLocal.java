/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.service;

import edu.mum.cs545.model.Message;
import java.util.Date;

/**
 *
 * @author Lin
 */
public interface MessageManagerLocal {
     void sendMessage(Message msg);
 
    Message getFirstAfter(Date after);
     
}
