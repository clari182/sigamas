/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.insumo;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import uy.edu.ort.sigamas.seguridad.entidades.Campo;
//import uy.edu.ort.sigamas.seguridad.entidades.CampoValor;
import uy.edu.ort.sigamas.seguridad.entidades.Insumo;
//import uy.edu.ort.sigamas.seguridad.entidades.InsumoCampoValor;
import uy.edu.ort.sigamas.seguridad.entidades.Valor;
import uy.edu.ort.sigamas.seguridad.insumo.utils.UtilInsumo;

/**
 *
 * @author Pikachuss
 */
@Stateless
public class InsumoBean implements InsumoBeanLocal {

    @PersistenceContext(unitName = "Seguridad-PU")
    private EntityManager em;
    
    @Override
    public List<Insumo> obtenerInsumos(int idCuenta){
        return UtilInsumo.obtenerInsumos(em, idCuenta);
    }
    
    /*@Override
    public List<CampoValor> obtenerCampoValores(int idCuenta){
        return UtilInsumo.obtenerCampoValores(em, idCuenta);
    }
    
    @Override
    public List<InsumoCampoValor> obtenerCampoValorInsumo(int idInsumo){
        return UtilInsumo.obtenerCampoValorInsumo(em, idInsumo);
    }*/
    
    @Override
    public Campo obtenerCampo(int idCampo){
        return UtilInsumo.obtenerCampo(em, idCampo);
    }
    
    @Override
    public Valor obtenerValor(int idValor){
        return UtilInsumo.obtenerValor(em, idValor);
    }
}
