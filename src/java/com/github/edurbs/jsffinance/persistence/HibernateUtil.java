package com.github.edurbs.jsffinance.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    
    private static final SessionFactory SESSION_FACTORY;
    
    static {
        try {
            SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }        
    }
    
    public static Session getSession(){
        return SESSION_FACTORY.openSession();
    }

}
