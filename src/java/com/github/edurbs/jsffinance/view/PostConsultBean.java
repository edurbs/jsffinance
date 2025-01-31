package com.github.edurbs.jsffinance.view;

import com.github.edurbs.jsffinance.model.Post;
import com.github.edurbs.jsffinance.persistence.HibernateUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

@ManagedBean
@Getter
public class PostConsultBean implements Serializable {
    
    private List<Post> postings = new ArrayList<>();    
    
    @PostConstruct
    public void init(){
        Session session = HibernateUtil.getSession();
        
        postings = session.createCriteria(Post.class)
                .addOrder(Order.asc("dueDate"))
                .list();
        
        session.close();
                
    }
    
}
