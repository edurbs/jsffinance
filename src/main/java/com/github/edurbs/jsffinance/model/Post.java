package com.github.edurbs.jsffinance.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "post")
public class Post implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue
    private Long id;
    
    @Enumerated(EnumType.STRING)
    @Column(name="type")
    private PostType type;
    
    @ManyToOne
    @JoinColumn(name="person_id")
    private Person person;
    private String description;
    private BigDecimal amount;
    
    //@Convert(converter = LocalDatePersistenceConverter.class)
    @Column(name = "due_date")
    private Date dueDate;
    
    private boolean paid;
    
    //@Convert(converter = LocalDatePersistenceConverter.class)
    @Column(name = "pay_date")
    private Date payDate;
    
}
