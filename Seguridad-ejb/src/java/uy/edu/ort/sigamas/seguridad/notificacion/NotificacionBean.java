/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.notificacion;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import uy.edu.ort.sigamas.seguridad.entidades.Cuenta;
import uy.edu.ort.sigamas.seguridad.entidades.Notificacion;
import uy.edu.ort.sigamas.seguridad.entidades.TareaPlanificada;
import uy.edu.ort.sigamas.seguridad.entidades.TareaReal;
import uy.edu.ort.sigamas.seguridad.entidades.TipoNotificacion;
import uy.edu.ort.sigamas.seguridad.notificacion.utils.UtilNotificacion;

/**
 *
 * @author Pikachuss
 */
@Stateless
public class NotificacionBean implements NotificacionBeanLocal {

    @PersistenceContext(unitName = "Seguridad-PU")
    private EntityManager em;

    @Override
    public Notificacion agregarNotificacion(String mensaje, TipoNotificacion tipoNotificacion, int anterioridad_dias) {
        return UtilNotificacion.agregarNotificacion(em, mensaje, tipoNotificacion, anterioridad_dias);
    }

    @Override
    public List<Notificacion> obtenerNotificacionesTarea() {
        return UtilNotificacion.obtenerNotificacionesTarea(em);
    }
    
    @Override
    public List<TipoNotificacion> obtenerTiposNotificacion(){
        return UtilNotificacion.obtenerTiposNotificacion(em);
    }
    
    @Override
    public void modificarNotificacion(Notificacion notificacionSeleccionada){
        UtilNotificacion.modificarNotificacion(em, notificacionSeleccionada);
    }
    
    @Override
    public List<TareaReal> obtenerTareasSinNotificacion(Cuenta cuentaActual){
        return UtilNotificacion.obtenerTareasSinNotificacion(em, cuentaActual);
    }
}
