package com.github.edurbs.jsffinance.service;

import com.github.edurbs.jsffinance.model.Post;
import com.github.edurbs.jsffinance.repository.PostRepository;
import com.github.edurbs.jsffinance.service.exception.BusinessException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PostUseCase {
    
    private final PostRepository postRepository;   

    public void delete(Post post) throws BusinessException{
        if(post.isPaid()){
            throw new BusinessException("Paid post can't be deleted!");
        }        
        postRepository.delete(post);
    }
    
    public void save(Post post) throws BusinessException {
        if(existsPostEqual(post)){
            throw new BusinessException("Post already exists.");            
        }
        postRepository.save(post);
    }

    private boolean existsPostEqual(Post post) {
        Post postEqual = postRepository.samePost(post);
        if(postEqual!=null && !postEqual.equals(post)){
            return true;
        }        
        return false;
    }
    
    
}
