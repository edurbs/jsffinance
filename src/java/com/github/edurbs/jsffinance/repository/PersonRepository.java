package com.github.edurbs.jsffinance.repository;

import com.github.edurbs.jsffinance.model.Person;
import java.util.List;

public interface PersonRepository {

    public List<Person> listAll();
    public Person findById(Long id);
    public Person save(Person person);
    public void delete(Person person);
    
}
