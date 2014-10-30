/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uy.edu.ort.sigamas.seguridad.login.excepciones;

/**
 *
 * @author Mattahari
 */
public class ClaveInvalidaException extends Exception {

    /**
     * Creates a new instance of <code>ClaveInvalidaException</code> without
     * detail message.
     */
    public ClaveInvalidaException() {
    }

    /**
     * Constructs an instance of <code>ClaveInvalidaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ClaveInvalidaException(String msg) {
        super(msg);
    }
}
