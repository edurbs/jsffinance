package com.github.edurbs.jsffinance.view.filter;

import com.github.edurbs.jsffinance.persistence.HibernateUtil;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import org.hibernate.Session;
import org.hibernate.Transaction;

@WebFilter(servletNames={"Faces Servlet"}) // from web.xml
public class HibernateSessionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            request.setAttribute("session", session);
            chain.doFilter(request, response);        
            transaction.commit();
        } catch (Exception e) {
            if(transaction!=null){
                transaction.rollback();
            }
        }finally{
            session.close();
        }
    }

}