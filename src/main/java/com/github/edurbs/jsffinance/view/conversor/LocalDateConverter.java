package com.github.edurbs.jsffinance.view.conversor;

import com.sun.faces.util.MessageFactory;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("LocalDateConverter")
public class LocalDateConverter implements Converter {
    
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    @Override    
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value==null || value.isEmpty()) {
            return null;
        }
        try {
            return LocalDate.parse(value, formatter);
        } catch (DateTimeParseException e) {
            Object label = MessageFactory.getLabel(context, component);
            String errorDescription = label + " is required.";
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid date", label + " must be in dd/MM/yyyy format");
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
