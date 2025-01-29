package com.github.edurbs.jsffinance.view;

import com.github.edurbs.jsffinance.domain.Post;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
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
    }
    
    public void clean(){
        post = new Post();
    }
    
}
