package com.github.edurbs.jsffinance.view;

import com.github.edurbs.jsffinance.domain.Post;
import com.github.edurbs.jsffinance.model.Person;
import com.github.edurbs.jsffinance.model.PostType;
import com.github.edurbs.jsffinance.service.PersonService;
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

@ManagedBean
@ViewScoped
@Getter
@Setter
public class PostRegistryBean {
    
    private List<Post> posts;
    private List<Person> people;
    private Post post;
    
    @PostConstruct
    public void init(){
        posts = new ArrayList<>();
        post = new Post();
        people = new PersonService().listAll();
    }
    
    public void add(){        
        posts.add(post);
        clean();        
        String msg = "Posted with success!";        
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
    }
    
    public void clean(){
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
