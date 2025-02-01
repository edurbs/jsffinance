package com.github.edurbs.jsffinance.service;

import com.github.edurbs.jsffinance.model.BusinessLine;
import com.github.edurbs.jsffinance.repository.BusinessLineRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BusinessLineUseCase {   
    
    private final BusinessLineRepository businessLineRepository;
    
    public List<BusinessLine> listAll(){
        return businessLineRepository.getAll();
    }

}
