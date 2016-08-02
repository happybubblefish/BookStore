/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.mb;

import edu.mum.cs545.model.Order;
import edu.mum.cs545.model.Person;
import edu.mum.cs545.service.PersonService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Lin
 */
@Named(value = "personMB")
@SessionScoped
public class PersonMB implements Serializable {

    @EJB
    private PersonService personService;
    
    private Person person;
    private List<Order> orderList;

    /**
     * Creates a new instance of RegisterMB
     */
    public PersonMB() {
        person = new Person();
        orderList = new ArrayList<Order>();
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<Person> findAllPersons() {
        return personService.findAll();
    }

    public String register() {
        Person p = new Person();
        p.setPid(generatedId());
        p.setEmail(this.person.getEmail());
        p.setPassword(this.person.getPassword());
        p.setFname(this.person.getFname());
        p.setLname(this.person.getLname());
        p.setGender(this.person.getGender());
        p.setDOB(this.person.getDOB());
        p.setPhone(this.person.getPhone());
        p.setOrderMap(new HashMap<Long, Order>());
        p.setShoppingCart(new HashMap<Long, Integer>());
        p.setShoppingCartMap(new HashMap<Long, Map<Long, Integer>>());
        p.setRoleId(2);
        p.setStatus(true);

        personService.save(p);
        this.person = new Person();

        return "login.jsf";
    }

    public String getRole(long roleId) {
        if (roleId == 1) {
            return "Admin";
        } else {
            return "Registered user";
        }
    }

    public String preEdit(Person p) {
        this.person = p;

        return "editPerson.jsf";
    }

    public String update() {
        personService.update(this.person);
        this.person = new Person();

        return "viewPersons.jsf";
    }

    public String delete(Person p) {
        personService.delete(p.getPid());

        return "viewPersons.jsf";
    }

    public String updateCancel() {
        this.person = new Person();
        return "viewPersons.jsf";
    }

    public String registerCancel() {
        this.person = new Person();
        return "login.jsf";
    }
    
    public String goToPersonDetails(Person p){
        this.person = p;
        return "personDetails.jsf";
    }
    
    public String listPastOrders(Person person){
        Map<Long, Order> orderMap = person.getOrderMap();
        this.orderList = new ArrayList<Order>(orderMap.values());
        
        return "orderList.jsf";
    }
    
    
    private long generatedId() {
        return personService.getPersonMap().values().size() + 1;
    }
}
