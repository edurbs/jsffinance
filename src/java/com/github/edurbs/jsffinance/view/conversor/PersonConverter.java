package com.github.edurbs.jsffinance.view.conversor;

import com.github.edurbs.jsffinance.model.Person;
import com.github.edurbs.jsffinance.view.util.FacesUtil;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.hibernate.Session;

@FacesConverter(forClass=Person.class)
public class PersonConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value==null){
            return null;
        }
        
        try {            
            Session session = (Session) FacesUtil.getRequestAttribute("session");
            Person person = (Person) session.get(Person.class, Long.valueOf(value));                        
            return person;            
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
