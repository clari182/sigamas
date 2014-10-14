/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uy.edu.ort.sigamas.seguridad.login;

import java.util.Collection;
import java.util.List;
import javax.ejb.Local;
import uy.edu.ort.sigamas.seguridad.entidades.Cuenta;
import uy.edu.ort.sigamas.seguridad.login.excepciones.ClaveInvalidaException;
import uy.edu.ort.sigamas.seguridad.login.excepciones.UsuarioInvalidoException;

/**
 *
 * @author anieves
 */
@Local
public interface LoginBeanLocal {

    boolean verificarUsuario(String nombreUsuario, String claveUsuario) throws ClaveInvalidaException, UsuarioInvalidoException;

    List<Cuenta> obtenerCuentas(String nombreUsuario) throws ClaveInvalidaException, UsuarioInvalidoException;
    
}
