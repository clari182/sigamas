/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.parcela;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import uy.edu.ort.sigamas.seguridad.entidades.Parcela;
import uy.edu.ort.sigamas.seguridad.parcela.utils.UtilParcela;

/**
 *
 * @author Pikachuss
 */
@Stateless
public class ParcelaBean implements ParcelaBeanLocal {

    @PersistenceContext(unitName = "Seguridad-PU")
    private EntityManager em;
    
    @Override
    public List<Parcela> obtenerParcelas(){
        return UtilParcela.obtenerParcelas(em);
    }
}
