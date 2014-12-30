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
            Subfase subFase = (Subfase) em.createNativeQuery("SELECT s FROM Subfase s WHERE s.id_cultivo = :idCultivo and s.dias = 0")
                    .setParameter("idCultivo", nuevoProyecto.getIdCultivo().getIdCultivo()).getResultList().get(0);
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
        List tareasProyecto = em.
                createNativeQuery("select * from tarea_planificada tp\n"
                        + "where (tp.id_tarea_real is null \n"
                        + "or tp.id_tarea_real in (select tr.id_tarea_real from tarea_real tr where id_proyecto = :idProyecto))\n"
                        + "and tp.id_proyecto = :idProyecto\n"
                        + "order by fecha desc").
                setParameter("idProyecto", proyecto.getIdProyecto()).getResultList();
        for (Object tp : tareasProyecto) {
            
        }
        return null;
    }

}
