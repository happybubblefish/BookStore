/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.validator;

import edu.mum.cs545.mb.PersonMB;
import edu.mum.cs545.model.Person;
import edu.mum.cs545.utils.Utilities;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;


/**
 *
 * @author Lin
 */
@Named(value="uniqueEmailValidator")
@RequestScoped
public class UniqueEmailValidator implements Validator {
    
    @Inject
    private PersonMB personMB;
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        List<Person> persons = personMB.findAllPersons();
        if(persons != null){
            for(Person p : persons){
                if(p.getEmail().equalsIgnoreCase(value.toString()) && 
                        p.getPid() != personMB.getPerson().getPid()){
                    FacesMessage msg = new FacesMessage("Duplicate email", Utilities.getResourceBundleString("msgs", "emailError"));
                    msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                    throw new ValidatorException(msg);
                }
            }
        }
    }

    
    
}
