/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.dao.impl;

import edu.mum.cs545.dao.PersonDao;
import edu.mum.cs545.model.Person;
import edu.mum.cs545.model.PersonRole;
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
public class PersonDaoImpl implements PersonDao {

    private Map<Long, Person> personMap;
    private List<PersonRole> personRoles;

    public PersonDaoImpl() {
        personMap = getMap();
    }

    @Override
    public void save(Person person) {
        personMap = getMap();
        long pId = person.getPid();
        personMap.put(pId, person);
        setPersonMap();
    }

    @Override
    public void delete(long id) {
        personMap = getMap();
        Person p = personMap.get(id);

        if (p != null) {
            p.setStatus(false);
            personMap.put(id, p);
            setPersonMap();
        }
    }

    @Override
    public Person findOne(long id) {
        personMap = getMap();
        Person p = personMap.get(id);

        if (p != null && p.isStatus()) {
            return p;
        }

        return null;
    }

    @Override
    public Person update(Person person) {
        personMap = getMap();
        long pId = person.getPid();
        personMap.put(pId, person);
        setPersonMap();

        return person;
    }

    @Override
    public List<Person> findAll() {
        personMap = getMap();
        List<Person> persons = new ArrayList<Person>(personMap.values());
        List<Person> res = new ArrayList<Person>();

        for (Person bk : persons) {
            if (bk.isStatus()) {
                res.add(bk);
            }
        }

        return res;
    }

    public List<PersonRole> getPersonRoles() {
        return personRoles;
    }

    public Map<Long, Person> getMap() {
        ServletContext sct = Utilities.getServletContext();
        return (HashMap<Long, Person>) sct.getAttribute("personMap");
    }

    private void setPersonMap() {
        ServletContext sct = Utilities.getServletContext();
        sct.setAttribute("personMap", personMap);
    }
}
