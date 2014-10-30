/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.parcela.excepciones;

/**
 *
 * @author Pikachuss
 */
public class ParcelaPadronExistenteException extends Exception {

    /**
     * Creates a new instance of <code>ParcelaNombreExistenteException</code>
     * without detail message.
     */
    public ParcelaPadronExistenteException() {
    }

    /**
     * Constructs an instance of <code>ParcelaNombreExistenteException</code>
     * with the specified detail message.
     *
     * @param msg the detail message.
     */
    public ParcelaPadronExistenteException(String msg) {
        super(msg);
    }
}
