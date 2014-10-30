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
        List<Usuario> listaCoincidenciasUsuario = UtilLogin.obtenerUsuarios(em, nombreUsuario);
        if (listaCoincidenciasUsuario.isEmpty()) {            
            throw new UsuarioInvalidoException();
        }
        if (!listaCoincidenciasUsuario.isEmpty() && !listaCoincidenciasUsuario.get(0).getClaveUsuario().equals(claveUsuario)){
            throw new ClaveInvalidaException();
        }
        return true;
    }

    public static Usuario obtenerUsuario(EntityManager em, String nombreUsuario)  throws UsuarioInvalidoException{
        List<Usuario> usuarios = UtilLogin.obtenerUsuarios(em, nombreUsuario);
        if (usuarios.isEmpty()){
            throw new UsuarioInvalidoException();
        }        
        return usuarios.get(0);            
    }
    
    private static List<Usuario> obtenerUsuarios(EntityManager em, String nombreUsuario){
        return em.createNamedQuery("Usuario.findByNombreUsuario").setParameter("nombreUsuario", nombreUsuario).getResultList();                
    }
}
