package com.github.edurbs.jsffinance.persistence;

import com.github.edurbs.jsffinance.model.Person;
import java.util.List;
import org.hibernate.Session;

public class HibernateTest {
    
    public static void main(String[] args){
        Session session = HibernateUtil.getSession();
        
        List<Person> people = session.createCriteria(Person.class).list();
        
        for (Person person : people) {
            System.out.println(person.getId() + " " + person.getName());
        }
        
        session.close();
    }

}
