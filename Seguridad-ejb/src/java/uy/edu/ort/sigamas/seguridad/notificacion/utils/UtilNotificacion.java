/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.notificacion.utils;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import uy.edu.ort.sigamas.seguridad.entidades.Notificacion;
import uy.edu.ort.sigamas.seguridad.entidades.TipoNotificacion;

/**
 *
 * @author Pikachuss
 */
public class UtilNotificacion {

    public static Notificacion agregarNotificacion(EntityManager em, String mensaje, TipoNotificacion tipoNotificacion, int anterioridad_dias) {
        Notificacion nuevaNotificacion = new Notificacion();
        nuevaNotificacion.setMensaje(mensaje);
        nuevaNotificacion.setIdTipoNotificacion(tipoNotificacion);
        nuevaNotificacion.setAnterioridadDias(anterioridad_dias);
        em.persist(nuevaNotificacion);
        return nuevaNotificacion;
    }

    public static List<Notificacion> obtenerNotificacionesTarea(EntityManager em) {
        Query notificaciones = em.createNamedQuery("Notificacion.findByTipo").setParameter("tipo", 1);
        return notificaciones.getResultList();
    }

    public static List<Notificacion> obtenerNotificacionesManoObra(EntityManager em) {
        Query notificaciones = em.createNamedQuery("Notificacion.findByTipo").setParameter("tipo", 2);
        return notificaciones.getResultList();
    }

    public static List<Notificacion> obtenerNotificaconesMaquinaria(EntityManager em) {
        Query notificaciones = em.createNamedQuery("Notificacion.findByTipo").setParameter("tipo", 3);
        return notificaciones.getResultList();
    }

    public static List<Notificacion> obtenerNotificacionesMaterial(EntityManager em) {
        Query notificaciones = em.createNamedQuery("Notificacion.findByTipo").setParameter("tipo", 4);
        return notificaciones.getResultList();
    }

    public static List<TipoNotificacion> obtenerTiposNotificacion(EntityManager em) {
        return em.createNamedQuery("TipoNotificacion.findAll").getResultList();
    }
    
}
