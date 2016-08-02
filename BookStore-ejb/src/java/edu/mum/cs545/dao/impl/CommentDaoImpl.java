/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.dao.impl;

import edu.mum.cs545.dao.CommentDao;
import edu.mum.cs545.model.Comment;
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
public class CommentDaoImpl implements CommentDao {

    private Map<Long, Comment> commentMap;

    public CommentDaoImpl() {
        commentMap = getMap();
    }

    @Override
    public void save(Comment comment) {
        commentMap = getMap();
        long cId = comment.getCid();
        commentMap.put(cId, comment);
        setCommentMap();
    }

    @Override
    public void delete(long id) {
        commentMap = getMap();
        Comment comment = commentMap.get(id);

        if (comment != null) {
            comment.setStatus(false);
            commentMap.put(id, comment);
            setCommentMap();
        }
    }

    @Override
    public Comment findOne(long id) {
        commentMap = getMap();
        Comment comment = commentMap.get(id);

        if (comment != null && comment.isStatus()) {
            return comment;
        }

        return null;
    }

    @Override
    public Comment update(Comment comment) {
        commentMap = getMap();
        long cId = comment.getCid();
        commentMap.put(cId, comment);
        setCommentMap();

        return comment;
    }

    @Override
    public List<Comment> findAll() {
        commentMap = getMap();
        List<Comment> comments = new ArrayList<Comment>(commentMap.values());
        List<Comment> res = new ArrayList<Comment>();

        for (Comment c : comments) {
            if (c.isStatus()) {
                res.add(c);
            }
        }

        return res;
    }

    public Map<Long, Comment> getMap() {
        ServletContext sct = Utilities.getServletContext();
        return (HashMap<Long, Comment>) sct.getAttribute("commentMap");
    }

    private void setCommentMap() {
        ServletContext sct = Utilities.getServletContext();
        sct.setAttribute("commentMap", this.commentMap);
    }
}
