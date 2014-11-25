/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.sigamasweb.insumo;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedProperty;
import uy.edu.ort.sigamas.seguridad.entidades.Insumo;
import uy.edu.ort.sigamas.seguridad.insumo.InsumoBeanLocal;
import uy.edu.ort.sigamas.seguridad.parcela.ParcelaBeanLocal;
import uy.edu.ort.sigamas.sigamasweb.login.BeanSesionUsuario;

/**
 *
 * @author Pikachuss
 */
@Named(value = "beanInsumo")
@Dependent
public class BeanInsumo {

    @EJB
    private InsumoBeanLocal insumoBeanLocal;
    
    @ManagedProperty(value="#{beanSesionUsuario}")
    private BeanSesionUsuario beanSesionUsuario;

    public void setBeanSesionUsuario(BeanSesionUsuario beanSesionUsuario) {
        this.beanSesionUsuario = beanSesionUsuario;
    }
    
    private Insumo insumoSeleccionado;
    private List<Insumo> insumos;
    /**
     * Creates a new instance of BeanInsumo
     */
    public BeanInsumo() {
    }

    /**
     * @return the insumoSeleccionado
     */
    public Insumo getInsumoSeleccionado() {
        return insumoSeleccionado;
    }

    /**
     * @param insumoSeleccionado the insumoSeleccionado to set
     */
    public void setInsumoSeleccionado(Insumo insumoSeleccionado) {
        this.insumoSeleccionado = insumoSeleccionado;
    }

    /**
     * @return the insumos
     */
    public List<Insumo> getInsumos() {
        return insumos;
    }

    /**
     * @param insumos the insumos to set
     */
    public void setInsumos(List<Insumo> insumos) {
        this.insumos = insumos;
    }
    
    public void obtenerInsumos(){
        
    }
    
    @PostConstruct
    public void init() {
        insumos = insumoBeanLocal.obtenerInsumos(beanSesionUsuario.getCuentaActual().getIdCuenta());
    }
    
}
