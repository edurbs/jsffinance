package com.github.edurbs.jsffinance.view;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import lombok.Getter;

@ManagedBean
@Getter
public class PostingConsultBean {
    
    private List<String> postings = new ArrayList<>();
    
    @PostConstruct
    public void init(){
        for (Integer i = 0; i < 20; i++) {
            postings.add(i.toString());
        }
    }
    
}
