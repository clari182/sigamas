/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguimiento;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import uy.edu.ort.sigamas.entidades.seguimiento.Proyecto;

/**
 *
 * @author Mattahari
 */
@Stateless
public class SeguimientoBean implements SeguimientoBeanLocal {

    @PersistenceContext(unitName = "Seguimiento-PU")
    private EntityManager em;

    @Override
    public void nuevoProyecto(Proyecto nuevoProyecto) {
       em.persist(nuevoProyecto);
    }

    
}
