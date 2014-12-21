/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.sigamasweb.seguimiento;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Mattahari
 */
@Named(value = "beanSeguimiento")
@ViewScoped
public class beanSeguimiento implements Serializable{

    /**
     * Creates a new instance of beanSeguimiento
     */
    public beanSeguimiento() {
    }
    
    //private List<Tarea> tareas;
    @PostConstruct
    public void init() {
//        try {
//            tareas = new ArrayList<>();
//            SimpleDateFormat sdf = new  SimpleDateFormat("dd/MM/yyyy");
//            tareas.add(new Tarea(0, "Preparacion de la tierra", "Preparar la tierra para el cultivo", new Date(), null, "cultivo Trigo - Tacurembo"));
//            tareas.add(new Tarea(0, "Siembra", "Sembrar",sdf.parse("31/12/2014"), null, "cultivo Trigo - Tacurembo"));
//            tareas.add(new Tarea(0, "Aplicacion de Pesticidas", "Aplicar X pesticida", sdf.parse("15/01/2015"), null, "cultivo Trigo - Tacurembo"));
//            tareas.add(new Tarea(0, "Cosecha", "Cosechar", sdf.parse("15/02/2015"), null, "cultivo Trigo - Tacurembo"));
//        } catch (ParseException ex) {
//            Logger.getLogger(beanSeguimiento.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

//    public List<Tarea> getTareas() {
//        return tareas;
//    }
//
//    public void setTareas(List<Tarea> tareas) {
//        this.tareas = tareas;
//    }
    
    
   
    
}
