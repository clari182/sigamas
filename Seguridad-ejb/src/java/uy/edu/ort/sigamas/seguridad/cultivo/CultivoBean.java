/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.cultivo;

import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import uy.edu.ort.sigamas.seguridad.cultivo.utils.UtilCultivo;
import uy.edu.ort.sigamas.seguridad.entidades.Parcela;

/**
 *
 * @author Pikachuss
 */
@Stateless
public class CultivoBean implements CultivoBeanLocal {

    @PersistenceContext(unitName = "Seguridad-PU")
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public void agregarCultivo(String nombre, Parcela parcela, Date fechaInicio){
        UtilCultivo.agregarCultivo(em, nombre, parcela, fechaInicio);
    }
    
    @Override
    public void modificarCultivo(String nombre){
        UtilCultivo.modificarCultivo(em, nombre);
    }
}