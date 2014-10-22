/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.login.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import uy.edu.ort.sigamas.seguridad.entidades.Cuenta;
import uy.edu.ort.sigamas.seguridad.entidades.Usuario;

import uy.edu.ort.sigamas.seguridad.login.excepciones.ClaveInvalidaException;
import uy.edu.ort.sigamas.seguridad.login.excepciones.UsuarioInvalidoException;

/**
 *
 * @author Mattahari
 */
public class UtilLogin {

    public static boolean verificarUsuario(EntityManager em, String nombreUsuario, String claveUsuario) throws UsuarioInvalidoException, ClaveInvalidaException {        
        Query q2 = em.createNamedQuery("Usuario.findByNombreUsuario").setParameter("nombreUsuario", nombreUsuario);
        //List<SuperUsuario> listaCoincidenciasNombre = q.getResultList();
        List<Usuario> listaCoincidenciasUsuario = q2.getResultList();
        if (listaCoincidenciasUsuario.isEmpty()) {            
            throw new UsuarioInvalidoException();
        }
        if (!listaCoincidenciasUsuario.isEmpty() && !listaCoincidenciasUsuario.get(0).getClaveUsuario().equals(claveUsuario)){
            throw new ClaveInvalidaException();
        }
        return true;
    }

    public static List<Cuenta> obtenerCuentas(EntityManager em, String nombreUsuario) {
        Query q = em.createNamedQuery("Cuenta.findAll");
        List<Cuenta> cuentas = q.getResultList();
        if (!cuentas.isEmpty()){
            return cuentas;            
        }        
        return null;
    }
}
