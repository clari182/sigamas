/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.sigamasweb.notificacion;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import uy.edu.ort.sigamas.notificaciones.entidades.Notificacion;
import uy.edu.ort.sigamas.notificaciones.entidades.TipoNotificacion;
import uy.edu.ort.sigamas.seguimiento.entidades.TareaReal;
import uy.edu.ort.sigamas.seguridad.notificacion.NotificacionBeanLocal;
import uy.edu.ort.sigamas.sigamasweb.login.BeanSesionUsuario;

/**
 *
 * @author Pikachuss
 */
@Named(value = "beanNotificacion")
@ViewScoped
public class BeanNotificacion implements Serializable {

    @EJB
    private NotificacionBeanLocal notificacionBeanLocal;

    @ManagedProperty(value = "#{beanSesionUsuario}")
    private BeanSesionUsuario beanSesionUsuario;

    public void setBeanSesionUsuario(BeanSesionUsuario beanSesionUsuario) {
        this.beanSesionUsuario = beanSesionUsuario;
    }

    private Notificacion notificacionSeleccionada;

    private String mensaje;
    private int anterioridad_dias;
    private TipoNotificacion tipoNotificacion;
    private String destino;

    private List<Notificacion> notificacionesTareas;
    private List<TareaReal> tareasSinNotificacion;
    private List<TipoNotificacion> tiposNotificacion;

    /**
     * Creates a new instance of BeanNotificacion
     */
    public BeanNotificacion() {
    }

    @PostConstruct
    public void init() {
        notificacionSeleccionada = new Notificacion();
        notificacionesTareas = notificacionBeanLocal.obtenerNotificacionesTarea();
        tiposNotificacion = notificacionBeanLocal.obtenerTiposNotificacion();
        if (beanSesionUsuario != null) {
            setTareasSinNotificacion(notificacionBeanLocal.obtenerTareasSinNotificacion(beanSesionUsuario.getCuentaActual()));
        }
    }

// <editor-fold defaultstate="collapsed" desc="Gets y Sets">
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
     * @return the destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * @return the notificacionSeleccionada
     */
    public Notificacion getNotificacionSeleccionada() {
        return notificacionSeleccionada;
    }

    /**
     * @param notificacionSeleccionada the notificacionSeleccionada to set
     */
    public void setNotificacionSeleccionada(Notificacion notificacionSeleccionada) {
        this.notificacionSeleccionada = notificacionSeleccionada;
    }

    /**
     * @return the tiposNotificacion
     */
    public List<TipoNotificacion> getTiposNotificacion() {
        return tiposNotificacion;
    }

    /**
     * @param tiposNotificacion the tiposNotificacion to set
     */
    public void setTiposNotificacion(List<TipoNotificacion> tiposNotificacion) {
        this.tiposNotificacion = tiposNotificacion;
    }

// </editor-fold>
    public void agregarNotificacion() {
        Notificacion nuevaNotificacion = notificacionBeanLocal.agregarNotificacion(mensaje, tipoNotificacion, anterioridad_dias);
        notificacionesTareas.add(nuevaNotificacion);
    }

    public void seleccionNotificacion(SelectEvent event) {
        notificacionSeleccionada = (Notificacion) event.getObject();
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogNotificacion').show();");
        RequestContext.getCurrentInstance().update("detalleNotificacion");
    }

    public void deseleccionNotificacion() {
    }

    public void modificarNotificacion() {
        if (notificacionSeleccionada != null) {
            //notificacionBeanLocal.cambiarAnterioridadNotificacion(notificacionSeleccionada, anterioridad_dias);
            //notificacionBeanLocal.cambiarMensajeNotificacion(notificacionSeleccionada, mensaje);
            notificacionBeanLocal.modificarNotificacion(notificacionSeleccionada);
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dialogNotificacion').hide();");        
        }
    }

    /**
     * @return the tareasSinNotificacion
     */
    public List<TareaReal> getTareasSinNotificacion() {
        return tareasSinNotificacion;
    }

    /**
     * @param tareasSinNotificacion the tareasSinNotificacion to set
     */
    public void setTareasSinNotificacion(List<TareaReal> tareasSinNotificacion) {
        this.tareasSinNotificacion = tareasSinNotificacion;
    }

}

