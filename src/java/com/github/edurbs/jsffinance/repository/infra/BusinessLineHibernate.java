package com.github.edurbs.jsffinance.repository.infra;

import com.github.edurbs.jsffinance.model.BusinessLine;
import com.github.edurbs.jsffinance.repository.BusinessLineRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

@RequiredArgsConstructor
public class BusinessLineHibernate implements BusinessLineRepository{
    
    private final Session session;

    @Override
    public List<BusinessLine> getAll() {        
        return session.createCriteria(BusinessLine.class)
                .addOrder(Order.asc("description"))
                .list();
    }

}
