/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.insumo.utils;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import uy.edu.ort.sigamas.seguridad.entidades.Campo;
import uy.edu.ort.sigamas.seguridad.entidades.CampoValor;
import uy.edu.ort.sigamas.seguridad.entidades.Insumo;
import uy.edu.ort.sigamas.seguridad.entidades.InsumoCampoValor;
import uy.edu.ort.sigamas.seguridad.entidades.Valor;

/**
 *
 * @author Pikachuss
 */
public class UtilInsumo {

    public static List<Insumo> obtenerInsumos(EntityManager em, int idCuenta) {
        Query q = em.createNamedQuery("Insumo.findAll");
        List<Insumo> insumos = q.getResultList();
        List<Insumo> retorno = new ArrayList<>();
        for (Insumo insumo : insumos) {
            if (insumo.getIdCuenta().equals(idCuenta)) {
                retorno.add(insumo);
            }
        }
        return retorno;
    }

    public static Campo obtenerCampo(EntityManager em, int idCampo) {
        List<Campo> campos = em.createNamedQuery("Campo.findByIdCampo").setParameter("idCampo", idCampo).getResultList();
        if (!campos.isEmpty()) {
            return campos.get(0);
        }
        return null;
    }

    public static Valor obtenerValor(EntityManager em, int idValor) {
        List<Valor> valores = em.createNamedQuery("Valor.findByIdValor").setParameter("idValor", idValor).getResultList();
        if (!valores.isEmpty()) {
            return valores.get(0);
        }
        return null;
    }

    public static List<CampoValor> obtenerCampoValores(EntityManager em, int idCuenta) {
        List<Campo> campos = em.createNamedQuery("Campo.findByCuenta").setParameter("idCuenta", idCuenta).getResultList();
        List<CampoValor> total = new ArrayList<>();
        for (Campo campo : campos) {
            total.addAll(em.createNamedQuery("CampoValor.findByIdCampo").setParameter("idCampo", campo.getIdCampo()).getResultList());
        }
        return total;
    }

    public static List<InsumoCampoValor> obtenerCampoValorInsumo(EntityManager em, int idInsumo) {
        return em.createNamedQuery("InsumoCampoValor.findByIdInsumo").setParameter("idInsumo", idInsumo).getResultList();
    }
}
