/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.parcela.utils;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import uy.edu.ort.sigamas.seguridad.entidades.Cuenta;
import uy.edu.ort.sigamas.campos.entidades.Departamento;
import uy.edu.ort.sigamas.campos.entidades.Parcela;
import uy.edu.ort.sigamas.seguridad.parcela.excepciones.ParcelaPadronExistenteException;

/**
 *
 * @author Pikachuss
 */
public class UtilParcela {

    public static List<Parcela> obtenerParcelas(EntityManager em) {
        return em.createNamedQuery("Parcela.findAll").getResultList();
    }

    public static void crearParcela(EntityManager em, String nombre, String padron, String departamento, Cuenta cuentaActual) throws ParcelaPadronExistenteException {
        Query q = em.createNamedQuery("Parcela.findByPadron").setParameter("padron", padron);
        if (!q.getResultList().isEmpty()) {
            throw new ParcelaPadronExistenteException();
        }
        Parcela nuevaParcela = new Parcela();
        nuevaParcela.setNombre(nombre);
        nuevaParcela.setPadron(padron);
        nuevaParcela.setDepartamento(departamento);
        nuevaParcela.setIdCuenta(cuentaActual);
        em.persist(nuevaParcela);
    }

    public static List<Departamento> obtenerDepartamentos(EntityManager em) {
        return em.createNamedQuery("Departamento.findAll").getResultList();
    }

    public static Departamento obtenerDepartamento(EntityManager em, String departamento) {
        Query q = em.createNamedQuery("Departamento.findByIdDepartamento").setParameter("idDepartamento",Integer.parseInt(departamento));
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (Departamento) q.getResultList().get(0);
    }

}
