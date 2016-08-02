/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.service;

import edu.mum.cs545.model.Comment;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Lin
 */
public interface CommentService {

    void save(Comment comment);

    void delete(long id);

    Comment findOne(long id);

    Comment update(Comment t);

    List<Comment> findAll();
    
    Map<Long, Comment> getCommentMap();
}
