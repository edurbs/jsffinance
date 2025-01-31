package com.github.edurbs.jsffinance.view;

import com.github.edurbs.jsffinance.model.Post;
import com.github.edurbs.jsffinance.view.util.FacesUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

@ManagedBean
@Getter
@Setter
public class PostConsultBean implements Serializable {
    
    private List<Post> postings = new ArrayList<>();    
    private Post selectedPost;
    
    @PostConstruct
    public void init(){
        Session session = (Session) FacesUtil.getRequestAttribute("session");
        
        postings = session.createCriteria(Post.class)
                .addOrder(Order.asc("dueDate"))
                .list();
    }
    
    public void delete(){
        if(selectedPost.isPaid()){
            FacesUtil.add(FacesMessage.SEVERITY_ERROR, "Post is paid, can't be deleted.");
            return;
        }
        Session session = (Session) FacesUtil.getRequestAttribute("session");
        session.delete(selectedPost);        
        String msg = "Post deleted!";
        init();
        FacesUtil.add(FacesMessage.SEVERITY_INFO, msg);
    }
    
}
