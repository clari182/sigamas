/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uy.edu.ort.sigamas.sigamasweb.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Mattahari
 */
public class UtilsMensajes {
    public static void mostrarMensajeError(String id, String titulo, String mensaje){
        FacesContext.getCurrentInstance().addMessage(id, new FacesMessage(FacesMessage.SEVERITY_ERROR, titulo, mensaje));
    }
    
    public static void mostrarMensajeInformacion(String id, String titulo, String mensaje){
        FacesContext.getCurrentInstance().addMessage(id, new FacesMessage(FacesMessage.SEVERITY_INFO, titulo, mensaje));
    }
}
