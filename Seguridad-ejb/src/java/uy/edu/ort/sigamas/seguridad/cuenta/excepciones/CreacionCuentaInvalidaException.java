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
public class CreacionCuentaInvalidaException extends Exception{
    public CreacionCuentaInvalidaException(){}
    
    public CreacionCuentaInvalidaException(String msg){
        super(msg);
    }
}
