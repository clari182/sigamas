/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.sigamasweb.cultivo;

import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedProperty;
import uy.edu.ort.sigamas.seguridad.cultivo.CultivoBeanLocal;
import uy.edu.ort.sigamas.seguridad.entidades.Cultivo;
//import uy.edu.ort.sigamas.seguridad.entidades.Cultivo;
import uy.edu.ort.sigamas.seguridad.entidades.Parcela;
import uy.edu.ort.sigamas.sigamasweb.login.BeanSesionUsuario;

/**
 *
 * @author Pikachuss
 */
@Named(value = "beanCultivo")
@Dependent
public class BeanCultivo {

    /**
     * Creates a new instance of BeanCultivo
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
    private List<Cultivo> cultivos;
    private String cultivar;

    public BeanCultivo() {
    }

    @PostConstruct
    public void init() {

        //cultivos = cultivoBeanLocal.obtenerCultivos(beanSesionUsuario.getCuentaActual());
    }

    public String abrirCreacionCultivo() {
        return "crearCultivo";
    }

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

    public String crearCultivo() {
        cultivoBeanLocal.agregarCultivo(nombre, parcela, fechaInicio, cultivar);
        beanSesionUsuario.setTabSelected(4);
        return "homeClient";

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
     * @return the cultivos
     */
    public List<Cultivo> getCultivos() {
        return cultivos;
    }

    /**
     * @param cultivos the cultivos to set
     */
    public void setCultivos(List<Cultivo> cultivos) {
        this.cultivos = cultivos;
    }   

    /**
     * @return the cultivar
     */
    public String getCultivar() {
        return cultivar;
    }

    /**
     * @param cultivar the cultivar to set
     */
    public void setCultivar(String cultivar) {
        this.cultivar = cultivar;
    }
}
