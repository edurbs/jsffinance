package com.github.edurbs.jsffinance.view.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class FacesUtil {

    public static void addMessage(FacesMessage.Severity severity, String message){
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(severity, message, message));
    }
    
    public static Object getRequestAttribute(String name){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        return request.getAttribute(name);
    }

    public static String getMessageI18n(String key){
        FacesContext context = FacesContext.getCurrentInstance();
        return context.getApplication().getResourceBundle(context, "msg").getString(key);
    }
}
