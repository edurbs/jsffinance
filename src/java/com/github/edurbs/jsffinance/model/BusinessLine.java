package com.github.edurbs.jsffinance.model;

import java.io.Serializable;
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
public class BusinessLine implements Serializable {
    
    @EqualsAndHashCode.Include
    private Long id;
    
    private String Description;

}
