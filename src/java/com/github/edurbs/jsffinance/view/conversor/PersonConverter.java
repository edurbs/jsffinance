package com.github.edurbs.jsffinance.view.conversor;

import com.github.edurbs.jsffinance.domain.Person;
import com.github.edurbs.jsffinance.service.PersonService;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

//@FacesConverter(forClass=Person.class)
public class PersonConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value==null){
            return null;
        }
        
        try {
            return new PersonService().findById(Integer.valueOf(value));
        } catch (NumberFormatException numberFormatException) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value==null){
            return null;
        }
        String r = ((Person) value).getId().toString();
        return r;
    }

}
