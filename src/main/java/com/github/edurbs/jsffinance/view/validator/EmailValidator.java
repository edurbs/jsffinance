package com.github.edurbs.jsffinance.view.validator;

import com.github.edurbs.jsffinance.view.util.FacesUtil;
import com.sun.faces.util.MessageFactory;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("EmailValidator")
public class EmailValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if(value==null){
            return;
        }
        if(isNotValid(value.toString())){
            Object label = MessageFactory.getLabel(context, component);
            String errorDescription = label + " " + FacesUtil.getMessageI18n("is_not_valid");
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorDescription, errorDescription);
            throw new ValidatorException(msg);
            
        }
    }
    
    private boolean isNotValid(String email){
        String pattern = "^[a-zA-Z0-9].[a-zA-Z0-9\\._%\\+\\-]{0,63}@[a-zA-Z0-9\\.\\-]+\\.[a-zA-Z]{2,30}$";
        return !email.matches(pattern);
    }

}
