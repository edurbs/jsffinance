package com.github.edurbs.jsffinance.service;

import com.github.edurbs.jsffinance.model.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonService {
    private static Map<Integer, Person> people = new HashMap<>();
    
    static {
        people.put(1, new Person(1L, "João da Silva"));
        people.put(2, new Person(2L, "Manuel Santos"));
        people.put(3, new Person(3L, "José Aparecido"));
    }
    
    public List<Person> listAll(){
        List<Person> listPeople = new ArrayList<>();
        listPeople.addAll(PersonService.people.values());
        return listPeople;
    }
    
    public Person findById(Integer id){
        return people.get(id);
    }
}
