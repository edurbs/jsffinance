package com.github.edurbs.jsffinance.view.conversor;

import com.github.edurbs.jsffinance.model.Person;
import com.github.edurbs.jsffinance.persistence.RepositoryFactory;
import com.github.edurbs.jsffinance.repository.PersonRepository;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass=Person.class)
public class PersonConverter implements Converter{
    private RepositoryFactory repositoryFactory = new RepositoryFactory();  
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value==null){
            return null;
        }
        
        try {            
            PersonRepository personRepository = repositoryFactory.getPersonRepository();        
            return personRepository.findById(Long.valueOf(value));                        
        } catch (NumberFormatException numberFormatException) {            
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value==null){
            return null;
        }
        return ((Person) value).getId().toString();
    }

}
