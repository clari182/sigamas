/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.parcela.utils;

import java.util.List;
import javax.persistence.EntityManager;
import uy.edu.ort.sigamas.seguridad.entidades.Parcela;

/**
 *
 * @author Pikachuss
 */
public class UtilParcela {
    
    public static List<Parcela> obtenerParcelas(EntityManager em){
        return null; //Se buscará las parcelas de la cuenta
    }

    public static void crearParcela(EntityManager em, String nombre, String padron) {
        Parcela nuevaParcela = new Parcela();
        nuevaParcela.setNombre(nombre);
        nuevaParcela.setPadron(padron);
        em.persist(nuevaParcela);
    }
    
}
