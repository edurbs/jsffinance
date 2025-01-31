package com.github.edurbs.jsffinance.repository;

import com.github.edurbs.jsffinance.model.BusinessLine;
import java.util.List;

public interface BusinessLineRepository {

    public List<BusinessLine> getAll();
    public BusinessLine findById(Long id);
}
