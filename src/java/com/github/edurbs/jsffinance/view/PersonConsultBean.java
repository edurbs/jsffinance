package com.github.edurbs.jsffinance.view;

import com.github.edurbs.jsffinance.model.Person;
import com.github.edurbs.jsffinance.persistence.RepositoryFactory;
import com.github.edurbs.jsffinance.repository.PersonRepository;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import lombok.Getter;

@ManagedBean
@Getter
public class PersonConsultBean {
    
    private List<Person> people;
    private RepositoryFactory repositoryFactory = new RepositoryFactory();
    
    @PostConstruct
    public void init(){
        PersonRepository personRepository = repositoryFactory.getPersonRepository();
        people = personRepository.listAll();
    }
}
