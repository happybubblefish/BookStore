/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.persistence;

import edu.mum.cs545.model.Author;
import edu.mum.cs545.model.Book;
import edu.mum.cs545.model.Category;
import edu.mum.cs545.model.Comment;
import edu.mum.cs545.model.Order;
import edu.mum.cs545.model.Person;
import edu.mum.cs545.model.PersonRole;
import edu.mum.cs545.utils.Utilities;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author johnny
 */
public class Main {
    
    public static void main(String[] args){
        DataAccess da = new DataAccessFacade();
        BookStore bs = new BookStore();
       
        //Init Person
        Map<Long,Person> personMap = new HashMap<Long, Person>();
        personMap.put(1L, new Person(1, "Jack", "LJack", "male", Utilities.getDate("03/10/1988"), "2404739087", "timekeeper1516@gmail.com", "123", 1, new HashMap<Long, Order>(), new HashMap<Long, Integer>(), new HashMap<Long, Map<Long, Integer>>(), false, true));
        personMap.put(2L, new Person(2, "Tom", "LTom", "male", Utilities.getDate("04/02/1985"), "2409846182", "congls2007@yahoo.com", "123", 2, new HashMap<Long, Order>(), new HashMap<Long, Integer>(), new HashMap<Long, Map<Long, Integer>>(), false, true));
        personMap.put(3L, new Person(3, "Jerry", "LJerry", "male", Utilities.getDate("05/08/1975"), "2109298732", "jerry@123.com", "123", 2, new HashMap<Long, Order>(), new HashMap<Long, Integer>(), new HashMap<Long, Map<Long, Integer>>(), false, true));
        bs.setPersonMap(personMap);
        
        //Init Book
        Map<Long,Book> bookMap = new HashMap<Long, Book>();
        List<Comment> commentList1 = new ArrayList<Comment>();
        List<Comment> commentList2 = new ArrayList<Comment>();
        List<Comment> commentList3 = new ArrayList<Comment>();
        List<Comment> commentList4 = new ArrayList<Comment>();
        List<Comment> commentList5 = new ArrayList<Comment>();
        List<Comment> commentList6 = new ArrayList<Comment>();
        List<Comment> commentList7 = new ArrayList<Comment>();
        List<Comment> commentList8 = new ArrayList<Comment>();
        List<Comment> commentList9 = new ArrayList<Comment>();
        List<Comment> commentList10 = new ArrayList<Comment>();
        List<Comment> commentList11 = new ArrayList<Comment>();
        List<Comment> commentList12 = new ArrayList<Comment>();
        List<Comment> commentList13 = new ArrayList<Comment>();
        List<Comment> commentList14 = new ArrayList<Comment>();
        List<Comment> commentList15 = new ArrayList<Comment>();
        List<Comment> commentList16 = new ArrayList<Comment>();
        List<Comment> commentList17 = new ArrayList<Comment>();
        List<Comment> commentList18 = new ArrayList<Comment>();
        List<Comment> commentList19 = new ArrayList<Comment>();
        List<Comment> commentList20 = new ArrayList<Comment>();

        Comment c1 = new Comment(1, Utilities.getDate("03/20/2016"), "Very Good", "Nice buy.", 1, 1, true);
        Comment c2 = new Comment(2, Utilities.getDate("04/10/2016"), "Very Good Seller", "Wanna do business again.", 1, 2, true);

        Comment c3 = new Comment(3, Utilities.getDate("12/20/2015"), "Very fast shipping", "Very nice business.", 2, 1, true);
        Comment c4 = new Comment(4, Utilities.getDate("01/08/2016"), "Good buy", "No complaint.", 2, 2, true);
        Comment c5 = new Comment(5, Utilities.getDate("05/05/2016"), "Just try this", "No regret.", 2, 2, true);

        Comment c6 = new Comment(6, Utilities.getDate("04/22/2016"), "Very nice seller", "Wow, nothing to complaint.", 3, 2, true);
        Comment c7 = new Comment(7, Utilities.getDate("03/20/2016"), "Very Good", "Nice buy.", 3, 1, true);

        Comment c8 = new Comment(8, Utilities.getDate("04/10/2016"), "Very Good Seller", "Wanna do business again.", 4, 2, true);
        Comment c9 = new Comment(9, Utilities.getDate("12/20/2015"), "Very fast shipping", "Very nice business.", 4, 1, true);

        Comment c10 = new Comment(10, Utilities.getDate("01/08/2016"), "Good buy", "No complaint.", 5, 2, true);

        Comment c11 = new Comment(11, Utilities.getDate("05/05/2016"), "Just try this", "No regret.", 6, 2, true);
        Comment c12 = new Comment(12, Utilities.getDate("04/22/2016"), "Very nice seller", "Wow, nothing to complaint.", 6, 2, true);

        Comment c13 = new Comment(13, Utilities.getDate("03/20/2016"), "Very Good", "Nice buy.", 7, 1, true);
        Comment c14 = new Comment(14, Utilities.getDate("04/10/2016"), "Very Good Seller", "Wanna do business again.", 7, 2, true);

        Comment c15 = new Comment(15, Utilities.getDate("12/20/2015"), "Very fast shipping", "Very nice business.", 8, 1, true);
        Comment c16 = new Comment(16, Utilities.getDate("01/08/2016"), "Good buy", "No complaint.", 8, 2, true);
        Comment c17 = new Comment(17, Utilities.getDate("05/05/2016"), "Just try this", "No regret.", 8, 2, true);

        Comment c18 = new Comment(18, Utilities.getDate("04/22/2016"), "Very nice seller", "Wow, nothing to complaint.", 9, 2, true);
        Comment c19 = new Comment(19, Utilities.getDate("05/05/2016"), "Just try this", "No regret.", 9, 2, true);
        Comment c20 = new Comment(20, Utilities.getDate("04/22/2016"), "Very nice seller", "Wow, nothing to complaint.", 9, 2, true);

        Comment c21 = new Comment(21, Utilities.getDate("05/05/2016"), "Just try this", "No regret.", 10, 2, true);

        Comment c22 = new Comment(22, Utilities.getDate("04/22/2016"), "Very nice seller", "Wow, nothing to complaint.", 11, 2, true);

        Comment c23 = new Comment(23, Utilities.getDate("03/20/2016"), "Very Good", "Nice buy.", 12, 1, true);

        Comment c24 = new Comment(24, Utilities.getDate("04/10/2016"), "Very Good Seller", "Wanna do business again.", 13, 2, true);
        Comment c25 = new Comment(25, Utilities.getDate("12/20/2015"), "Very fast shipping", "Very nice business.", 13, 1, true);

        Comment c26 = new Comment(26, Utilities.getDate("01/08/2016"), "Good buy", "No complaint.", 14, 2, true);
        Comment c27 = new Comment(27, Utilities.getDate("05/05/2016"), "Just try this", "No regret.", 14, 2, true);

        Comment c28 = new Comment(28, Utilities.getDate("04/22/2016"), "Very nice seller", "Wow, nothing to complaint.", 15, 2, true);
        Comment c29 = new Comment(29, Utilities.getDate("05/05/2016"), "Just try this", "No regret.", 15, 2, true);
        Comment c30 = new Comment(30, Utilities.getDate("04/22/2016"), "Very nice seller", "Wow, nothing to complaint.", 15, 2, true);

        Comment c31 = new Comment(31, Utilities.getDate("05/05/2016"), "Just try this", "No regret.", 16, 2, true);

        Comment c32 = new Comment(32, Utilities.getDate("04/22/2016"), "Very nice seller", "Wow, nothing to complaint.", 17, 2, true);
        Comment c33 = new Comment(33, Utilities.getDate("03/20/2016"), "Very Good", "Nice buy.", 17, 1, true);

        Comment c34 = new Comment(34, Utilities.getDate("04/10/2016"), "Very Good Seller", "Wanna do business again.", 18, 2, true);
        Comment c35 = new Comment(35, Utilities.getDate("12/20/2015"), "Very fast shipping", "Very nice business.", 18, 1, true);

        Comment c36 = new Comment(36, Utilities.getDate("01/08/2016"), "Good buy", "No complaint.", 19, 2, true);
        Comment c37 = new Comment(37, Utilities.getDate("05/05/2016"), "Just try this", "No regret.", 19, 2, true);

        Comment c38 = new Comment(38, Utilities.getDate("04/22/2016"), "Very nice seller", "Wow, nothing to complaint.", 20, 2, true);
        Comment c39 = new Comment(39, Utilities.getDate("05/05/2016"), "Just try this", "No regret.", 20, 2, true);
        Comment c40 = new Comment(40, Utilities.getDate("04/22/2016"), "Very nice seller", "Wow, nothing to complaint.", 20, 2, true);

        commentList1.add(c1);
        commentList1.add(c2);

        commentList2.add(c3);
        commentList2.add(c4);
        commentList2.add(c5);

        commentList3.add(c6);
        commentList3.add(c7);

        commentList4.add(c8);
        commentList4.add(c9);

        commentList5.add(c10);

        commentList6.add(c11);
        commentList6.add(c12);

        commentList7.add(c13);
        commentList7.add(c14);

        commentList8.add(c15);
        commentList8.add(c16);
        commentList8.add(c17);

        commentList9.add(c18);
        commentList9.add(c19);
        commentList9.add(c20);

        commentList10.add(c21);

        commentList11.add(c22);

        commentList12.add(c23);

        commentList13.add(c24);
        commentList13.add(c25);

        commentList14.add(c26);
        commentList14.add(c27);

        commentList15.add(c28);
        commentList15.add(c29);
        commentList15.add(c30);

        commentList16.add(c31);

        commentList17.add(c32);
        commentList17.add(c33);

        commentList18.add(c34);
        commentList18.add(c35);

        commentList19.add(c36);
        commentList19.add(c37);

        commentList20.add(c38);
        commentList20.add(c39);
        commentList20.add(c40);

        bookMap.put(1L, new Book(1, "ISBN_123456789", "Code", 2010, 2, 1, 12, Utilities.getDate("03/20/2010"), 54.99, "IT1", commentList1, true));
        bookMap.put(2L, new Book(2, "ISBN_129825678", "How computers work", 2011, 1, 1, 22, Utilities.getDate("10/25/2012"), 19.99, "IT2", commentList2, true));
        bookMap.put(3L, new Book(3, "ISBN_234525593", "Jquery", 2013, 3, 1, 16, Utilities.getDate("07/19/2015"), 69.79, "IT3", commentList3, true));
        bookMap.put(4L, new Book(4, "ISBN_539825981", "Programming", 2009, 4, 1, 12, Utilities.getDate("02/22/2016"), 29.29, "IT4", commentList4, true));
        bookMap.put(5L, new Book(5, "ISBN_909872293", "Hackers", 2014, 5, 1, 62, Utilities.getDate("05/05/2016"), 9.99, "IT5", commentList5, true));
        bookMap.put(6L, new Book(6, "ISBN_121325982", "The computer book", 2015, 1, 1, 2, Utilities.getDate("08/12/2015"), 39.49, "IT6", commentList6, true));
        bookMap.put(7L, new Book(7, "ISBN_129820932", "C# in a nut shell", 2002, 2, 1, 92, Utilities.getDate("10/15/2014"), 47.39, "IT7", commentList7, true));
        bookMap.put(8L, new Book(8, "ISBN_129871919", "Headfirst Java", 2009, 5, 1, 32, Utilities.getDate("06/15/2012"), 42.99, "IT8", commentList8, true));

        bookMap.put(9L, new Book(9, "ISBN_981861289", "Lies told me", 2002, 2, 2, 12, Utilities.getDate("01/22/2011"), 35.99, "History1", commentList9, true));
        bookMap.put(10L, new Book(10, "ISBN_989825686", "Salt", 2008, 1, 2, 22, Utilities.getDate("09/15/2015"), 12.99, "History2", commentList10, true));
        bookMap.put(11L, new Book(11, "ISBN_234598612", "The forgotten 500", 2010, 3, 2, 16, Utilities.getDate("05/18/2012"), 9.79, "History3", commentList11, true));
        bookMap.put(12L, new Book(12, "ISBN_539898651", "Economics", 2012, 4, 3, 12, Utilities.getDate("01/10/2015"), 11.29, "Economy1", commentList12, true));
        bookMap.put(13L, new Book(13, "ISBN_109289893", "The moral economy", 2007, 5, 3, 62, Utilities.getDate("08/20/2016"), 19.99, "Economy2", commentList13, true));
        bookMap.put(14L, new Book(14, "ISBN_281398382", "Economy", 2009, 1, 3, 2, Utilities.getDate("07/18/2015"), 29.49, "Economy3", commentList14, true));

        bookMap.put(15L, new Book(15, "ISBN_981861289", "Caesar", 2002, 2, 2, 12, Utilities.getDate("01/22/2011"), 35.99, "Biography1", commentList15, true));
        bookMap.put(16L, new Book(16, "ISBN_989825686", "Washington", 2008, 1, 2, 22, Utilities.getDate("09/15/2015"), 12.99, "Biography2", commentList16, true));
        bookMap.put(17L, new Book(17, "ISBN_234598612", "Benjamin", 2010, 3, 2, 16, Utilities.getDate("05/18/2012"), 9.79, "Biography3", commentList17, true));
        bookMap.put(18L, new Book(18, "ISBN_539898651", "Survival", 2012, 4, 3, 12, Utilities.getDate("01/10/2015"), 11.29, "Fiction1", commentList18, true));
        bookMap.put(19L, new Book(19, "ISBN_109289893", "Terror rising", 2007, 5, 3, 62, Utilities.getDate("08/20/2016"), 19.99, "Fiction2", commentList19, true));
        bookMap.put(20L, new Book(20, "ISBN_281398382", "Aliens", 2009, 1, 3, 2, Utilities.getDate("07/18/2015"), 29.49, "Fiction3", commentList20, true));
        bs.setBookMap(bookMap);
        
        //Inti Categories
        Map<Long, Category> categoryMap = new HashMap<Long, Category>();
        categoryMap.put(1L, new Category(1, "IT", true));
        categoryMap.put(2L, new Category(2, "History", true));
        categoryMap.put(3L, new Category(3, "Economy", true));
        categoryMap.put(4L, new Category(4, "Fiction", true));
        categoryMap.put(5L, new Category(5, "Biography", true));
        bs.setCategoryMap(categoryMap);
        
        //Init COmments
        Map<Long,Comment> commentMap = new HashMap<Long, Comment>();
        commentMap.put(1L, new Comment(1, Utilities.getDate("03/20/2016"), "Very Good", "Nice buy.", 1, 1, true));
        commentMap.put(2L, new Comment(2, Utilities.getDate("04/10/2016"), "Very Good Seller", "Wanna do business again.", 1, 2, true));
        commentMap.put(3L, new Comment(3, Utilities.getDate("12/20/2015"), "Very fast shipping", "Very nice business.", 2, 1, true));
        commentMap.put(4L, new Comment(4, Utilities.getDate("01/08/2016"), "Good buy", "No complaint.", 2, 2, true));
        commentMap.put(5L, new Comment(5, Utilities.getDate("05/05/2016"), "Just try this", "No regret.", 2, 2, true));
        commentMap.put(6L, new Comment(6, Utilities.getDate("04/22/2016"), "Very nice seller", "Wow, nothing to complaint.", 3, 2, true));
        commentMap.put(7L, new Comment(7, Utilities.getDate("03/20/2016"), "Very Good", "Nice buy.", 3, 1, true));
        commentMap.put(8L, new Comment(8, Utilities.getDate("04/10/2016"), "Very Good Seller", "Wanna do business again.", 4, 2, true));
        commentMap.put(9L, new Comment(9, Utilities.getDate("12/20/2015"), "Very fast shipping", "Very nice business.", 4, 1, true));
        commentMap.put(10L, new Comment(10, Utilities.getDate("01/08/2016"), "Good buy", "No complaint.", 5, 2, true));
        commentMap.put(11L, new Comment(11, Utilities.getDate("05/05/2016"), "Just try this", "No regret.", 6, 2, true));
        commentMap.put(12L, new Comment(12, Utilities.getDate("04/22/2016"), "Very nice seller", "Wow, nothing to complaint.", 6, 2, true));
        commentMap.put(13L, new Comment(13, Utilities.getDate("03/20/2016"), "Very Good", "Nice buy.", 7, 1, true));
        commentMap.put(14L, new Comment(14, Utilities.getDate("04/10/2016"), "Very Good Seller", "Wanna do business again.", 7, 2, true));
        commentMap.put(15L, new Comment(15, Utilities.getDate("12/20/2015"), "Very fast shipping", "Very nice business.", 8, 1, true));
        commentMap.put(16L, new Comment(16, Utilities.getDate("01/08/2016"), "Good buy", "No complaint.", 8, 2, true));
        commentMap.put(17L, new Comment(17, Utilities.getDate("05/05/2016"), "Just try this", "No regret.", 8, 2, true));
        commentMap.put(18L, new Comment(18, Utilities.getDate("04/22/2016"), "Very nice seller", "Wow, nothing to complaint.", 9, 2, true));
        commentMap.put(19L, new Comment(19, Utilities.getDate("05/05/2016"), "Just try this", "No regret.", 9, 2, true));
        commentMap.put(20L, new Comment(20, Utilities.getDate("04/22/2016"), "Very nice seller", "Wow, nothing to complaint.", 9, 2, true));
        commentMap.put(21L, new Comment(21, Utilities.getDate("05/05/2016"), "Just try this", "No regret.", 10, 2, true));
        commentMap.put(22L, new Comment(22, Utilities.getDate("04/22/2016"), "Very nice seller", "Wow, nothing to complaint.", 11, 2, true));
        commentMap.put(23L, new Comment(23, Utilities.getDate("03/20/2016"), "Very Good", "Nice buy.", 12, 1, true));
        commentMap.put(24L, new Comment(24, Utilities.getDate("04/10/2016"), "Very Good Seller", "Wanna do business again.", 13, 2, true));
        commentMap.put(25L, new Comment(25, Utilities.getDate("12/20/2015"), "Very fast shipping", "Very nice business.", 13, 1, true));
        commentMap.put(26L, new Comment(26, Utilities.getDate("01/08/2016"), "Good buy", "No complaint.", 14, 2, true));
        commentMap.put(27L, new Comment(27, Utilities.getDate("05/05/2016"), "Just try this", "No regret.", 14, 2, true));
        commentMap.put(28L, new Comment(28, Utilities.getDate("04/22/2016"), "Very nice seller", "Wow, nothing to complaint.", 15, 2, true));
        commentMap.put(29L, new Comment(29, Utilities.getDate("05/05/2016"), "Just try this", "No regret.", 15, 2, true));
        commentMap.put(30L, new Comment(30, Utilities.getDate("04/22/2016"), "Very nice seller", "Wow, nothing to complaint.", 15, 2, true));
        commentMap.put(31L, new Comment(31, Utilities.getDate("05/05/2016"), "Just try this", "No regret.", 16, 2, true));
        commentMap.put(32L, new Comment(32, Utilities.getDate("04/22/2016"), "Very nice seller", "Wow, nothing to complaint.", 17, 2, true));
        commentMap.put(33L, new Comment(33, Utilities.getDate("03/20/2016"), "Very Good", "Nice buy.", 17, 1, true));
        commentMap.put(34L, new Comment(34, Utilities.getDate("04/10/2016"), "Very Good Seller", "Wanna do business again.", 18, 2, true));
        commentMap.put(35L, new Comment(35, Utilities.getDate("12/20/2015"), "Very fast shipping", "Very nice business.", 18, 1, true));
        commentMap.put(36L, new Comment(36, Utilities.getDate("01/08/2016"), "Good buy", "No complaint.", 19, 2, true));
        commentMap.put(37L, new Comment(37, Utilities.getDate("05/05/2016"), "Just try this", "No regret.", 19, 2, true));
        commentMap.put(38L, new Comment(38, Utilities.getDate("04/22/2016"), "Very nice seller", "Wow, nothing to complaint.", 20, 2, true));
        commentMap.put(39L, new Comment(39, Utilities.getDate("05/05/2016"), "Just try this", "No regret.", 20, 2, true));
        commentMap.put(40L, new Comment(40, Utilities.getDate("04/22/2016"), "Very nice seller", "Wow, nothing to complaint.", 20, 2, true));
        bs.setCommentMap(commentMap);
        
        //Init PersonRoels
        
        Map<Long,PersonRole> personRoleMap = new HashMap<Long, PersonRole>();
        personRoleMap = new HashMap<Long, PersonRole>();
        personRoleMap.put(1L, new PersonRole(1L, "Admin", true));
        personRoleMap.put(2L, new PersonRole(2L, "RegisteredUser", true));
        personRoleMap.put(3L, new PersonRole(3L, "Guest", true));
        bs.setPersonRoleMap(personRoleMap);
        
        //Init Authors
        Map<Long,Author> authorMap = new HashMap<Long, Author>();
        authorMap.put(1L, new Author(1, "fauthor1", "lauthor1", Utilities.getDate("03/02/1989"), "author1's biography", new ArrayList<Long>(Arrays.asList(1L, 3L, 5L)), true));
        authorMap.put(2L, new Author(2, "fauthor2", "lauthor2", Utilities.getDate("03/20/1980"), "author2's biography", new ArrayList<Long>(Arrays.asList(5L, 7L)), true));
        authorMap.put(3L, new Author(3, "fauthor3", "lauthor3", Utilities.getDate("01/16/1992"), "author3's biography", new ArrayList<Long>(Arrays.asList(3L, 9L)), true));
        authorMap.put(4L, new Author(4, "fauthor4", "lauthor4", Utilities.getDate("08/08/1970"), "author4's biography", new ArrayList<Long>(Arrays.asList(6L, 8L)), true));
        authorMap.put(5L, new Author(5, "fauthor51", "lauthor5", Utilities.getDate("02/21/1976"), "author5's biography", new ArrayList<Long>(Arrays.asList(2L, 4L)), true));
        bs.setAuthorMap(authorMap);
        
        //Init Orders
        Map<Long,Order> orderMap = new HashMap<Long, Order>();
        bs.setOrderMap(orderMap);
        
        da.saveBookStore(bs);
    }
    
}
