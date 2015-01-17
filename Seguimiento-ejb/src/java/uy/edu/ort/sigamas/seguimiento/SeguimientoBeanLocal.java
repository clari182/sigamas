/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguimiento;

import java.util.List;
import javax.ejb.Local;
import uy.edu.ort.sigamas.seguimiento.entidades.Proyecto;
import uy.edu.ort.sigamas.seguimiento.entidades.TareaReal;
import uy.edu.ort.sigamas.seguridad.entidades.Cuenta;


/**
 *
 * @author Mattahari
 */
@Local
public interface SeguimientoBeanLocal {

    /**    
     * @param nuevoProyecto 
     * Permite la creacion de un nuevo proyecto y guardarlo en la bd
     */
    void guardarProyecto(Proyecto nuevoProyecto);      
    
    List<TareaReal> obtenerTareasPendientes(Cuenta cuentaActual);
}
