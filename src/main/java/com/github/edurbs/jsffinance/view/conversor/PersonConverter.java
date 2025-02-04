package com.github.edurbs.jsffinance.view.conversor;

import com.github.edurbs.jsffinance.model.Person;
import com.github.edurbs.jsffinance.persistence.RepositoryFactory;
import com.github.edurbs.jsffinance.repository.PersonRepository;
import com.github.edurbs.jsffinance.view.util.FacesUtil;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass=Person.class)
public class PersonConverter implements Converter{

    private RepositoryFactory repositoryFactory = new RepositoryFactory();  

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value==null || value.isEmpty()){
            return null;
        }        
        PersonRepository personRepository = repositoryFactory.getPersonRepository();
        Long id = Long.valueOf(value);
        Person person = personRepository.findById(id);
        if(person==null){
            FacesUtil.addMessage(FacesMessage.SEVERITY_ERROR, FacesUtil.getMessageI18n("person_not_found"));            
        }
        return person;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value==null){
            return "";
        }
        Person person = (Person) value;
        if(person.getId()==null){
            return "";
        }
        return person.getId().toString();
    }

}
