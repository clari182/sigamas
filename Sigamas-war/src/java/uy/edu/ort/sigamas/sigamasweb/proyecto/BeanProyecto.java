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
import uy.edu.ort.sigamas.seguimiento.SeguimientoBeanLocal;
import uy.edu.ort.sigamas.seguridad.cultivo.CultivoBeanLocal;
import uy.edu.ort.sigamas.cultivos.entidades.Cultivo;
//import uy.edu.ort.sigamas.seguridad.entidades.Cultivo;
import uy.edu.ort.sigamas.campos.entidades.Parcela;
import uy.edu.ort.sigamas.seguridad.entidades.Proyecto;
import uy.edu.ort.sigamas.seguridad.parcela.ParcelaBeanLocal;
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
    private SeguimientoBeanLocal seguimientoBeanLocal;

    @EJB
    private CultivoBeanLocal cultivoBeanLocal;
    
    @EJB
    private ParcelaBeanLocal parcelaBeanLocal;

    @ManagedProperty(value = "#{beanSesionUsuario}")
    private BeanSesionUsuario beanSesionUsuario;

    public void setBeanSesionUsuario(BeanSesionUsuario beanSesionUsuario) {
        this.beanSesionUsuario = beanSesionUsuario;
    }

    private String nombre;
    private Date fechaInicio;
    private Parcela parcela;
    private SelectItem parcelaSeleccionada;

    private List<SelectItem> proyectos;
    private List<SelectItem> parcelas;
    private SelectItem cultivo;
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

    public SelectItem getCultivo() {
        return cultivo;
    }

    public void setCultivo(SelectItem cultivo) {
        this.cultivo = cultivo;
    }

    /**
     * @return the parcelaSeleccionada
     */
    public SelectItem getParcelaSeleccionada() {
        return parcelaSeleccionada;
    }

    /**
     * @param parcelaSeleccionada the parcelaSeleccionada to set
     */
    public void setParcelaSeleccionada(SelectItem parcelaSeleccionada) {
        this.parcelaSeleccionada = parcelaSeleccionada;
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

// </editor-fold>
    public String crearProyecto() {
        //cultivoBeanLocal.agregarCultivo(nombre, parcela, fechaInicio);
        Proyecto proyecto = new Proyecto();
        int out = -1;
        Integer.parseInt(cultivo.getLabel(), out);
        Cultivo c = cultivoBeanLocal.obtenerCultivo(out);
        proyecto.setNombre(nombre);
        proyecto.setFechaInicio(fechaInicio);
        out = -1;
        Integer.parseInt(parcelaSeleccionada.getLabel(), out);
        Parcela p = parcelaBeanLocal.obtenerParcela(out);
        proyecto.setIdParcela(p);
        seguimientoBeanLocal.nuevoProyecto(proyecto);
        beanSesionUsuario.setTabSelected(3);
        return "homeClient";
    }

    /**
     * @return the parcelaBeanLocal
     */
    public ParcelaBeanLocal getParcelaBeanLocal() {
        return parcelaBeanLocal;
    }

    /**
     * @param parcelaBeanLocal the parcelaBeanLocal to set
     */
    public void setParcelaBeanLocal(ParcelaBeanLocal parcelaBeanLocal) {
        this.parcelaBeanLocal = parcelaBeanLocal;
    }

}
