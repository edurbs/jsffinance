package com.github.edurbs.jsffinance.view.conversor;

import com.github.edurbs.jsffinance.domain.BusinessLine;
import com.github.edurbs.jsffinance.service.BusinessLineService;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = BusinessLine.class)
public class BusinessLineConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value==null){
            return null;
        }
        try{
            Long id = Long.valueOf(value);
            return new BusinessLineService().findById(id);
        }catch (NumberFormatException e){
            return null;
        }        
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value==null){
            return "";
        }
        BusinessLine bs = (BusinessLine) value;
        return bs.getId().toString();
    }

}
