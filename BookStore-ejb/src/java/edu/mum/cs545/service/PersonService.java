/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.service;

import edu.mum.cs545.model.Person;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Lin
 */
public interface PersonService {

    void save(Person person);

    void delete(long id);

    Person findOne(long id);

    Person update(Person person);

    List<Person> findAll();
    
    Map<Long, Person> getPersonMap();
}
