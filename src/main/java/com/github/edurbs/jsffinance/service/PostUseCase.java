package com.github.edurbs.jsffinance.service;

import com.github.edurbs.jsffinance.model.Post;
import com.github.edurbs.jsffinance.repository.PostRepository;
import com.github.edurbs.jsffinance.service.exception.BusinessException;
import com.github.edurbs.jsffinance.view.util.FacesUtil;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PostUseCase {
    
    private final PostRepository postRepository;   

    public void delete(Post post) throws BusinessException{
        if(post.isPaid()){
            throw new BusinessException(FacesUtil.getMessageI18n("entry_paid_cant_be_deleted"));
        }        
        postRepository.delete(post);
    }
    
    public void save(Post post) throws BusinessException {
        if(existsPostEqual(post)){
            throw new BusinessException(FacesUtil.getMessageI18n("existing_entry"));            
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
