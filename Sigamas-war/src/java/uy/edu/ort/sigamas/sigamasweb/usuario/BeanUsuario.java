/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.sigamasweb.usuario;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;
import uy.edu.ort.sigamas.seguridad.entidades.Usuario;
import uy.edu.ort.sigamas.seguridad.usuario.UsuarioBeanLocal;
import uy.edu.ort.sigamas.seguridad.usuario.excepciones.UsuarioExistenteException;
import uy.edu.ort.sigamas.sigamasweb.utils.UtilsMensajes;

/**
 *
 * @author Pikachuss
 */
@ManagedBean(name = "beanUsuario")
@ViewScoped
public class BeanUsuario implements Serializable{

    @EJB
    private UsuarioBeanLocal usuarioSessionBean;

    /**
     * Creates a new instance of BeanUsuario
     */
    public BeanUsuario() {
    }

    private String nombreUsuario;
    private String claveUsuario;
    private String nombre;
    private String apellidos;
    private String emailUsuario;
    private Date fechaNacimiento;
    private String profesion;
    private String sexo;
    private String telefono;
    private List<Usuario> usuarios;

// <editor-fold defaultstate="collapsed" desc="Gets y Sets">
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the emailUsuario
     */
    public String getEmailUsuario() {
        return emailUsuario;
    }

    /**
     * @param emailUsuario the emailUsuario to set
     */
    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    /**
     * @return the fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the profesion
     */
    public String getProfesion() {
        return profesion;
    }

    /**
     * @param profesion the profesion to set
     */
    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

// </editor-fold>
    public boolean crearUsuario() {
        try {
            Usuario nuevoUsuario = usuarioSessionBean.crearUsuario(getNombreUsuario(), getClaveUsuario(), getNombre(), getApellidos(), getEmailUsuario(), getFechaNacimiento(), getProfesion(), getSexo(), getTelefono());
            if (nuevoUsuario != null) {
                usuarios.add(nuevoUsuario);
                return true;
            }
            return false;
        } catch (UsuarioExistenteException u) {
            UtilsMensajes.mostrarMensajeError("Error de creación", "Ya existe un usuario con este nombre de usuario");
            return false;
        }
    }

    public void editarUsuario() {
        //RequestContext.getCurrentInstance().execute("dlg_usuario.show();");
    }

    public String paginaCrearUsuario() {        
        return "CrearUsuario";
    }

    public String progresoCreacion(FlowEvent event) {

        return event.getNewStep();
    }
}
