/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.sigamasweb.usuario;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.FlowEvent;
import uy.edu.ort.sigamas.seguridad.entidades.Usuario;
import uy.edu.ort.sigamas.seguridad.usuario.UsuarioBeanLocal;
import uy.edu.ort.sigamas.seguridad.usuario.excepciones.UsuarioExistenteException;
import uy.edu.ort.sigamas.sigamasweb.login.BeanSesionUsuario;
import uy.edu.ort.sigamas.sigamasweb.utils.UtilsMensajes;

/**
 *
 * @author Pikachuss
 */
@ManagedBean(name = "beanUsuario")
@ViewScoped
public class BeanUsuario implements Serializable {

    @EJB
    private UsuarioBeanLocal usuarioSessionBean;

    private String viejaContraseña;
    private String nuevaContraseña;

    @ManagedProperty(value = "#{beanSesionUsuario}")
    private BeanSesionUsuario beanSesionUsuario;

    public void setBeanSesionUsuario(BeanSesionUsuario beanSesionUsuario) {
        this.beanSesionUsuario = beanSesionUsuario;
    }

    /**
     * Creates a new instance of BeanUsuario
     */
    public BeanUsuario() {
    }

    @PostConstruct
    public void init() {
        usuario = new Usuario();
    }
    private Usuario usuario;

// <editor-fold defaultstate="collapsed" desc="Gets y Sets">
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the nuevaContraseña
     */
    public String getNuevaContraseña() {
        return nuevaContraseña;
    }

    /**
     * @param nuevaContraseña the nuevaContraseña to set
     */
    public void setNuevaContraseña(String nuevaContraseña) {
        this.nuevaContraseña = nuevaContraseña;
    }

    /**
     * @return the viejaContraseña
     */
    public String getViejaContraseña() {
        return viejaContraseña;
    }

    /**
     * @param viejaContraseña the viejaContraseña to set
     */
    public void setViejaContraseña(String viejaContraseña) {
        this.viejaContraseña = viejaContraseña;
    }

// </editor-fold>
    public boolean crearUsuario() {
        try {
            Usuario nuevoUsuario = usuarioSessionBean.crearUsuario(usuario, null);
            if (nuevoUsuario != null) {
                return true;
            }
            return false;
        } catch (UsuarioExistenteException u) {
            UtilsMensajes.mostrarMensajeError("Error de creación", "Ya existe un usuario con este nombre de usuario");
            return false;
        }
    }

    public String progresoCreacion(FlowEvent event) {

        if ("ingreso".equals(event.getOldStep())) {
            try {
                usuarioSessionBean.verificarUsuario(null);
            } catch (UsuarioExistenteException exp) {
                UtilsMensajes.mostrarMensajeError("Error", "Ya existe un usuario con este nombre de usuario");
                return event.getOldStep();
            }
            return event.getNewStep();
        }
        return event.getNewStep();
    }

    public String modificarUsuario() {
        beanSesionUsuario.setUsuarioLoggeado(usuarioSessionBean.modificarUsuario(beanSesionUsuario.getUsuarioLoggeado()));
        return "homeClient";
    }

    public String cambiarContraseña() {
        if (viejaContraseña == null ? beanSesionUsuario.getUsuarioLoggeado().getClaveUsuario() == null : viejaContraseña.equals(beanSesionUsuario.getUsuarioLoggeado().getClaveUsuario())){
            usuarioSessionBean.cambiarContraseña(beanSesionUsuario.getUsuarioLoggeado(), nuevaContraseña);
            return "";
        }
        return "";
    }

}
