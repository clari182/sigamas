package uy.edu.ort.sigamas.seguridad.usuario.utils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import uy.edu.ort.sigamas.seguridad.entidades.Rol;
import uy.edu.ort.sigamas.seguridad.entidades.Usuario;
import uy.edu.ort.sigamas.seguridad.usuario.excepciones.UsuarioExistenteException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Pikachuss
 */
public class UtilUsuario {

    public static Usuario crearUsuario(EntityManager em, Usuario nuevoUsuario, Rol rol) throws UsuarioExistenteException {
        verificarNombreUsuario(em, nuevoUsuario.getNombreUsuario());        
        
        if (rol != null ) {
            Rol managedRol = em.merge(rol);
            nuevoUsuario.setIdRol(managedRol);
        }
        
        em.persist(nuevoUsuario);
        return nuevoUsuario;
    }

    public static void verificarNombreUsuario (EntityManager em, String nombreUsuario) throws UsuarioExistenteException{
        Query q = em.createNamedQuery("Usuario.findByNombreUsuario").setParameter("nombreUsuario", nombreUsuario);
        if (!q.getResultList().isEmpty()) {
            throw new UsuarioExistenteException();
        }        
    }
    public static Usuario modificarUsuario(EntityManager em, Object nuevoUsuario) {
        return null;
    }

    public static boolean eliminarUsuario(EntityManager em, String nombreUsuario) {
        return true;
    }

}
