/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.insumo;

import java.util.List;
import javax.ejb.Local;
import uy.edu.ort.sigamas.seguridad.entidades.Campo;
import uy.edu.ort.sigamas.seguridad.entidades.CampoValor;
import uy.edu.ort.sigamas.seguridad.entidades.Insumo;
import uy.edu.ort.sigamas.seguridad.entidades.InsumoCampoValor;
import uy.edu.ort.sigamas.seguridad.entidades.Valor;

/**
 *
 * @author Pikachuss
 */
@Local
public interface InsumoBeanLocal {
    
    List<Insumo> obtenerInsumos(int idCuenta);
    List<CampoValor> obtenerCampoValores(int idCuenta);
    List<InsumoCampoValor> obtenerCampoValorInsumo(int idInsumo);
    Campo obtenerCampo(int idCampo);
    Valor obtenerValor(int idValor);
}
