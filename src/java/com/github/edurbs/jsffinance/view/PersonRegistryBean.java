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
import javax.faces.event.ValueChangeEvent;
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
        String msg = "Posted with sucess!" ;
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
    
    public void isIndividual(boolean individual){
        person.setPersonType(PersonType.INDIVIDUAL);
    }
    
    public boolean isIndividual(){
        if(person.getPersonType()==null){
            return false;
        }
        return person.getPersonType().equals(PersonType.INDIVIDUAL);
    }
    
    public boolean isCompany(){
        if(person.getPersonType()==null){
            return false;
        }
        return person.getPersonType().equals(PersonType.COMPANY);
    }
    
    public void isCompany(boolean company){
        person.setPersonType(PersonType.COMPANY);
    }
    
    public void onPersonTypeChange(ValueChangeEvent event){
        PersonType personType = (PersonType) event.getNewValue();
        person.setPersonType(personType);
        
        if(PersonType.INDIVIDUAL.equals(personType)){            
            person.setBusinessLine(null);
        }else if(PersonType.COMPANY.equals(personType)){            
            person.setBirthday(null);
        }
        FacesContext.getCurrentInstance().renderResponse();
    }

}
