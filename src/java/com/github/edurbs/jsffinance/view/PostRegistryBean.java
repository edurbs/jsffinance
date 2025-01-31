package com.github.edurbs.jsffinance.view;

import com.github.edurbs.jsffinance.model.Person;
import com.github.edurbs.jsffinance.model.Post;
import com.github.edurbs.jsffinance.model.PostType;
import com.github.edurbs.jsffinance.persistence.RepositoryFactory;
import com.github.edurbs.jsffinance.repository.PersonRepository;
import com.github.edurbs.jsffinance.repository.PostRepository;
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

@ManagedBean
@ViewScoped
@Getter
@Setter
public class PostRegistryBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private RepositoryFactory repositoryFactory = new RepositoryFactory();
    private List<Post> posts = new ArrayList<>();
    private List<Person> people;
    private Post post = new Post();
    
    @PostConstruct
    public void init(){
        PersonRepository personRepository = repositoryFactory.getPersonRepository();        
        people = personRepository.listAll();
    }
    
    public void add(){
        PostRepository postRepository= repositoryFactory.getPostRepository();
        postRepository.save(post);
                
        String msg = "Posted with success!";      
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
