package com.github.edurbs.jsffinance.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class Post implements Serializable{
    
    private String type;
    private String person;
    private String description;
    private BigDecimal amount;
    private Date dueDate;
    private Boolean paid;
    private Date payDate;
    
}
