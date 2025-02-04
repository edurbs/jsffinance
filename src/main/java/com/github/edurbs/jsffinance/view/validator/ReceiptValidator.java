package com.github.edurbs.jsffinance.view.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;
import com.sun.faces.util.MessageFactory;

import com.github.edurbs.jsffinance.view.util.FacesUtil;

@FacesValidator("ReceiptValidator")
public class ReceiptValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Part file = (Part) value;
        if(file==null){
            return;
        }
        String contentType = file.getContentType();
        if(!"application/pdf".equals(contentType)){                
            Object label = MessageFactory.getLabel(context, component);
            String errorDescription = label + " " + FacesUtil.getMessageI18n("file_is_not_valid");
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorDescription, errorDescription);
            throw new ValidatorException(msg);
        }
    }

}
