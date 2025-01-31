package com.github.edurbs.jsffinance.view;

import com.github.edurbs.jsffinance.model.Post;
import com.github.edurbs.jsffinance.persistence.RepositoryFactory;
import com.github.edurbs.jsffinance.repository.PostRepository;
import com.github.edurbs.jsffinance.view.util.FacesUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
@Getter
@Setter
public class PostConsultBean implements Serializable {
    private RepositoryFactory repositoryFactory = new RepositoryFactory();
    private List<Post> postings = new ArrayList<>();    
    private Post selectedPost;
    
    @PostConstruct
    public void init(){
        PostRepository postRepository= repositoryFactory.getPostRepository();        
        postings = postRepository.listAll();
    }
    
    public void delete(){
        if(selectedPost.isPaid()){
            FacesUtil.add(FacesMessage.SEVERITY_ERROR, "Post is paid, can't be deleted.");
            return;
        }
        PostRepository postRepository= repositoryFactory.getPostRepository();
        postRepository.delete(selectedPost);        
        String msg = "Post deleted!";
        init();
        FacesUtil.add(FacesMessage.SEVERITY_INFO, msg);
    }
    
}
