/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.sigamasweb.proyecto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import uy.edu.ort.sigamas.seguridad.cultivo.CultivoBeanLocal;
import uy.edu.ort.sigamas.seguridad.entidades.Cultivo;
//import uy.edu.ort.sigamas.seguridad.entidades.Cultivo;
import uy.edu.ort.sigamas.seguridad.entidades.Parcela;
import uy.edu.ort.sigamas.seguridad.entidades.Proyecto;
import uy.edu.ort.sigamas.sigamasweb.login.BeanSesionUsuario;
import uy.edu.ort.sigamas.sigamasweb.parcela.BeanParcela;

/**
 *
 * @author Pikachuss
 */
@Named(value = "beanProyecto")
@ViewScoped
public class BeanProyecto implements Serializable {

    /**
     * Creates a new instance of BeanProyecto
     */
    @EJB
    private CultivoBeanLocal cultivoBeanLocal;

    @ManagedProperty(value = "#{beanSesionUsuario}")
    private BeanSesionUsuario beanSesionUsuario;

    public void setBeanSesionUsuario(BeanSesionUsuario beanSesionUsuario) {
        this.beanSesionUsuario = beanSesionUsuario;
    }

    private String nombre;
    private Date fechaInicio;
    private Parcela parcela;
    private int parcelaSeleccionada;

    private List<SelectItem> proyectos;
    private String cultivo;
    private List<SelectItem> cultivos;

    public BeanProyecto() {
    }

    @PostConstruct
    public void init() {
        List<Cultivo> cultivosAux = cultivoBeanLocal.obtenerCultivos();
        cultivos = new ArrayList<>();
        for (Cultivo c : cultivosAux) {
            cultivos.add(new SelectItem(c.getIdCultivo(), c.getNombre()));
        }
        List<Proyecto> proyectosAux = cultivoBeanLocal.obtenerProyectos(beanSesionUsuario.getCuentaActual());
        proyectos = new ArrayList<>();
        for (Proyecto proyecto : proyectosAux) {
            proyectos.add(new SelectItem(proyecto.getIdProyecto(), proyecto.getNombre()));
        }
    }

// <editor-fold defaultstate="collapsed" desc="Gets y Sets"> 
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the parcela
     */
    public Parcela getParcela() {
        return parcela;
    }

    /**
     * @param parcela the parcela to set
     */
    public void setParcela(Parcela parcela) {
        this.parcela = parcela;
    }

    /**
     * @return the cultivoBeanLocal
     */
    public CultivoBeanLocal getCultivoBeanLocal() {
        return cultivoBeanLocal;
    }

    /**
     * @param cultivoBeanLocal the cultivoBeanLocal to set
     */
    public void setCultivoBeanLocal(CultivoBeanLocal cultivoBeanLocal) {
        this.cultivoBeanLocal = cultivoBeanLocal;
    }

    /**
     * @return the proyectos
     */
    public List<SelectItem> getProyectos() {
        return proyectos;
    }

    /**
     * @param cultivos the proyectos to set
     */
    public void setProyectos(List<SelectItem> proyectos) {
        this.proyectos = proyectos;
    }

    public String getCultivo() {
        return cultivo;
    }

    public void setCultio(String cultivo) {
        this.cultivo = cultivo;
    }

    /**
     * @return the parcelaSeleccionada
     */
    public int getParcelaSeleccionada() {
        return parcelaSeleccionada;
    }

    /**
     * @return the cultivos
     */
    public List<SelectItem> getCultivos() {
        return cultivos;
    }

    /**
     * @param cultivos the cultivos to set
     */
    public void setCultivos(List<SelectItem> cultivos) {
        this.cultivos = cultivos;
    }
// </editor-fold>

    /**
     * @param parcelaSeleccionada the parcelaSeleccionada to set
     */
    public void setParcelaSeleccionada(int parcelaSeleccionada) {
        this.parcelaSeleccionada = parcelaSeleccionada;
    }

    public String crearProyecto() {
        //cultivoBeanLocal.agregarCultivo(nombre, parcela, fechaInicio);
        beanSesionUsuario.setTabSelected(3);
        return "homeClient";
    }

}
