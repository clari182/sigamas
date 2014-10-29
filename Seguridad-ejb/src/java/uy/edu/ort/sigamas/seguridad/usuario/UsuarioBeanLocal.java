/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.usuario;

import java.util.List;
import javax.ejb.Local;
import uy.edu.ort.sigamas.seguridad.entidades.Rol;
import uy.edu.ort.sigamas.seguridad.entidades.Usuario;
import uy.edu.ort.sigamas.seguridad.usuario.excepciones.UsuarioExistenteException;
import uy.edu.ort.sigamas.seguridad.usuario.excepciones.ViejaContraseñaIncorrectaException;

/**
 *
 * @author Pikachuss
 */
@Local
public interface UsuarioBeanLocal {
    Usuario crearUsuario(Usuario nuevoUsuario, Rol rol) throws UsuarioExistenteException;
    
    Usuario modificarUsuario(Usuario nuevoUsuario);
    
    boolean eliminarUsuario(String nombreUsuario);
    
    void verificarUsuario(String nombreUsuario) throws UsuarioExistenteException;

    List<Usuario> obtenerUsuarios();

    void cambiarContraseña(Usuario usuarioLoggeado, String viejaContraseña, String nuevaContraseña) throws ViejaContraseñaIncorrectaException;
}
