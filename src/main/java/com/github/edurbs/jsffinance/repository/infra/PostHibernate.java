package com.github.edurbs.jsffinance.repository.infra;

import com.github.edurbs.jsffinance.model.Person;
import com.github.edurbs.jsffinance.model.Post;
import com.github.edurbs.jsffinance.repository.PostRepository;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class PostHibernate implements PostRepository{
    
    private Session session;
    
    public PostHibernate(Session session){
        this.session = session;
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<Post> listAll() {
        return session.createCriteria(Post.class)
                .addOrder(Order.asc("dueDate"))
                .addOrder(Order.asc("person"))
                .addOrder(Order.asc("description"))
                .addOrder(Order.asc("amount"))
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

    @Override
    public Post samePost(Post post) {
        @SuppressWarnings("unchecked")
        List<Post> posts = session.createCriteria(Post.class)
                .add(Restrictions.eq("type", post.getType()))
                .add(Restrictions.eq("person", post.getPerson()))
                .add(Restrictions.ilike("description", post.getDescription()))
                .add(Restrictions.eq("amount", post.getAmount()))
                .add(Restrictions.eq("dueDate", post.getDueDate()))
                .list();
        if(posts.isEmpty()){
            return null;
        }
        return posts.get(0);
    }
    
    @SuppressWarnings("unchecked")
    public boolean isPersonInUse(Person person){
        List<Post> posts = session.createCriteria(Post.class)
                .add(Restrictions.eq("person", person))
                .list();
        if(posts.isEmpty()){
            return false;
        }
        return true;
        
    }

}
