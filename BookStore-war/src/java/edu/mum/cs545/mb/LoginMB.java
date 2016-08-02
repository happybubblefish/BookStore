/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.mb;

import edu.mum.cs545.model.Person;
import edu.mum.cs545.service.PersonService;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lin
 */
@Named(value = "loginMB")
@SessionScoped
public class LoginMB implements Serializable {

    private Person person;
    private int count;
    private String username;
    private String password;

    @EJB
    private PersonService personService;

    public LoginMB() {

    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login(String username, String password) {
        if (checkCredentials(username, password)) {
            return "index.jsf";
        }

        return "login.jsf";
    }

    public String logout() {
        FacesContext ctx = FacesContext.getCurrentInstance();

        HttpSession session = (HttpSession) ctx.getExternalContext().getSession(false);
        session.invalidate();

        return "login.jsf";
    }

    public boolean checkCredentials(String usernameInput, String passwordInput) {
        String uname = usernameInput.toLowerCase();
        String pword = passwordInput.toLowerCase();
        List<Person> persons = personService.findAll();

//        int a = 10 / 0;
        
        for (Person person : persons) {
            if (person.getEmail().equals(uname) && person.getPassword().equals(pword)) {
                FacesContext ctx = FacesContext.getCurrentInstance();
                ServletContext sct = (ServletContext) ctx.getExternalContext().getContext();

                HttpSession session = (HttpSession) ctx.getExternalContext().getSession(true);
                session.setAttribute("user", person);
                this.count = (int)sct.getAttribute("userCount");
                this.count++;
                
                sct.setAttribute("userCount", this.count);

                person.setIsLoggedIn(true);
                personService.update(person);

                return true;
            }
        }

        return false;
    }

}
