package com.github.edurbs.jsffinance.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Entity
@Table(name = "person")
public class Person implements Serializable{

    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue
    private Long id;    
    private String name;
    
    @Enumerated(EnumType.STRING)
    private PersonType personType;
    
    private String email;
    private LocalDate birthday;
    
//    @ManyToOne
//    @JoinColumn(name = "business_line_id")
    private String businessLine;
    
    public Person(Long id, String name){
        this.id = id;
        this.name = name;
    }
}
