/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.service;

import edu.mum.cs545.model.PersonRole;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Lin
 */
public interface PersonRoleService {

    void save(PersonRole role);

    void delete(long id);

    PersonRole findOne(long id);

    PersonRole update(PersonRole role);

    List<PersonRole> findAll();
    
    Map<Long, PersonRole> getPersonRoleMap();
}
