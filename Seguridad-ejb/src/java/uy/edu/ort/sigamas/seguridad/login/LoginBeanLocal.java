/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uy.edu.ort.sigamas.seguridad.login;

import javax.ejb.Local;
import uy.edu.ort.sigamas.seguridad.entidades.Usuario;
import uy.edu.ort.sigamas.seguridad.login.excepciones.ClaveInvalidaException;
import uy.edu.ort.sigamas.seguridad.login.excepciones.UsuarioInvalidoException;

/**
 *
 * @author anieves
 */
@Local
public interface LoginBeanLocal {

    /**
     * 
     * @param nombreUsuario
     * @param claveUsuario
     * @return boolean
     * @throws ClaveInvalidaException
     * @throws UsuarioInvalidoException 
     * Permite verificar que el usuario ingresado es el correcto
     */
    boolean verificarUsuario(String nombreUsuario, String claveUsuario) throws ClaveInvalidaException, UsuarioInvalidoException;

    /**
     * 
     * @param nombreUsuario
     * @return Usuario
     * @throws UsuarioInvalidoException 
     * Permite obtener el objeto Usuario a partir del nombre de usuario
     */
    Usuario obtenerUsuario(String nombreUsuario) throws UsuarioInvalidoException;

    /**
     * 
     * @param usuarioLoggeado 
     * Permite registrar en la bd un login con los datos del usuario y la fecha actual
     */
    void agregarLogin(Usuario usuarioLoggeado);
    
}