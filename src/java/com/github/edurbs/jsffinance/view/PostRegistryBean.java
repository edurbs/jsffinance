package com.github.edurbs.jsffinance.view;

import com.github.edurbs.jsffinance.domain.Post;
import com.github.edurbs.jsffinance.model.PostType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
@ViewScoped
@Getter
@Setter
public class PostRegistryBean implements Serializable{
    
    private List<Post> posts;
    private Post post;
    
    public PostRegistryBean(){
        posts = new ArrayList<>();
        post = new Post();
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
    
}
