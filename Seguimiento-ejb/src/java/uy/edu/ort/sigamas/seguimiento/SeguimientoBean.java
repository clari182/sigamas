/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguimiento;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import uy.edu.ort.sigamas.seguridad.entidades.Cuenta;
import uy.edu.ort.sigamas.seguridad.entidades.Proyecto;
import uy.edu.ort.sigamas.seguridad.entidades.Subfase;
import uy.edu.ort.sigamas.seguridad.entidades.TareaPlanificada;
import uy.edu.ort.sigamas.seguridad.entidades.TareaReal;

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
    public void nuevoProyecto(Proyecto nuevoProyecto) {
        if (nuevoProyecto.getIdCultivo() != null) {
            Subfase subFase = (Subfase) em.createNamedQuery("Subfase.findPrimeraFase")
                    .setParameter("idCultivo", nuevoProyecto.getIdCultivo().getIdCultivo()).getResultList().get(0);
            nuevoProyecto.setIdFasePlanificada(subFase);
            nuevoProyecto.setIdFaseActual(subFase);
            em.persist(nuevoProyecto);
        }
    }

    @Override
    public Proyecto obtenerProyecto(String label) {
        int out = -1;
        Integer.parseInt(label, out);
        return em.find(Proyecto.class, out);
    }

    @Override
    public List<SelectItem> obtenerTareas(Proyecto proyecto) {
        List<SelectItem> tareas = new ArrayList<SelectItem>();
        return null;
    }

    @Override
    public void pasarProyectoDeFase(Proyecto proyecto) {
        List<Subfase> subfases = em.createNamedQuery("Subfase.findFaseSiguiente").setParameter("idSubfase", proyecto.getIdFaseActual()).getResultList();
        if (!subfases.isEmpty()) {
            proyecto.setIdFaseActual(subfases.get(0));
        }
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
