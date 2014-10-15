/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.usuario;

import java.util.Date;
import javax.ejb.Local;
import uy.edu.ort.sigamas.seguridad.entidades.Usuario;

/**
 *
 * @author Pikachuss
 */
@Local
public interface UsuarioBeanLocal {
    boolean crearUsuario(String nombreUsuario, String claveUsuario, String primerNombre, String primerApellido, String segundoNombre, String segundoApellido, String emailUsuario, Date fechaNacimiento, String profesion, String sexo, String telefono);
    Usuario modificarUsuario(Object nuevoUsuario);
    boolean eliminarUsuario(String nombreUsuario);
}
