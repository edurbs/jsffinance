package com.github.edurbs.jsffinance.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Person implements Serializable{

    @EqualsAndHashCode.Include
    private Long id;
    
    private String name;
}
