package com.github.edurbs.jsffinance.view;

import java.io.Serializable;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.github.edurbs.jsffinance.view.util.FacesUtil;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ManagedBean
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SecurityBean implements Serializable {

    private String username;
    private String password;

    public String login(){
        HttpServletRequest request = getRequest();
        try{
            request.login(username, password);
            return "Home?faces-redirect=true";
        } catch (ServletException e){
            FacesUtil.addMessage(FacesMessage.SEVERITY_ERROR, FacesUtil.getMessageI18n("username_password_does_not_match"));
            return null;
        }
    }

    public String logout() throws ServletException{
        getRequest().logout();
        return "Login?faces-redirect=true";
    }

    private HttpServletRequest getRequest(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        return (HttpServletRequest) externalContext.getRequest();
    }
}
