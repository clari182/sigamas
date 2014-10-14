/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.login;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import uy.edu.ort.sigamas.seguridad.login.entidades.Cuenta;
import uy.edu.ort.sigamas.seguridad.login.excepciones.ClaveInvalidaException;
import uy.edu.ort.sigamas.seguridad.login.excepciones.UsuarioInvalidoException;
import uy.edu.ort.sigamas.seguridad.login.utils.UtilLogin;

/**
 *
 * @author anieves
 */
@Stateless
public class LoginBean implements LoginBeanLocal {

    @PersistenceContext(unitName = "Seguridad-PU")
    private EntityManager em;

    @Override
    public boolean verificarUsuario(String nombreUsuario, String claveUsuario) throws ClaveInvalidaException, UsuarioInvalidoException {
        if (nombreUsuario.equals("usuario")) {
            return true;
        } else {
            return false;
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public Collection<Cuenta> obtenerCuentas(String nombreUsuario) throws ClaveInvalidaException, UsuarioInvalidoException {
        return UtilLogin.obtenerCuentas(em, nombreUsuario);
    }

}
