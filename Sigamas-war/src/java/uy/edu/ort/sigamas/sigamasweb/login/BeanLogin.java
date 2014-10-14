/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.sigamasweb.login;
//COMENTARIO
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
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
@ManagedBean (name="beanLogin")
@RequestScoped
public class BeanLogin {

    @EJB
    private LoginBeanLocal loginSessionBean;

    /**
     * Creates a new instance of BeanLogin
     */
    public BeanLogin() {
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
                if (obtenerCuentas()) {
                    return "HomeClient";
                }
            }
            return "";
        } catch (Exception exp) { // Hacer clase de excepcion
            UtilsMensajes.mostrarMensajeError("Error", exp.getMessage());
            return "";
        }
    }

    public boolean obtenerCuentas() {      
        try {
            this.cuentas = loginSessionBean.obtenerCuentas(nombreUsuario);            
            return true;
        } catch (UsuarioInvalidoException ex) {
            UtilsMensajes.mostrarMensajeError("Error", "Nombre de usuario inexistente.");
            return false;
        } catch (ClaveInvalidaException ex) {
            UtilsMensajes.mostrarMensajeError("Error", "Contraseña errónea.");
            return false;
        }
    }
    
    public boolean obtenerCuentasSU(){
        return true;
    }


}
