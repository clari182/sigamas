/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.notificacion;

import java.util.List;
import javax.ejb.Local;
import uy.edu.ort.sigamas.seguridad.entidades.Notificacion;
import uy.edu.ort.sigamas.seguridad.entidades.TipoNotificacion;

/**
 *
 * @author Pikachuss
 */
@Local
public interface NotificacionBeanLocal {

    Notificacion agregarNotificacion(String mensaje, TipoNotificacion tipoNotificacion, int anterioridad_dias);

    List<Notificacion> obtenerNotificacionesTarea();

    List<Notificacion> obtenerNotificacionesManoObra();

    List<Notificacion> obtenerNotificacionesMaquinaria();

    List<Notificacion> obtenerNotificacionesMaterial();

    List<TipoNotificacion> obtenerTiposNotificacion();
    
}
