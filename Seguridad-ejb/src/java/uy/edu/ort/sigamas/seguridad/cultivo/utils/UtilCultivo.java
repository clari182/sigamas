/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.cultivo.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import uy.edu.ort.sigamas.seguridad.entidades.Cuenta;
import uy.edu.ort.sigamas.seguridad.entidades.Cultivo;
//import uy.edu.ort.sigamas.seguridad.entidades.Cultivo;
import uy.edu.ort.sigamas.seguridad.entidades.Parcela;

/**
 *
 * @author Pikachuss
 */
public class UtilCultivo {

    public static void agregarCultivo(EntityManager em, String nombre, Parcela parcela, Date fechaInicio) {
        Cultivo cultivo = new Cultivo();
        cultivo.setNombre(nombre);
        cultivo.setIdParcela(parcela);
        cultivo.setFechaInicio(fechaInicio);
        em.persist(cultivo);
    }

    public static void modificarCultivo(EntityManager em, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static List<Cultivo> obtenerCultivos(EntityManager em, Cuenta cuentaActual) {
       List<Parcela> parcelasCuenta = new ArrayList<>();
       List<Cultivo> cultivosCuenta = new ArrayList<>();
       if (cuentaActual != null){
       Query query = em.createNamedQuery("Parcela.findByCuenta").setParameter("idCuenta", cuentaActual.getIdCuenta());
       if (!query.getResultList().isEmpty()){
           parcelasCuenta = query.getResultList();
       }
       Query qFor = em.createNamedQuery("Cultivo.findByParcela");
       List<Cultivo> cultivosAux;
        for (Parcela parcelaCuenta : parcelasCuenta) {
            cultivosAux = qFor.setParameter("idParcela", parcelaCuenta.getIdParcela()).getResultList();
            cultivosCuenta.addAll(cultivosAux);
        }
        return cultivosCuenta;
       }
       else{
           return em.createNamedQuery("Cultivo.findAll").getResultList();
       }
       
    }
    
}
