/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.service.impl;

import edu.mum.cs545.dao.PersonRoleDao;
import edu.mum.cs545.model.PersonRole;
import edu.mum.cs545.service.PersonRoleService;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Lin
 */
@Stateless
public class PersonRoleServiceImpl implements PersonRoleService {

    @EJB
    private PersonRoleDao personRoleDao;
    
    @Override
    public void save(PersonRole role) {
        personRoleDao.save(role);
    }

    @Override
    public void delete(long id) {
        personRoleDao.delete(id);
    }

    @Override
    public PersonRole findOne(long id) {
        return personRoleDao.findOne(id);
    }

    @Override
    public PersonRole update(PersonRole role) {
        return personRoleDao.update(role);
    }

    @Override
    public List<PersonRole> findAll() {
        return personRoleDao.findAll();
    }

    @Override
    public Map<Long, PersonRole> getPersonRoleMap() {
        return personRoleDao.getMap();
    }
}
