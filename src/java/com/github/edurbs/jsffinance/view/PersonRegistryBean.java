package com.github.edurbs.jsffinance.view;

import com.github.edurbs.jsffinance.domain.BusinessLine;
import com.github.edurbs.jsffinance.domain.Person;
import com.github.edurbs.jsffinance.domain.PersonType;
import com.github.edurbs.jsffinance.service.BusinessLineService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
@ViewScoped
@Getter
@Setter

public class PersonRegistryBean {
    
    private List<Person> people;
    private Person person;

    @PostConstruct
    public void init(){
        people = new ArrayList<>();
        person = new Person();
    }
    
    public void add(){
    people.add(person);
        String msg = "Posted with sucess! Business Line: "+ person.getBusinessLine().getDescription();
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        person = new Person();
    }
    
    public PersonType[] getPersonTypes(){
        return PersonType.values();
    }
    
    public List<BusinessLine> getBusinessLines(){
        return new BusinessLineService().listAll();
    }

}
