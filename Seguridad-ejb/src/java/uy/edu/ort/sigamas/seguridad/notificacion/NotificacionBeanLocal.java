/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.notificacion;

import java.util.List;
import javax.ejb.Local;
import uy.edu.ort.sigamas.notificaciones.entidades.Notificacion;
import uy.edu.ort.sigamas.notificaciones.entidades.TipoNotificacion;
import uy.edu.ort.sigamas.seguimiento.entidades.TareaReal;
import uy.edu.ort.sigamas.seguridad.entidades.Cuenta;

/**
 *
 * @author Pikachuss
 */
@Local
public interface NotificacionBeanLocal {

    /**
     *
     * @param mensaje
     * @param tipoNotificacion
     * @param anterioridad_dias
     * @return Notificacion Permite la creacion de una nueva Notificacion
     */
    Notificacion agregarNotificacion(String mensaje, TipoNotificacion tipoNotificacion, int anterioridad_dias);

    List<Notificacion> obtenerNotificacionesTarea();

    List<TipoNotificacion> obtenerTiposNotificacion();

    void modificarNotificacion(Notificacion notificacionSeleccionada);

    List<TareaReal> obtenerTareasSinNotificacion(Cuenta cuentaActual);

    List<Notificacion> obtenerNotificacionesNoLeidas(Cuenta cuentaActual);

    void cambiarAnterioridadNotificacion(Notificacion notificacionSeleccionada, int anterioridad);

    void cambiarMensajeNotificacion(Notificacion notificacionSeleccionada, String mensaje);

}
