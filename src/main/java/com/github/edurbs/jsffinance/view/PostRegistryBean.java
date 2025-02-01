package com.github.edurbs.jsffinance.view;

import com.github.edurbs.jsffinance.model.Person;
import com.github.edurbs.jsffinance.model.Post;
import com.github.edurbs.jsffinance.model.PostType;
import com.github.edurbs.jsffinance.persistence.RepositoryFactory;
import com.github.edurbs.jsffinance.repository.PersonRepository;
import com.github.edurbs.jsffinance.repository.PostRepository;
import com.github.edurbs.jsffinance.service.PostUseCase;
import com.github.edurbs.jsffinance.service.exception.BusinessException;
import com.github.edurbs.jsffinance.view.util.FacesUtil;
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
        PostRepository postRepository = repositoryFactory.getPostRepository();
        PostUseCase postUseCase = new PostUseCase(postRepository);        
        try {
            postUseCase.save(post);                
            FacesUtil.addMessage(FacesMessage.SEVERITY_INFO, "Posted with success!");
            post = new Post();            
        } catch (BusinessException e) {
            FacesUtil.addMessage(FacesMessage.SEVERITY_ERROR, e.getMessage());
        }
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
