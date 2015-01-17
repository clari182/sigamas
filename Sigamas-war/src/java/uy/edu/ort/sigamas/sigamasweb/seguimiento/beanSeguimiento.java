/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.sigamasweb.seguimiento;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import uy.edu.ort.sigamas.cultivos.entidades.Cultivo;
import uy.edu.ort.sigamas.seguimiento.SeguimientoBeanLocal;
import uy.edu.ort.sigamas.seguimiento.entidades.Proyecto;
import uy.edu.ort.sigamas.seguimiento.entidades.TareaReal;
import uy.edu.ort.sigamas.sigamasweb.login.BeanSesionUsuario;

/**
 *
 * @author Mattahari
 */
@Named(value = "beanSeguimiento")
@ViewScoped
public class beanSeguimiento implements Serializable{

    @EJB
    private SeguimientoBeanLocal seguimientoBeanLocal;
    
    @ManagedProperty(value = "#{beanSesionUsuario}")
    private BeanSesionUsuario beanSesionUsuario;

    public void setBeanSesionUsuario(BeanSesionUsuario beanSesionUsuario) {
        this.beanSesionUsuario = beanSesionUsuario;
    }
    
    private SelectItem proyectoSeleccionado;
    private List<SelectItem> tareas;
    private List<SelectItem> cultivosConTareasPendientes;
    
    /**
     * Creates a new instance of beanSeguimiento
     */
    public beanSeguimiento() {
    }

    @PostConstruct
    public void init() {
        List<Object[]> tareasPendientes = seguimientoBeanLocal.obtenerTareasPendientes(beanSesionUsuario.getCuentaActual());        
        Cultivo cultivoActual = null;
        
        for (Object[] ob : tareasPendientes) {
            cultivoActual = (Cultivo)ob[0];
            
        }
        
        /*try {
            tareas = new ArrayList<>();
            SimpleDateFormat sdf = new  SimpleDateFormat("dd/MM/yyyy");
            tareas.add(new Tarea(0, "Preparacion de la tierra", "Preparar la tierra para el cultivo", new Date(), null, "cultivo Trigo - Tacurembo"));
            tareas.add(new Tarea(0, "Siembra", "Sembrar",sdf.parse("31/12/2014"), null, "cultivo Trigo - Tacurembo"));
            tareas.add(new Tarea(0, "Aplicacion de Pesticidas", "Aplicar X pesticida", sdf.parse("15/01/2015"), null, "cultivo Trigo - Tacurembo"));
            tareas.add(new Tarea(0, "Cosecha", "Cosechar", sdf.parse("15/02/2015"), null, "cultivo Trigo - Tacurembo"));
        } catch (ParseException ex) {
            Logger.getLogger(beanSeguimiento.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

 
    public void actualizarTareasProyecto(ValueChangeEvent  event){
        proyectoSeleccionado = (SelectItem)event.getNewValue();
//        Proyecto proyecto = seguimientoBeanLocal.obtenerProyecto(proyectoSeleccionado.getLabel());
//        setTareas(seguimientoBeanLocal.obtenerTareas(proyecto));
    }

    /**
     * @return the seguimientoBeanLocal
     */
    public SeguimientoBeanLocal getSeguimientoBeanLocal() {
        return seguimientoBeanLocal;
    }

    /**
     * @param seguimientoBeanLocal the seguimientoBeanLocal to set
     */
    public void setSeguimientoBeanLocal(SeguimientoBeanLocal seguimientoBeanLocal) {
        this.seguimientoBeanLocal = seguimientoBeanLocal;
    }

    /**
     * @return the tareas
     */
    public List<SelectItem> getTareas() {
        return tareas;
    }

    /**
     * @param tareas the tareas to set
     */
    public void setTareas(List<SelectItem> tareas) {
        this.tareas = tareas;
    }

    /**
     * @return the cultivosConTareasPendientes
     */
    public List<SelectItem> getCultivosConTareasPendientes() {
        return cultivosConTareasPendientes;
    }

    /**
     * @param cultivosConTareasPendientes the cultivosConTareasPendientes to set
     */
    public void setCultivosConTareasPendientes(List<SelectItem> cultivosConTareasPendientes) {
        this.cultivosConTareasPendientes = cultivosConTareasPendientes;
    }

       /**
     * @return the proyectoSeleccionado
     */
    public SelectItem getProyectoSeleccionado() {
        return proyectoSeleccionado;
    }

    /**
     * @param proyectoSeleccionado the proyectoSeleccionado to set
     */
    public void setProyectoSeleccionado(SelectItem proyectoSeleccionado) {
        this.proyectoSeleccionado = proyectoSeleccionado;
    } 
    
    
   
    
}
