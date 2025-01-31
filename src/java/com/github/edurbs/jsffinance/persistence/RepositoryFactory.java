package com.github.edurbs.jsffinance.persistence;

import com.github.edurbs.jsffinance.repository.BusinessLineRepository;
import com.github.edurbs.jsffinance.repository.PersonRepository;
import com.github.edurbs.jsffinance.repository.PostRepository;
import com.github.edurbs.jsffinance.repository.infra.BusinessLineHibernate;
import com.github.edurbs.jsffinance.repository.infra.PersonHibernate;
import com.github.edurbs.jsffinance.repository.infra.PostHibernate;
import com.github.edurbs.jsffinance.view.util.FacesUtil;
import java.io.Serializable;
import org.hibernate.Session;

public class RepositoryFactory implements Serializable {
    public PersonRepository getPersonRepository(){
        return new PersonHibernate(getSession());
    }
    
    private Session getSession(){
        return (Session) FacesUtil.getRequestAttribute("session");
    }
    
    public PostRepository getPostRepository(){
        return new PostHibernate(getSession());
    }
    
    public BusinessLineRepository getBusinessLineRepository(){
        return new BusinessLineHibernate(getSession());
    }
}
