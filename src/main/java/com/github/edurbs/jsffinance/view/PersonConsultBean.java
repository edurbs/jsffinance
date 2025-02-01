package com.github.edurbs.jsffinance.view;

import com.github.edurbs.jsffinance.model.Person;
import com.github.edurbs.jsffinance.persistence.RepositoryFactory;
import com.github.edurbs.jsffinance.repository.PersonRepository;
import com.github.edurbs.jsffinance.service.PersonUseCase;
import com.github.edurbs.jsffinance.service.exception.BusinessException;
import com.github.edurbs.jsffinance.view.util.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
@Getter
@Setter
public class PersonConsultBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private List<Person> people;
    private RepositoryFactory repositoryFactory = new RepositoryFactory();
    private Person selectedPerson;
    
    @PostConstruct
    public void init(){
        people = getPersonUseCase().listAll();
    }
    
    public void delete(){
        try {
            getPersonUseCase().delete(selectedPerson);            
            init();
            FacesUtil.addMessage(FacesMessage.SEVERITY_INFO, "Person deleted!");
        } catch (BusinessException e) {
            FacesUtil.addMessage(FacesMessage.SEVERITY_ERROR, e.getMessage());
        }
    }
    
    private PersonUseCase getPersonUseCase() {
        PersonRepository personRepository = repositoryFactory.getPersonRepository();
        return new PersonUseCase(personRepository);
    }
}
