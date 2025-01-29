package com.github.edurbs.jsffinance.domain;

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
public class BusinessLine {
    
    @EqualsAndHashCode.Include
    private Long id;
    
    private String Description;

}
