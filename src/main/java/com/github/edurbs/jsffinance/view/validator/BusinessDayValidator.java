package com.github.edurbs.jsffinance.view.validator;

import java.time.DayOfWeek;
import java.time.LocalDate;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("BusinessDayValidator")
public class BusinessDayValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value == null) {
            return;
        }
        LocalDate localdate = (LocalDate) value;
        if (isWeekend(localdate)) {
            FacesMessage msg = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "Invalid date", 
                    "Date must be in a business day");
            throw new ValidatorException(msg);
        }
    }

    private boolean isWeekend(LocalDate localdate) {
        return localdate.getDayOfWeek() == DayOfWeek.SUNDAY || localdate.getDayOfWeek() == DayOfWeek.SATURDAY;
    }
}
