
package com.github.edurbs.jsffinance.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum PostType {
    INCOME("Income"),
    EXPENSE("Expense");
    
    private String description;
}
