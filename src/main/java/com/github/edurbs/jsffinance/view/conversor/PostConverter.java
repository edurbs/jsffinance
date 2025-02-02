package com.github.edurbs.jsffinance.view.conversor;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.github.edurbs.jsffinance.model.Post;
import com.github.edurbs.jsffinance.persistence.RepositoryFactory;
import com.github.edurbs.jsffinance.repository.PostRepository;
import com.github.edurbs.jsffinance.view.util.FacesUtil;

@FacesConverter(forClass = Post.class)
public class PostConverter implements Converter {

    private RepositoryFactory repositoryFactory = new RepositoryFactory();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        PostRepository postRepository = repositoryFactory.getPostRepository();
        if(value==null || value.isEmpty()){
            return null;
        }
        Post post = postRepository.findById(Long.valueOf(value));
        if(post==null){
            String message = "Post does not exists";
            FacesUtil.addMessage(FacesMessage.SEVERITY_ERROR, message);
            //throw new ConverterException(message);
            return null;
        }
        return post;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value==null){
            return "";
        }
        Post post = (Post) value;
        if(post.getId()==null){
            return "";
        }
        Long id = post.getId();
        return Long.toString(id);

    }

}
