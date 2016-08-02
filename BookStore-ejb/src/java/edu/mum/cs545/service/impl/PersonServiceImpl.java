/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.service.impl;

import edu.mum.cs545.dao.PersonDao;
import edu.mum.cs545.model.Person;
import edu.mum.cs545.service.PersonService;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Lin
 */
@Stateless
public class PersonServiceImpl implements PersonService {

    @EJB
    private PersonDao personDao;
    
    @Override
    public void save(Person person) {
        personDao.save(person);
    }

    @Override
    public void delete(long id) {
        personDao.delete(id);
    }

    @Override
    public Person findOne(long id) {
        return personDao.findOne(id);
    }

    @Override
    public Person update(Person person) {
        return personDao.update(person);
    }

    @Override
    public List<Person> findAll() {
        return personDao.findAll();
    }

    @Override
    public Map<Long, Person> getPersonMap() {
        return personDao.getMap();
    }
}
