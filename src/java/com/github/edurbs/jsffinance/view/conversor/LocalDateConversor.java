package com.github.edurbs.jsffinance.view.conversor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("LocalDateConversor")
public class LocalDateConversor implements Converter {
    
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    @Override    
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value==null || value.isBlank()) {
            return null;
        }
        try {
            return LocalDate.parse(value, formatter);
        } catch (DateTimeParseException e) {
            FacesMessage msg = new FacesMessage("Invalid date", "Date must be in dd/MM/yyyy format");
            throw new ConverterException(msg);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value==null) {
            return "";
        }
        LocalDate localDate = (LocalDate) value;
        return formatter.format(localDate).toString();
    }
    
}
