/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.mb;

import edu.mum.cs545.mail.MailService;
import edu.mum.cs545.model.Book;
import edu.mum.cs545.model.Order;
import edu.mum.cs545.model.Person;
import edu.mum.cs545.service.BookService;
import edu.mum.cs545.service.OrderService;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lin
 */
@Named(value = "orderMB")
@SessionScoped
public class OrderMB implements Serializable {

    @EJB
    private OrderService orderService;

    @EJB
    private BookService bookService;

    private List<Book> booksList;
    private Map<Long, Integer> shoppingCart;
    private String totalPrice;

    public OrderMB() {
        booksList = new ArrayList<Book>();
    }

    public List<Book> getBooksList() {
        return booksList;
    }

    public void setBooksList(List<Book> booksList) {
        this.booksList = booksList;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String addToCart(Book bk, int count) {
        int stockCount = bk.getStockCount();

        if (stockCount == 0) {

        }

        booksList.add(bk);
        Person user = getCurrentUser();
        if (user == null) {
            return "login.jsf";
        }

        Map<Long, Integer> shoppingCart = user.getShoppingCart();

        if (shoppingCart.containsKey(bk.getBid())) {
            int preCount = shoppingCart.get(bk.getBid());
            preCount += count;
            shoppingCart.put(bk.getBid(), preCount);
        } else {
            shoppingCart.put(bk.getBid(), count);
        }
        List<Long> bIdList = new ArrayList<Long>(shoppingCart.keySet());
        this.booksList = getBookListFromBIdList(bIdList);

        this.totalPrice = calTotalPrice();

        return "shoppingCart.jsf";
    }

    public String placeOrder() {
        Person user = getCurrentUser();

        Order order = new Order();
        long oId = generateOrderId();
        order.setoId(oId);
        order.setPlaceDate(new Date());
        order.setpId(user.getPid());
        order.setCartBooks(new HashMap<Long, Integer>(user.getShoppingCart()));
        order.setFinalPrice(Double.parseDouble(calTotalPrice()));
        order.setStatus(true);

        //This will update the database data.
        orderService.save(order);

        Map<Long, Order> orderMap = (HashMap<Long, Order>) user.getOrderMap();
        //This will only update particular person's orderMap.
        orderMap.put(oId, order);
        user.setOrderMap(orderMap);
        user.getShoppingCartMap().put(oId, new HashMap<Long, Integer>(user.getShoppingCart()));

        user.getShoppingCart().clear();
        String orderid = Long.toString(oId);
        Date d = new Date();
        SimpleDateFormat form = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
        String purchaseDate = form.format(d);

        String Message = "Dear Customer " + user.getFname() + " " + user.getLname()
                + " your orderNumber is " + orderid + " " + " Purchase Date " + purchaseDate
                + " Thank you for Shoping with us";
        SendEmail(user.getEmail(), Message);

        return "confirmationPage.jsf";
    }

    public void SendEmail(String email, String message) {
        String statusMessage = "Message Sent";
        try {
            MailService.sendMessage(email, message);
        } catch (MessagingException ex) {
            statusMessage = ex.getMessage();
        }
    }

    public String delete(Book bk) {
        Person user = getCurrentUser();
        Map<Long, Integer> shoppingCart = user.getShoppingCart();
        int preCount = shoppingCart.get(bk.getBid());
        preCount--;
        if (preCount == 0) {
            shoppingCart.remove(bk.getBid());
        } else {
            shoppingCart.put(bk.getBid(), preCount);
        }

        List<Long> bIdList = new ArrayList<Long>(shoppingCart.keySet());
        this.booksList = getBookListFromBIdList(bIdList);

        return "shoppingCart.jsf";
    }

    public String continueShopping() {
        bookService.findAll();

        return "viewBooks.jsf";
    }

    public String calTotalPrice() {
        this.totalPrice = "0.00";
        double sum = 0;
        Person user = getCurrentUser();
        if (user != null) {
            Map<Long, Integer> shoppingCart = user.getShoppingCart();
            List<Long> bIdList = new ArrayList<Long>(shoppingCart.keySet());

            for (Long id : bIdList) {
                int totalCount = shoppingCart.get(id);
                Book bk = bookService.findOne(id);
                sum += bk.getPrice() * totalCount;
            }
            this.totalPrice = String.format("%.2f", sum);
        }

        return this.totalPrice;
    }

    public String goToCart() {
        Person user = getCurrentUser();

        if (user != null) {
            Map<Long, Integer> shoppingCart = user.getShoppingCart();
            List<Long> bIdList = new ArrayList<Long>(shoppingCart.keySet());
            this.booksList = getBookListFromBIdList(bIdList);
        } else {
            booksList = new ArrayList<Book>();
        }

        this.totalPrice = calTotalPrice();

        return "shoppingCart.jsf";
    }

    public int getOrderedCount(Book bk) {
        Person user = getCurrentUser();
        if (user != null) {
            Map<Long, Integer> userShoppingCart = user.getShoppingCart();
            if (userShoppingCart.size() == 0) {
                return this.shoppingCart.get(bk.getBid());
            }
            return userShoppingCart.get(bk.getBid());
        }

        return 0;
    }

    public String goToOrderDetails(Order order) {
        this.shoppingCart = order.getCartBooks();
        List<Long> bIdList = new ArrayList<Long>(this.shoppingCart.keySet());
        this.booksList = getBookListFromBIdList(bIdList);

        return "orderBookList.jsf";
    }

    public String backToOrderList() {
        return "orderList.jsf";
    }

    public String backToPersonDetails() {
        return "personDetails.jsf";
    }

    public String clearAll() {
        Person user = getCurrentUser();
        user.setShoppingCart(new HashMap<Long, Integer>());
        this.booksList = new ArrayList<Book>();
        this.totalPrice = "0.00";

        return "shoppingCart.jsf";
    }

    private long generateOrderId() {
        return orderService.getOrderMap().values().size() + 1;
    }

    public String getUserEmail() {
        return getCurrentUser().getEmail();
    }

    private Person getCurrentUser() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) ctx.getExternalContext().getSession(false);
        Person user = (Person) session.getAttribute("user");

        return user;
    }

    private List<Book> getBookListFromBIdList(List<Long> bIdList) {
        List<Book> res = new ArrayList<Book>();

        for (Long i : bIdList) {
            res.add(bookService.findOne(i));
        }

        return res;
    }
}
