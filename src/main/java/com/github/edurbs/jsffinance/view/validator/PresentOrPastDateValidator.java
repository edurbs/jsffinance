package com.github.edurbs.jsffinance.view.validator;

import com.github.edurbs.jsffinance.view.util.FacesUtil;
import com.sun.faces.util.MessageFactory;
import java.time.LocalDate;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("PresentOrPastDateValidator")
public class PresentOrPastDateValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if(value==null){
            return;
        }
        LocalDate localDate = (LocalDate) value;
        if(localDate.isAfter(LocalDate.now())){
            Object label = MessageFactory.getLabel(context, component);
            String errorDescription = label + FacesUtil.getMessageI18n("cannot_be_a_future_date");
            FacesMessage messsage = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    errorDescription, errorDescription);
            throw new ValidatorException(messsage);
        }
        
    }

}
