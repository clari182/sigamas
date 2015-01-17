/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.cultivo;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import uy.edu.ort.sigamas.seguridad.entidades.Cuenta;
import uy.edu.ort.sigamas.cultivos.entidades.Cultivo;
import uy.edu.ort.sigamas.campos.entidades.Parcela;
import uy.edu.ort.sigamas.seguimiento.entidades.Proyecto;

/**
 *
 * @author Pikachuss
 */
@Local
public interface CultivoBeanLocal {
    
    /**
     * 
     * @param nombre
     * @param parcela
     * @param fechaInicio
     * @param cultivar 
     * Permite la creacion de un nuevo cultivo en la bd
     */
    void agregarCultivo(String nombre, Parcela parcela, Date fechaInicio, String cultivar);
    
    /**
     * 
     * @param nombre 
     * Permite modificar el nombre de un cultivo ya existente
     */
    void modificarCultivo(String nombre);

    /**
     * 
     * @return List<Cultivo>
     * Permite obtener todos los cultivos registrados en la bd
     */
    List<Cultivo> obtenerCultivos();

    /**
     * 
     * @param cuentaActual
     * @return List<Proyecto>
     * Permite obtener todos los proyectos asociados a la cuenta loggeada actualmente
     */
    List<Proyecto> obtenerProyectos(Cuenta cuentaActual);

    /**
     * 
     * @param i
     * @return Cultivo
     * Permite obtener un cultivo a partir de su identificador
     */
    Cultivo obtenerCultivo(int i);
}
