package com.github.edurbs.jsffinance.service;

import com.github.edurbs.jsffinance.model.BusinessLine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BusinessLineService {
    
    private static Map<Long, BusinessLine> businesslines = new HashMap<>();
    
    static {
        businesslines.put(1L, new BusinessLine(1L, "Food"));
        businesslines.put(2L, new BusinessLine(2L, "Education"));
        businesslines.put(3L, new BusinessLine(3L, "Technology"));
    }
    
    public List<BusinessLine> listAll(){
        List<BusinessLine> list = new ArrayList<>();
        list.addAll(businesslines.values());
        return list;
    }
    
    public BusinessLine findById(Long id){
        return businesslines.get(id);
    }

}
