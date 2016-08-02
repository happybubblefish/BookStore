/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.service.impl;

import edu.mum.cs545.dao.CommentDao;
import edu.mum.cs545.model.Comment;
import edu.mum.cs545.service.CommentService;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Lin
 */
@Stateless
public class CommentServiceImpl implements CommentService {

    @EJB
    private CommentDao commentDao;
    @Override
    public void save(Comment comment) {
        commentDao.save(comment);
    }

    @Override
    public void delete(long id) {
        commentDao.delete(id);
    }

    @Override
    public Comment findOne(long id) {
        return commentDao.findOne(id);
    }

    @Override
    public Comment update(Comment comment) {
        return commentDao.update(comment);
    }

    @Override
    public List<Comment> findAll() {
        return commentDao.findAll();
    }
    
    @Override
    public Map<Long, Comment> getCommentMap() {
        return commentDao.getMap();
    }
}
