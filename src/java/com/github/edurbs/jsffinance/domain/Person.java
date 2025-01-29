package com.github.edurbs.jsffinance.domain;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Person implements Serializable{

    @EqualsAndHashCode.Include
    private Long id;
    
    private String name;
    private PersonType personType;
    private String email;
    private LocalDate birthday;
    private BusinessLine businessLine;
}
