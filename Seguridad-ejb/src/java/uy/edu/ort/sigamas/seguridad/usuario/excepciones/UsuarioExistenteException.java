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
public class UsuarioExistenteException extends Exception{
 
    public UsuarioExistenteException(){}
    
    public UsuarioExistenteException(String msg){
        super(msg);
    }
}
