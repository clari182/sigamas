/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguimiento;

import javax.ejb.Local;
import uy.edu.ort.sigamas.entidades.seguimiento.Proyecto;

/**
 *
 * @author Mattahari
 */
@Local
public interface SeguimientoBeanLocal {

    void nuevoProyecto(Proyecto nuevoProyecto);
    
}
