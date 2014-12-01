/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.sigamasweb.notificacion;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import uy.edu.ort.sigamas.seguridad.entidades.Notificacion;
import uy.edu.ort.sigamas.seguridad.entidades.TipoNotificacion;
import uy.edu.ort.sigamas.seguridad.notificacion.NotificacionBeanLocal;

/**
 *
 * @author Pikachuss
 */
@Named(value = "beanNotificacion")
@Dependent
public class BeanNotificacion {

    @EJB
    private NotificacionBeanLocal notificacionBeanLocal;
    private String mensaje;
    private int anterioridad_dias;
    private TipoNotificacion tipoNotificacion;
    
    private List<Notificacion> notificacionesTareas;
    private List<Notificacion> notificacionesMaquinarias;
    private List<Notificacion> notificacionesManoObra;
    private List<Notificacion> notificacionesMateriales;
    
    
    /**
     * Creates a new instance of BeanNotificacion
     */
    public BeanNotificacion() {
    }

    /**
     * @return the notificacionBeanLocal
     */
    public NotificacionBeanLocal getNotificacionBeanLocal() {
        return notificacionBeanLocal;
    }

    /**
     * @param notificacionBeanLocal the notificacionBeanLocal to set
     */
    public void setNotificacionBeanLocal(NotificacionBeanLocal notificacionBeanLocal) {
        this.notificacionBeanLocal = notificacionBeanLocal;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the anterioridad_dias
     */
    public int getAnterioridad_dias() {
        return anterioridad_dias;
    }

    /**
     * @param anterioridad_dias the anterioridad_dias to set
     */
    public void setAnterioridad_dias(int anterioridad_dias) {
        this.anterioridad_dias = anterioridad_dias;
    }

    /**
     * @return the tipoNotificacion
     */
    public TipoNotificacion getTipoNotificacion() {
        return tipoNotificacion;
    }

    /**
     * @param tipoNotificacion the tipoNotificacion to set
     */
    public void setTipoNotificacion(TipoNotificacion tipoNotificacion) {
        this.tipoNotificacion = tipoNotificacion;
    }

    /**
     * @return the notificacionesTareas
     */
    public List<Notificacion> getNotificacionesTareas() {
        return notificacionesTareas;
    }

    /**
     * @param notificacionesTareas the notificacionesTareas to set
     */
    public void setNotificacionesTareas(List<Notificacion> notificacionesTareas) {
        this.notificacionesTareas = notificacionesTareas;
    }

    /**
     * @return the notificacionesMaquinarias
     */
    public List<Notificacion> getNotificacionesMaquinarias() {
        return notificacionesMaquinarias;
    }

    /**
     * @param notificacionesMaquinarias the notificacionesMaquinarias to set
     */
    public void setNotificacionesMaquinarias(List<Notificacion> notificacionesMaquinarias) {
        this.notificacionesMaquinarias = notificacionesMaquinarias;
    }

    /**
     * @return the notificacionesManoObra
     */
    public List<Notificacion> getNotificacionesManoObra() {
        return notificacionesManoObra;
    }

    /**
     * @param notificacionesManoObra the notificacionesManoObra to set
     */
    public void setNotificacionesManoObra(List<Notificacion> notificacionesManoObra) {
        this.notificacionesManoObra = notificacionesManoObra;
    }

    /**
     * @return the notificacionesMateriales
     */
    public List<Notificacion> getNotificacionesMateriales() {
        return notificacionesMateriales;
    }

    /**
     * @param notificacionesMateriales the notificacionesMateriales to set
     */
    public void setNotificacionesMateriales(List<Notificacion> notificacionesMateriales) {
        this.notificacionesMateriales = notificacionesMateriales;
    }
    
}
