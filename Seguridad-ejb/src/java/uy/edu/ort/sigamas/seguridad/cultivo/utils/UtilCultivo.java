/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.cultivo.utils;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import uy.edu.ort.sigamas.seguridad.entidades.Cuenta;
import uy.edu.ort.sigamas.cultivos.entidades.Cultivo;
//import uy.edu.ort.sigamas.seguridad.entidades.Cultivo;
import uy.edu.ort.sigamas.campos.entidades.Parcela;
import uy.edu.ort.sigamas.seguimiento.entidades.Proyecto;

/**
 *
 * @author Pikachuss
 */
public class UtilCultivo {

    public static void agregarCultivo(EntityManager em, String nombre, Parcela parcela, Date fechaInicio, String cultivar) {
        Cultivo cultivo = new Cultivo();
        cultivo.setNombre(nombre);
        em.persist(cultivo);
    }

    public static void modificarCultivo(EntityManager em, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static List<Cultivo> obtenerCultivos(EntityManager em) {
        return em.createNamedQuery("Cultivo.findAll").getResultList();
    }

    public static List<Proyecto> obtenerProyectos(EntityManager em, Cuenta cuentaActual) {
        if (cuentaActual == null){
            return em.createNamedQuery("Proyecto.findAll").getResultList();
        } else {
            return em.createNamedQuery("Proyecto.findByIdCuenta").setParameter("idCuenta", cuentaActual.getIdCuenta()).getResultList();
        }
        
    }

}
