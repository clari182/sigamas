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
import uy.edu.ort.sigamas.seguridad.entidades.Cultivo;
import uy.edu.ort.sigamas.seguridad.entidades.Parcela;
import uy.edu.ort.sigamas.seguridad.entidades.Proyecto;

/**
 *
 * @author Pikachuss
 */
@Local
public interface CultivoBeanLocal {
    
    void agregarCultivo(String nombre, Parcela parcela, Date fechaInicio, String cultivar);
    void modificarCultivo(String nombre);

    List<Cultivo> obtenerCultivos();

    List<Proyecto> obtenerProyectos(Cuenta cuentaActual);
}
