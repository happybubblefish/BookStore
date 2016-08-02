/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.mb;

import edu.mum.cs545.model.Book;
import edu.mum.cs545.model.Comment;
import edu.mum.cs545.model.Person;
import edu.mum.cs545.service.BookService;
import edu.mum.cs545.service.CommentService;
import edu.mum.cs545.service.PersonService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tony
 */
@Named(value = "commentMB")
@SessionScoped
public class CommentMB implements Serializable {

    /**
     * Creates a new instance of commentMB
     */
    @EJB
    private BookService bookService;

    @EJB
    private CommentService commentService;

    @EJB
    private PersonService personService;

    private List<Comment> filteredComments;
    private Comment comment;
    private Book bk;
    List<String> errorMsg;

    public CommentMB() {
        comment = new Comment();
        bk = new Book();
        errorMsg = new ArrayList<String>();
    }

    public List<String> getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(List<String> errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Book getBk() {
        return bk;
    }

    public void setBk(Book bk) {
        this.bk = bk;
    }

    public BookService getBookService() {
        return bookService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    public CommentService getCommentService() {
        return commentService;
    }

    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    public PersonService getPersonService() {
        return personService;
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    public List<Comment> getFilteredComments() {
        return filteredComments;
    }

    public void setFilteredComments(List<Comment> filteredComments) {
        this.filteredComments = filteredComments;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public int findCommentSize(Book bk) {
        findAllComments(bk);
        return this.filteredComments.size();
    }

    public String getBookTitleByCid(int bid) {
        //List<String> bookTitle = new ArrayList<String>();
        int currentBid = 0;
        Book book;
        //currentBid = (int) this.filteredComments.get(0).getBid();
        book = this.bookService.findOne(bid);
        String bookTitle = book.getTitle();
        return bookTitle;
    }

    public String preEditReview(Comment ct) {
        this.comment = ct;
        return "commentEdit.jsf";
    }

    public String updateReview() {
        if (this.comment.getTitle() == null || this.comment.getTitle().trim().isEmpty()) {
            this.errorMsg.clear();
            this.errorMsg.add("Oops, title is mandatory");
            return "commentEdit.jsf";
        } else {
            this.errorMsg.clear();
        }
        if (this.comment.getContent() == null || this.comment.getContent().trim().isEmpty()) {
            this.errorMsg.clear();
            this.errorMsg.add("Oops, content is mandatory");
            return "commentEdit.jsf";
        } else {
            this.errorMsg.clear();
        }
        commentService.update(this.comment);
        this.comment.setPublishDate(new Date());
        Collections.sort(this.filteredComments);
        this.comment = new Comment();
        return "commentSuccess.jsf";
    }

    public String findAllComments(Book bk) {
        this.errorMsg.clear();
        this.filteredComments = commentService.findAll().stream()
                .filter(e -> e.getBid() == (bk.getBid())).collect(Collectors.toList());
        Collections.sort(this.filteredComments);
        this.bk = bk;
        return "comment.jsf";
    }

    public int getCommentsCount(Book bk) {
        this.filteredComments = commentService.findAll().stream()
                .filter(e -> e.getBid() == (bk.getBid())).collect(Collectors.toList());

        return this.filteredComments.size();
    }

    private Person getCurrentUser() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) ctx.getExternalContext().getSession(false);
        Person user = (Person) session.getAttribute("user");
        return user;
    }

//long cid, Date publishDate, String title, String content, long bid, long pid, boolean status
    public String save(Comment ct) {
//        CommentDaoImpl cdi = new CommentDaoImpl();
//        cdi.inits();
        Person user = getCurrentUser();
        if (user == null) {
            this.comment = new Comment();
            return "login.jsf";
        }
        if (user.getRoleId() == 1) {
            this.errorMsg.clear();
            this.errorMsg.add("Sorry, you don't have write comment permission");
            return "comment.jsf";
        } else {
            this.errorMsg.clear();
        }
        if (this.comment.getTitle() == null || this.comment.getTitle().trim().isEmpty()) {
            this.errorMsg.clear();
            this.errorMsg.add("Oops, title is mandatory");
            return "comment.jsf";
        } else {
            this.errorMsg.clear();
        }
        if (this.comment.getContent() == null || this.comment.getContent().trim().isEmpty()) {
            this.errorMsg.clear();
            this.errorMsg.add("Oops, content is mandatory");
            return "comment.jsf";
        } else {
            this.errorMsg.clear();
        }

        Comment newct = new Comment();
        newct.setbId(this.bk.getBid());
        newct.setCid(generateCId());
        newct.setpId(user.getPid());
        newct.setPublishDate(new Date());
        newct.setTitle(this.comment.getTitle());
        newct.setContent(this.comment.getContent());
        newct.setStatus(true);

        Book bk = bookService.findOne(this.bk.getBid());
        bk.getCommentList().add(newct);
        bookService.update(bk);

        commentService.save(newct);
        this.filteredComments = commentService.findAll();
        for (int i = 0; i < commentService.findAll().size(); i++) {
            if (commentService.findAll().get(i).getBid() != this.bk.getBid()) {
                filteredComments.remove(commentService.findAll().get(i));
            }
        }
        Collections.sort(this.filteredComments);
        this.comment = new Comment();
        this.errorMsg.clear();
        return "commentSuccess.jsf";
    }

    public String delete(long id) {

        Comment c = commentService.findOne(id);
        long bid = c.getBid();
        Book book = bookService.findOne(bid);
        commentService.delete(id);
        bookService.update(book);

        this.filteredComments = commentService.findAll().stream().
                filter(e -> e.getBid() == bid).collect(Collectors.toList());

        Collections.sort(this.filteredComments);

        return "commentSuccess.jsf";
    }

    public String findOne(long bid) {
        this.comment = commentService.findOne(bid);
        return "comment.jsf";
    }

    private int generateCId() {
        return this.commentService.getCommentMap().values().size() + 1;
    }
}
