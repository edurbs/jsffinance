package com.github.edurbs.jsffinance.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
public class Post implements Serializable{
    
    @EqualsAndHashCode.Include
    private Long id;
    
    private String type;
    private Person person;
    private String description;
    private BigDecimal amount;
    private LocalDate dueDate;
    private Boolean paid;
    private LocalDate payDate;
    
}
