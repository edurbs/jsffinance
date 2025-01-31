package com.github.edurbs.jsffinance.service;

import com.github.edurbs.jsffinance.model.Person;
import com.github.edurbs.jsffinance.repository.PersonRepository;
import com.github.edurbs.jsffinance.service.exception.BusinessException;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PersonUseCase {
    
    private final PersonRepository personRepository;
    
    public Person save(Person person){
        return personRepository.save(person);
    }
    
    public List<Person> listAll(){
        return personRepository.listAll();
    }

    public void delete(Person person) throws BusinessException{        
        personRepository.delete(person);        
    }
    

}
