package uy.edu.ort.sigamas.seguridad.usuario.utils;


import java.util.Date;
import javax.persistence.EntityManager;
import uy.edu.ort.sigamas.seguridad.entidades.Usuario;

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
    
    public static boolean crearUsuario(EntityManager em, String nombreUsuario, String claveUsuario, String nombre, String apellidos, String emailUsuario, Date fechaNacimiento, String profesion, String sexo, String telefono){
       Usuario usuario = new Usuario(null, nombreUsuario, claveUsuario, nombre, apellidos);
       usuario.setEmailUsuario(emailUsuario);
       usuario.setFechaNacimiento(fechaNacimiento);
       usuario.setSexo(sexo);
       usuario.setProfesion(profesion);
       usuario.setTelefono(telefono);
       em.persist(usuario);
       return true;
    }
    public static Usuario modificarUsuario(EntityManager em, Object nuevoUsuario){
        return null;
    }
    public static boolean eliminarUsuario(EntityManager em, String nombreUsuario){
        return true;
    }
    
}
