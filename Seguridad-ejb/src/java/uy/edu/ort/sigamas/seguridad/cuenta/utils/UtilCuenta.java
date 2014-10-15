/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.cuenta.utils;

import javax.persistence.EntityManager;
import uy.edu.ort.sigamas.seguridad.entidades.Cuenta;

/**
 *
 * @author Pikachuss
 */
public class UtilCuenta {
    public static Cuenta crearCuenta(EntityManager em, String nombre, String empresa, String rut){
        
        //Cuenta cuenta = new Cuenta(nombre, empresa, rut);
        //em.getTransaction().commit();
        return null;//cuenta;
    }
}
