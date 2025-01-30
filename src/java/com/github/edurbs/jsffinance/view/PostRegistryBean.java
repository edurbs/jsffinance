package com.github.edurbs.jsffinance.view;

import com.github.edurbs.jsffinance.model.Person;
import com.github.edurbs.jsffinance.model.Post;
import com.github.edurbs.jsffinance.model.PostType;
import com.github.edurbs.jsffinance.persistence.HibernateUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

@ManagedBean
@ViewScoped
@Getter
@Setter
public class PostRegistryBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private List<Post> posts = new ArrayList<>();
    private List<Person> people;
    private Post post = new Post();
    
    @PostConstruct
    public void init(){
        Session session = HibernateUtil.getSession();
        
        people = session.createCriteria(Person.class)
                .addOrder(Order.asc("name"))
                .list();
        
        session.close();
    }
    
    public void add(){                
        posts.add(post);        
        String msg = "Posted with success! Person name: " +post.getPerson().getName();        
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
        post = new Post();
    }
    
    
    public PostType[] getPostTypes(){
        return PostType.values();
    }
    
    public void onIsPaidChange(ValueChangeEvent event){
        post.setPaid((Boolean) event.getNewValue());
        post.setPayDate(null);
        FacesContext.getCurrentInstance().renderResponse();
    }
    
    
}
