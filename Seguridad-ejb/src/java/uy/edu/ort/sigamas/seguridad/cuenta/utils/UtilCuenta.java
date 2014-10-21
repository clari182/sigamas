/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.cuenta.utils;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import uy.edu.ort.sigamas.seguridad.cuenta.excepciones.CuentaExistenteException;
import uy.edu.ort.sigamas.seguridad.entidades.Cuenta;

/**
 *
 * @author Pikachuss
 */
public class UtilCuenta {
    public static Cuenta crearCuenta(EntityManager em, String nombre, String empresa, String rut) throws CuentaExistenteException{
        UtilCuenta.verificarNombreCuenta(em, nombre);
        Cuenta cuenta = new Cuenta(null, nombre, empresa);
        cuenta.setRut(rut);
        em.persist(cuenta);
        return cuenta;
    }
    
    public static List<Cuenta> obtenerCuentas(EntityManager em){
        Query cuentas = em.createNamedQuery("Cuenta.findAll");
        return cuentas.getResultList();
    }

    public static void verificarNombreCuenta(EntityManager em, String nombre) throws CuentaExistenteException{
       Query q = em.createNamedQuery("Cuenta.findByNombre").setParameter("nombre", nombre);
       if (!q.getResultList().isEmpty()){
           throw new CuentaExistenteException();
       }
    }
}
