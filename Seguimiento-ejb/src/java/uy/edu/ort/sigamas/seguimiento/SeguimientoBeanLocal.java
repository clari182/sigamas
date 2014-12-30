/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguimiento;

import java.util.List;
import javax.ejb.Local;
import javax.faces.model.SelectItem;
import uy.edu.ort.sigamas.seguridad.entidades.Proyecto;

/**
 *
 * @author Mattahari
 */
@Local
public interface SeguimientoBeanLocal {

    void nuevoProyecto(Proyecto nuevoProyecto);

    Proyecto obtenerProyecto(String label);

    List<SelectItem> obtenerTareas(Proyecto proyecto);
    
}
