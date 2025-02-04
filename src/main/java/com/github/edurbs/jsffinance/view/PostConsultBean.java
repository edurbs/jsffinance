package com.github.edurbs.jsffinance.view;

import com.github.edurbs.jsffinance.model.Post;
import com.github.edurbs.jsffinance.persistence.RepositoryFactory;
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
        PostRepository postRepository = repositoryFactory.getPostRepository();
        postings = postRepository.listAll();
    }
    
    public void delete(){        
        PostRepository postRepository = repositoryFactory.getPostRepository();
        PostUseCase postUseCase = new PostUseCase(postRepository);        
        try {
            postUseCase.delete(selectedPost);
            init();
            FacesUtil.addMessage(FacesMessage.SEVERITY_INFO, FacesUtil.getMessageI18n("entry_deleted"));
        } catch (BusinessException e) {
            FacesUtil.addMessage(FacesMessage.SEVERITY_ERROR, e.getMessage());
        }        
    }
    
}
