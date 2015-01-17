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
     * @param nuevoProyecto Permite la creacion de un nuevo proyecto y guardarlo
     * en la bd
     */
    void nuevoProyecto(Proyecto nuevoProyecto);

    /**
     * @param label Permite obtener el objeto Proyecto a partir de su
     * identificador
     * @return Proyecto
     */
    Proyecto obtenerProyecto(String label);

    /**
     *
     * @param proyecto
     * @return List<SelectItem>
     * Permite obtener la lista de tareas asociadas a un proyecto
     */
    List<TareaReal> obtenerTareas(Proyecto proyecto);

    /**
     *
     * @param proyecto Permite pasar el proyecto a la siguiente fase en forma
     * manual
     */
    void pasarProyectoDeFase(Proyecto proyecto);

    List<Object[]> obtenerTareasPendientes(Cuenta cuentaActual);    
}
