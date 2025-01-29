package com.github.edurbs.jsffinance.view.validator;

import com.sun.faces.util.MessageFactory;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("ConditionalRequiredValidator")
public class ConditionalRequiredValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Boolean isPaid = (Boolean) component.getAttributes().get("isPaid");
        if(isPaid == null) { 
            return;
        }
        if(value==null && isPaid){
            Object label = MessageFactory.getLabel(context, component);
            String errorDescription = label + " is required.";
            FacesMessage messsage = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    errorDescription, errorDescription);
            throw new ValidatorException(messsage);
        }
    }

}
