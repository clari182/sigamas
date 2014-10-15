/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.sigamasweb.login;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.context.RequestContext;
import uy.edu.ort.sigamas.seguridad.entidades.Usuario;
import uy.edu.ort.sigamas.seguridad.usuario.UsuarioBean;

/**
 *
 * @author Pikachuss
 */
@ManagedBean(name = "beanUsuario")
@RequestScoped
public class BeanUsuario {

    @EJB
    private UsuarioBean usuarioBeanLocal;
    private String nombreUsuario;
    private String claveUsuario;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String emailUsuario;
    private Date fechaNacimiento;
    private String profesion;
    private String sexo;
    private String telefono;
    private List<Usuario> usuarios;

    /**
     * Creates a new instance of BeanUsuario
     */
    public BeanUsuario() {
    }

    public boolean crearUsuario() {
        return usuarioBeanLocal.crearUsuario(nombreUsuario, claveUsuario, primerNombre, primerApellido, segundoNombre, segundoApellido, emailUsuario, fechaNacimiento, profesion, sexo, telefono);
    }

    /**
     * @return the usuarios
     */
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void editarUsuario() {
        RequestContext.getCurrentInstance().execute("dlg_usuario.show();");
    }
}
