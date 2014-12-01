/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.cultivo.utils;

import java.util.Date;
import javax.persistence.EntityManager;
import uy.edu.ort.sigamas.seguridad.entidades.Cultivo;
import uy.edu.ort.sigamas.seguridad.entidades.Parcela;

/**
 *
 * @author Pikachuss
 */
public class UtilCultivo {

    public static void agregarCultivo(EntityManager em, String nombre, Parcela parcela, Date fechaInicio) {
        Cultivo cultivo = new Cultivo();
        cultivo.setNombre(nombre);
        cultivo.setIdParcela(parcela);
        cultivo.setFechaInicio(fechaInicio);
        em.persist(cultivo);
    }

    public static void modificarCultivo(EntityManager em, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
