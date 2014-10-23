/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.sigamasweb.login;
//COMENTARIO

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import uy.edu.ort.sigamas.seguridad.entidades.Cuenta;
import uy.edu.ort.sigamas.seguridad.login.LoginBeanLocal;
import uy.edu.ort.sigamas.seguridad.login.excepciones.ClaveInvalidaException;
import uy.edu.ort.sigamas.seguridad.login.excepciones.UsuarioInvalidoException;
import uy.edu.ort.sigamas.sigamasweb.utils.UtilsMensajes;

/**
 *
 * @author Mattahari
 */
@ManagedBean(name = "beanLogin")
@ViewScoped
public class BeanLogin implements Serializable {

    @EJB
    private LoginBeanLocal loginSessionBean;
    
    @ManagedProperty(value="#{beanSesionUsuario}")
    private BeanSesionUsuario beanSesionUsuario;

    public void setBeanSesionUsuario(BeanSesionUsuario beanSesionUsuario) {
        this.beanSesionUsuario = beanSesionUsuario;
    }
    
    /**
     * Creates a new instance of BeanLogin
     */
    public BeanLogin() {
        this.cuentas = new ArrayList<>();
    }

    @PostConstruct
    public void init() {
        this.cuentas = new ArrayList();
    }

    private String nombreUsuario;
    private String claveUsuario;
    private String cuenta;
    private List<SelectItem> usuarios;
    private List<Cuenta> cuentas;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClaveUsuario() {
        return claveUsuario;
    }

    public void setClaveUsuario(String claveUsuario) {
        this.claveUsuario = claveUsuario;
    }

    /**
     * @return the cuenta
     */
    public String getCuenta() {
        return cuenta;
    }

    /**
     * @param cuenta the cuenta to set
     */
    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * @return the cuentas
     */
    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    /**
     * @return the usuarios
     */
    public List<SelectItem> getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(List<SelectItem> usuarios) {
        this.usuarios = usuarios;
    }

    public boolean validarUsuario() {
        try {
            loginSessionBean.verificarUsuario(nombreUsuario, claveUsuario);
            return true;
        } catch (UsuarioInvalidoException ex) {
            UtilsMensajes.mostrarMensajeError("Error", "Nombre de usuario inexistente.");
            return false;
        } catch (ClaveInvalidaException ex) {
            UtilsMensajes.mostrarMensajeError("Error", "Contraseña erronea.");
            return false;
        }
    }

    public String ingresar() {
        try {
            if (validarUsuario()) {                
                beanSesionUsuario.setUsuarioLoggeado(loginSessionBean.obtenerUsuario(nombreUsuario));
                return "HomeClient";
            }
            return "";
        } catch (UsuarioInvalidoException exp) { // Hacer clase de excepcion
            UtilsMensajes.mostrarMensajeError("Error inesperado", exp.getMessage());
            return "";
        }
    }   

}
