package com.github.edurbs.jsffinance.view;

import com.github.edurbs.jsffinance.model.BusinessLine;
import com.github.edurbs.jsffinance.model.Person;
import com.github.edurbs.jsffinance.model.PersonType;
import com.github.edurbs.jsffinance.persistence.RepositoryFactory;
import com.github.edurbs.jsffinance.repository.BusinessLineRepository;
import com.github.edurbs.jsffinance.repository.PersonRepository;
import com.github.edurbs.jsffinance.service.BusinessLineUseCase;
import com.github.edurbs.jsffinance.service.PersonUseCase;
import com.github.edurbs.jsffinance.view.util.FacesUtil;
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
    
    private RepositoryFactory repositoryFactory = new RepositoryFactory();
    private List<Person> people;
    private Person person;

    @PostConstruct
    public void init(){
        people = new ArrayList<>();
        person = new Person();
    }
    
    public void add(){
        
        PersonRepository personRepository = repositoryFactory.getPersonRepository();
        PersonUseCase personUseCase = new PersonUseCase(personRepository);
        personUseCase.save(person);
        
        FacesUtil.addMessage(FacesMessage.SEVERITY_INFO, "Posted with sucess!");
        person = new Person();
    }

    public void setPerson(Person person) throws CloneNotSupportedException{
        if(person==null){
            return;
        }
        this.person = (Person) person.clone();
    }
    
    public PersonType[] getPersonTypes(){
        return PersonType.values();
    }
    
    public List<BusinessLine> getBusinessLines(){
        BusinessLineRepository businessLineRepository = repositoryFactory.getBusinessLineRepository();
        BusinessLineUseCase businessLineUseCase = new BusinessLineUseCase(businessLineRepository);        
        return new BusinessLineUseCase(businessLineRepository).listAll();
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
