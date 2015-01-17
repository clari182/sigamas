/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguimiento;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import uy.edu.ort.sigamas.seguridad.entidades.Cuenta;
import uy.edu.ort.sigamas.seguimiento.entidades.Proyecto;
import uy.edu.ort.sigamas.seguimiento.entidades.TareaReal;

;

/**
 *
 * @author Mattahari
 */
@Stateless
public class SeguimientoBean implements SeguimientoBeanLocal {

    @PersistenceContext(unitName = "Seguimiento-PU")
    private EntityManager em;

    @Override
    public void guardarProyecto(Proyecto nuevoProyecto) {

    }

    @Override
    public List<TareaReal> obtenerTareasPendientes(Cuenta cuentaActual) {
        List<TareaReal> tareasPendientes = new ArrayList<>();
        if (cuentaActual != null) {
            tareasPendientes = em.createNamedQuery("TareaReal.findTareasPendientes").setParameter("idCuenta", cuentaActual.getIdCuenta()).getResultList();
        } else {
            tareasPendientes = em.createNamedQuery("TareaReal.findAll").getResultList();
        }
        return tareasPendientes;
    }

}
