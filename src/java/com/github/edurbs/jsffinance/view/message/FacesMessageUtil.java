package com.github.edurbs.jsffinance.view.message;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesMessageUtil {

    public static void add(FacesMessage.Severity severity, String message){
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(severity, message, message));
    }
}
