/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.parcela;

import java.util.List;
import javax.ejb.Local;
import uy.edu.ort.sigamas.seguridad.entidades.Cuenta;
import uy.edu.ort.sigamas.campos.entidades.Departamento;
import uy.edu.ort.sigamas.campos.entidades.Parcela;
import uy.edu.ort.sigamas.seguridad.parcela.excepciones.ParcelaPadronExistenteException;

/**
 *
 * @author Pikachuss
 */
@Local
public interface ParcelaBeanLocal {

    
    List<Parcela> obtenerParcelas();

    void crearParcela(String nombre, String padron, String departamento, Cuenta cuentaActual) throws ParcelaPadronExistenteException;

    List<Departamento> obtenerDepartamentos();

    Departamento obtenerDepartamento(String departamento);
    
    Parcela obtenerParcela(int id);
    
}
