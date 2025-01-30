package com.github.edurbs.jsffinance.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
    
    private static final SessionFactory SESSION_FACTORY;
    
    static {
        try {
            Configuration configuration = new Configuration();
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).buildServiceRegistry();
            
            SESSION_FACTORY = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }        
    }
    
    public static Session getSession(){
        return SESSION_FACTORY.openSession();
    }

}
