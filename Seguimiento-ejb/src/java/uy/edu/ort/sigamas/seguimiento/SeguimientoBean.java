/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguimiento;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import uy.edu.ort.sigamas.seguridad.entidades.Proyecto;
import uy.edu.ort.sigamas.seguridad.entidades.Subfase;
import uy.edu.ort.sigamas.seguridad.entidades.TareaPlanificada;

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
        List<Subfase> subFases = em.createNativeQuery("SELECT s FROM Subfase s WHERE s.id_cultivo = :idCultivo")
                .setParameter("idCultivo", nuevoProyecto.getIdCultivo().getIdCultivo()).getResultList();
        for (Subfase subFase : subFases) {
            TareaPlanificada tarea = new TareaPlanificada();
            tarea.setIdProyecto(nuevoProyecto);
            Long time = nuevoProyecto.getFechaInicio().getTime() + (subFase.getDias() * 24 * 60 * 60 * 1000);
            Date fecha = new Date();
            fecha.setTime(time);
            tarea.setFecha(fecha);
            tarea.setNombre(subFase.getNombre());
            tarea.setIdSubfase(subFase);
            em.persist(tarea);
        }
        em.persist(nuevoProyecto);
    }

}
