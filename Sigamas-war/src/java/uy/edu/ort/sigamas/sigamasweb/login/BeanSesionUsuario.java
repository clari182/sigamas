/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.sigamasweb.login;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import uy.edu.ort.sigamas.seguridad.entidades.Cuenta;
import uy.edu.ort.sigamas.seguridad.entidades.Usuario;

/**
 *
 * @author anieves
 */
@Named(value = "beanSesionUsuario")
@SessionScoped
public class BeanSesionUsuario implements Serializable {

    /**
     * Creates a new instance of BeanSesionUsuario
     */
    public BeanSesionUsuario() {
    }

    private Usuario usuarioLoggeado;
    private Cuenta cuentaActual;

    public Usuario getUsuarioLoggeado() {
        return usuarioLoggeado;
    }

    /**
     * Establece el usuario loggeado en la sesion. Si tiene cuentas, utiliza la
     * primera de la lista como la cuenta por defecto
     *
     * @param usuarioLoggeado
     */
    public void setUsuarioLoggeado(Usuario usuarioLoggeado) {
        this.usuarioLoggeado = usuarioLoggeado;
        if (usuarioLoggeado.getCuentaList() != null && !usuarioLoggeado.getCuentaList().isEmpty()) {
            this.cuentaActual = usuarioLoggeado.getCuentaList().get(0);
        }
    }

    public Cuenta getCuentaActual() {
        return cuentaActual;
    }

    public void setCuentaActual(Cuenta cuentaActual) {
        this.cuentaActual = cuentaActual;
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "Login";
    }

}
