package com.github.edurbs.jsffinance.view.validator;

import java.time.DayOfWeek;
import java.time.LocalDate;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.github.edurbs.jsffinance.view.util.FacesUtil;

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
                    FacesUtil.getMessageI18n("invalid_date"), 
                    FacesUtil.getMessageI18n("date_must_be_in_business_day"));
            throw new ValidatorException(msg);
        }
    }

    private boolean isWeekend(LocalDate localdate) {
        return localdate.getDayOfWeek() == DayOfWeek.SUNDAY || localdate.getDayOfWeek() == DayOfWeek.SATURDAY;
    }
}
