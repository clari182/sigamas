/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.sigamasweb.parcela;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import uy.edu.ort.sigamas.seguridad.entidades.Departamento;
import uy.edu.ort.sigamas.seguridad.entidades.Parcela;
import uy.edu.ort.sigamas.seguridad.parcela.ParcelaBeanLocal;
import uy.edu.ort.sigamas.seguridad.parcela.excepciones.ParcelaPadronExistenteException;
import uy.edu.ort.sigamas.sigamasweb.login.BeanSesionUsuario;
import uy.edu.ort.sigamas.sigamasweb.utils.UtilsMensajes;

/**
 *
 * @author Pikachuss
 */
@ManagedBean(name = "beanParcela")
@ViewScoped
public class BeanParcela implements Serializable {

    @EJB
    private ParcelaBeanLocal parcelaBeanLocal;

    @ManagedProperty(value = "#{beanSesionUsuario}")
    private BeanSesionUsuario beanSesionUsuario;

    public void setBeanSesionUsuario(BeanSesionUsuario beanSesionUsuario) {
        this.beanSesionUsuario = beanSesionUsuario;
    }

    private String nombre;
    private String padron;
    private String departamento;
    private List<Parcela> parcelas;
    private List<Departamento> departamentos;
    private Departamento departamentoSeleccionado;
    private MapModel mapModel = new DefaultMapModel();

    /**
     * Creates a new instance of BeanPredio
     */
    public BeanParcela() {
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
     * @return the padron
     */
    public String getPadron() {
        return padron;
    }

    /**
     * @param padron the padron to set
     */
    public void setPadron(String padron) {
        this.padron = padron;
    }

    /**
     * @return the parcelas
     */
    public List<Parcela> getParcelas() {
        return parcelas;
    }

    /**
     * @param parcelas the parcelas to set
     */
    public void setParcelas(List<Parcela> parcelas) {
        this.parcelas = parcelas;
    }

    /**
     * @return the departamentos
     */
    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    /**
     * @param departamentos the departamentos to set
     */
    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }
    
    
    /**
     * @return the departamentoSeleccionado
     */
    public Departamento getDepartamentoSeleccionado() {
        return departamentoSeleccionado;
    }

    /**
     * @param departamentoSeleccionado the departamentoSeleccionado to set
     */
    public void setDepartamentoSeleccionado(Departamento departamentoSeleccionado) {
        this.departamentoSeleccionado = departamentoSeleccionado;
    }    
    
    /**
     * @return the departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;               
    }
        
    /**
     * @return the mapModel
     */
    public MapModel getMapModel() {
        return mapModel;
    }

    /**
     * @param mapModel the mapModel to set
     */
    public void setMapModel(MapModel mapModel) {
        this.mapModel = mapModel;
    }
    //</editor-fold>

    @PostConstruct
    public void init() {
        parcelas = parcelaBeanLocal.obtenerParcelas();
        departamentos = new ArrayList<>();
        departamentos = parcelaBeanLocal.obtenerDepartamentos();
    }

    public void crearParcela() {
        try {
            parcelaBeanLocal.crearParcela(nombre, padron, departamento, beanSesionUsuario.getCuentaActual());
        } catch (ParcelaPadronExistenteException exp) {
            UtilsMensajes.mostrarMensajeError("Error", "Ya existe una parcela asociada a al padrón " + padron + ", porfavor elija otro padrón");
        }
    }


    public String abrirCreacionParcela() {
        return "crearParcela";
    }
    
    public void centrarMapa(){
        if (!(departamentoSeleccionado == null)){
        mapModel.addOverlay(new Marker(new LatLng(Double.parseDouble(departamentoSeleccionado.getLatitud()), Double.parseDouble(departamentoSeleccionado.getLongitud()))));
        }
    }       
}
