package com.github.edurbs.jsffinance.repository;

import com.github.edurbs.jsffinance.model.Post;
import java.util.List;

public interface PostRepository {

    public List<Post> listAll();
    public Post findById(Long id);
    public Post save(Post post);  
    public void delete(Post post);
    public Post equals(Post post);
    
}
