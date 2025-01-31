package com.github.edurbs.jsffinance.repository.infra;

import com.github.edurbs.jsffinance.model.Person;
import com.github.edurbs.jsffinance.repository.PersonRepository;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

public class PersonHibernate implements PersonRepository {
    
    private Session session;
    
    public PersonHibernate(Session session){
        this.session = session;
    }

    @Override
    public List<Person> listAll() {
        return session.createCriteria(Person.class)
                .addOrder(Order.asc("name"))
                .list();   
    }

    @Override
    public Person findById(Long id) {
        return (Person) session.get(Person.class, id);    
    }

    @Override
    public Person save(Person person) {
        return (Person) session.merge(person);

    }

    @Override
    public void delete(Person person) {
       session.delete(person);
    }

}
