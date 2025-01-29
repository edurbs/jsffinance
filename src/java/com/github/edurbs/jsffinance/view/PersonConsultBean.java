package com.github.edurbs.jsffinance.view;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import lombok.Getter;

@ManagedBean
@Getter
public class PersonConsultBean {
    
    private List<String> people = new ArrayList<>();
    
    @PostConstruct
    public void init(){
        for (int i = 0; i < 20; i++) {
            people.add("");
        }
    }
}
