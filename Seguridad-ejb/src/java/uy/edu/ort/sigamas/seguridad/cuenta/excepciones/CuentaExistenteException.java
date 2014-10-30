/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.cuenta.excepciones;

/**
 *
 * @author Pikachuss
 */
public class CuentaExistenteException extends Exception {

    /**
     * Creates a new instance of <code>CuentaExistenteException</code> without
     * detail message.
     */
    public CuentaExistenteException() {
    }

    /**
     * Constructs an instance of <code>CuentaExistenteException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CuentaExistenteException(String msg) {
        super(msg);
    }
}
