/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.sigamasweb.receta;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Pikachuss
 */
@ManagedBean(name = "beanReceta")
@ViewScoped
public class BeanReceta implements Serializable{

    private List<String> listaRecetasPersonalizadas;
    private String recetaSeleccionada;
    private String nuevoNombre;
    /**
     * Creates a new instance of BeanReceta
     */
    public BeanReceta() {
    }

    /**
     * @return the listaRecetasPersonalizadas
     */
    public List<String> getListaRecetasPersonalizadas() {
        return listaRecetasPersonalizadas;
    }

    /**
     * @param listaRecetasPersonalizadas the listaRecetasPersonalizadas to set
     */
    public void setListaRecetasPersonalizadas(List<String> listaRecetasPersonalizadas) {
        this.listaRecetasPersonalizadas = listaRecetasPersonalizadas;
    }

    /**
     * @return the recetaSeleccionada
     */
    public String getRecetaSeleccionada() {
        return recetaSeleccionada;
    }

    /**
     * @param recetaSeleccionada the recetaSeleccionada to set
     */
    public void setRecetaSeleccionada(String recetaSeleccionada) {
        this.recetaSeleccionada = recetaSeleccionada;
    }
    
    public void seleccionReceta(SelectEvent event){
    
    }
    
    public void deseleccionReceta() { }

    /**
     * @return the nuevoNombre
     */
    public String getNuevoNombre() {
        return nuevoNombre;
    }

    /**
     * @param nuevoNombre the nuevoNombre to set
     */
    public void setNuevoNombre(String nuevoNombre) {
        this.nuevoNombre = nuevoNombre;
    }
    
}
