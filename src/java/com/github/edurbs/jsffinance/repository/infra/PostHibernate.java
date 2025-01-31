package com.github.edurbs.jsffinance.repository.infra;

import com.github.edurbs.jsffinance.model.Post;
import com.github.edurbs.jsffinance.repository.PostRepository;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

public class PostHibernate implements PostRepository{
    
    private Session session;
    
    public PostHibernate(Session session){
        this.session = session;
    }


    @Override
    public List<Post> listAll() {
        return session.createCriteria(Post.class)
                .addOrder(Order.asc("dueDate"))
                .list();   
    }

    @Override
    public Post findById(Long id) {
        return (Post) session.get(Post.class, id);  
    }

    @Override
    public Post save(Post post) {
        return (Post) session.merge(post);
    }

    @Override
    public void delete(Post post) {
        session.delete(post);
    }

}
