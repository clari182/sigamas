/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.sigamasbackofficeweb.login;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import uy.edu.ort.sigamas.seguridad.login.LoginBeanLocal;

/**
 *
 * @author Pikachuss
 */
@Named(value = "beanLogin")
@Dependent
public class BeanLogin {

    private String nombreUsuario;
    private String claveUsuario;
    private LoginBeanLocal loginBeanLocal;
    /**
     * Creates a new instance of BeanLogin
     */
    public BeanLogin() {
    }

    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @return the claveUsuario
     */
    public String getClaveUsuario() {
        return claveUsuario;
    }

    /**
     * @param claveUsuario the claveUsuario to set
     */
    public void setClaveUsuario(String claveUsuario) {
        this.claveUsuario = claveUsuario;
    }

    /**
     * @return the loginBeanLocal
     */
    public LoginBeanLocal getLoginBeanLocal() {
        return loginBeanLocal;
    }

    /**
     * @param loginBeanLocal the loginBeanLocal to set
     */
    public void setLoginBeanLocal(LoginBeanLocal loginBeanLocal) {
        this.loginBeanLocal = loginBeanLocal;
    }
        
    public void ingresar(){
        
    }

}
