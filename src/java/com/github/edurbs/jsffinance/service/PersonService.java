package com.github.edurbs.jsffinance.service;

import com.github.edurbs.jsffinance.model.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonService {
    private static Map<Long, Person> people = new HashMap<>();
    
    static {
        people.put(1L, new Person(1L, "João da Silva"));
        people.put(2L, new Person(2L, "Manuel Santos"));
        people.put(3L, new Person(3L, "José Aparecido"));
    }
    
    public List<Person> listAll(){
        List<Person> listPeople = new ArrayList<>();
        listPeople.addAll(PersonService.people.values());
        return listPeople;
    }
    
    public Person findById(Long id){
        return people.get(id);
    }
}
