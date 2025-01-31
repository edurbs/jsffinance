package com.github.edurbs.jsffinance.service;

import com.github.edurbs.jsffinance.model.Person;
import com.github.edurbs.jsffinance.repository.PersonRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PersonUseCase {
    
    private final PersonRepository personRepository;
    
    public Person save(Person person){
        return personRepository.save(person);
    }
    

}
