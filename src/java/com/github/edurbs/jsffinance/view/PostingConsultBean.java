package com.github.edurbs.jsffinance.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import lombok.Getter;

@ManagedBean
@Getter
public class PostingConsultBean implements Serializable {
    
    private List<String> postings = new ArrayList<String>();    
    
    public PostingConsultBean(){
        for (int i = 0; i < 20; i++) {
            postings.add("");
        }        
    }   
    
}
