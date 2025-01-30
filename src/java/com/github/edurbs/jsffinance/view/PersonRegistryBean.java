package com.github.edurbs.jsffinance.view;

import com.github.edurbs.jsffinance.domain.BusinessLine;
import com.github.edurbs.jsffinance.domain.Person;
import com.github.edurbs.jsffinance.domain.PersonType;
import com.github.edurbs.jsffinance.service.BusinessLineService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
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
        person = new Person();
    }
    
    public PersonType[] getPersonTypes(){
        return PersonType.values();
    }
    
    public List<BusinessLine> getBusinessLines(){
        return new BusinessLineService().listAll();
    }

}
