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
    /**
     * 
     * @param nombre
     * @param empresa
     * @param rut
     * @return Cuenta
     * @throws CreacionCuentaInvalidaException
     * @throws CuentaExistenteException 
     * Permite la creacion de una nueva cuenta y guardarla en la bd
     */
    Cuenta crearCuenta(String nombre, String empresa, String rut) throws CreacionCuentaInvalidaException, CuentaExistenteException;

    /**
     * 
     * Permite obtener todas las cuentas registradas en la bd
     * @return List<Cuenta>     
     */
    List<Cuenta> obtenerCuentas();

    /**
     * 
     * @param nombre
     * @throws CuentaExistenteException 
     * Permite verificar que ya no exista una cuenta con el nombre especificado
     */
    void verificarNombreCuenta(String nombre) throws CuentaExistenteException;
}
