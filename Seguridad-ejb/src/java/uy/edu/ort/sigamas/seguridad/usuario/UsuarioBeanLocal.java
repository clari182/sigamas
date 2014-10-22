/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.usuario;

import java.util.Date;
import javax.ejb.Local;
import uy.edu.ort.sigamas.seguridad.entidades.Usuario;
import uy.edu.ort.sigamas.seguridad.usuario.excepciones.UsuarioExistenteException;

/**
 *
 * @author Pikachuss
 */
@Local
public interface UsuarioBeanLocal {
    Usuario crearUsuario(String nombreUsuario, String claveUsuario, String nombre, String apellidos, String emailUsuario, Date fechaNacimiento, String profesion, String sexo, String telefono) throws UsuarioExistenteException;
    
    Usuario modificarUsuario(Object nuevoUsuario);
    
    boolean eliminarUsuario(String nombreUsuario);
}
