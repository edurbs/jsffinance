package com.github.edurbs.jsffinance.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Post implements Serializable{
    
    @EqualsAndHashCode.Include
    private Long id;
    
    private PostType type;
    private Person person;
    private String description;
    private BigDecimal amount;
    private LocalDate dueDate;
    private boolean paid;
    private LocalDate payDate;
    
}
