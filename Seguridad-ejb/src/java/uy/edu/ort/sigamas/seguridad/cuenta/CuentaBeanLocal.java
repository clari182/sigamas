/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.cuenta;

import java.util.List;
import javax.ejb.Local;
import uy.edu.ort.sigamas.seguridad.cuenta.excepciones.CreacionCuentaInvalidaException;
import uy.edu.ort.sigamas.seguridad.cuenta.excepciones.CuentaExistenteException;
import uy.edu.ort.sigamas.seguridad.entidades.Cuenta;

/**
 *
 * @author Pikachuss
 */
@Local
public interface CuentaBeanLocal {
    Cuenta crearCuenta(String nombre, String empresa, String rut) throws CreacionCuentaInvalidaException, CuentaExistenteException;

    List<Cuenta> obtenerCuentas();
}
