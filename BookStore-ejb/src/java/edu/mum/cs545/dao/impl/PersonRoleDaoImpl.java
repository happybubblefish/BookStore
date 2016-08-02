/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.dao.impl;

import edu.mum.cs545.dao.PersonRoleDao;
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
public class PersonRoleDaoImpl implements PersonRoleDao {

    private Map<Long, PersonRole> personRoleMap;

    public PersonRoleDaoImpl() {
        personRoleMap = getMap();
    }

    @Override
    public void save(PersonRole personRole) {
        personRoleMap = getMap();
        long id = personRole.getRoleId();
        personRoleMap.put(id, personRole);
        setPersonRoleMap();
    }

    @Override
    public void delete(long id) {
        personRoleMap = getMap();
        PersonRole personRole = personRoleMap.get(id);

        if (personRole != null && personRole.isStatus()) {
            personRole.setStatus(false);
            personRoleMap.put(id, personRole);
            setPersonRoleMap();
        }
    }

    @Override
    public PersonRole findOne(long id) {
        personRoleMap = getMap();
        PersonRole personRole = personRoleMap.get(id);

        if (personRole != null && personRole.isStatus()) {
            return personRole;
        }

        return null;
    }

    @Override
    public PersonRole update(PersonRole personRole) {
        personRoleMap = getMap();
        long id = personRole.getRoleId();
        personRoleMap.put(id, personRole);
        setPersonRoleMap();

        return personRole;
    }

    @Override
    public List<PersonRole> findAll() {
        personRoleMap = getMap();
        List<PersonRole> roles = new ArrayList<PersonRole>(personRoleMap.values());
        List<PersonRole> res = new ArrayList<PersonRole>();

        for (PersonRole pr : roles) {
            if (pr.isStatus()) {
                res.add(pr);
            }
        }

        return res;
    }

    public Map<Long, PersonRole> getMap() {
        ServletContext sct = Utilities.getServletContext();
        return (HashMap<Long, PersonRole>) sct.getAttribute("personRoleMap");
    }

    private void setPersonRoleMap() {
        ServletContext sct = Utilities.getServletContext();
        sct.setAttribute("personRoleMap", personRoleMap);
    }
}
