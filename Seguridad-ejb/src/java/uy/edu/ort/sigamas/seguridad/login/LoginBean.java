/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.login;
//hola222
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import uy.edu.ort.sigamas.seguridad.entidades.Usuario;
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
        return UtilLogin.verificarUsuario(em, nombreUsuario, claveUsuario);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public Usuario obtenerUsuario(String nombreUsuario) throws UsuarioInvalidoException {
        return UtilLogin.obtenerUsuario(em, nombreUsuario);
    }

}
