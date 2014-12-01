/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.cultivo;

import java.util.Date;
import javax.ejb.Local;
import uy.edu.ort.sigamas.seguridad.entidades.Parcela;

/**
 *
 * @author Pikachuss
 */
@Local
public interface CultivoBeanLocal {
    
    void agregarCultivo(String nombre, Parcela parcela, Date fechaInicio);
    void modificarCultivo(String nombre);
}
