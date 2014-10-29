/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.usuario.excepciones;

/**
 *
 * @author Pikachuss
 */
public class ViejaContraseñaIncorrectaException extends Exception {

    /**
     * Creates a new instance of <code>ViejaContraseñaIncorrectaException</code>
     * without detail message.
     */
    public ViejaContraseñaIncorrectaException() {
    }

    /**
     * Constructs an instance of <code>ViejaContraseñaIncorrectaException</code>
     * with the specified detail message.
     *
     * @param msg the detail message.
     */
    public ViejaContraseñaIncorrectaException(String msg) {
        super(msg);
    }
}
