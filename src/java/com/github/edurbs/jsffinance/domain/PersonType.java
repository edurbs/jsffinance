package com.github.edurbs.jsffinance.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PersonType {

    INDIVIDUAL("Individual"),
    COMPANY("Company");
    
    private String description;
            
}
