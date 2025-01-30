package com.github.edurbs.jsffinance.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    
    private static final SessionFactory SESSION_FACTORY;
    
    static {
        try {
            //Configuration configuration = new Configuration();
            
            //ServiceRegistryBuilder registryBuilder = new ServiceRegistryBuilder();
             //       .applySettings(configuration.getProperties()).buildServiceRegistry();
            
            //SESSION_FACTORY = configuration.buildSessionFactory(serviceRegistry);
//              SESSION_FACTORY = configuration.buildSessionFactory();
            // Observe que eu estou passando o caminho onde esta o meu arquivo de propriedades
            //ServiceRegistry serviceRegistry = registryBuilder.loadProperties("hibernate.properties").buildServiceRegistry();  

            // Agora eu estou passando o caminho do arquivo de configuração.
            //SESSION_FACTORY = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory(serviceRegistry); 
            
//            Configuration cfg = new Configuration()
//                .addClass(com.github.edurbs.jsffinance.model.Person.class)
//                .addClass(com.github.edurbs.jsffinance.model.Post.class)                
//                .setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
//                .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect")
//                .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:55000/jsffinance?useSSL=false")
//                .setProperty("hibernate.connection.username", "root")
//                .setProperty("hibernate.connection.password", "senha")
//                .setProperty("show_sql", "true")
//                .setProperty("format_sql", "true");           
//            
//            
//            SESSION_FACTORY = cfg.buildSessionFactory();
            
            
            
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
