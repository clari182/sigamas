/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.sigamasweb.parcela;

import com.sun.org.apache.bcel.internal.generic.Select;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.MapModel;
import uy.edu.ort.sigamas.campos.entidades.Departamento;
import uy.edu.ort.sigamas.campos.entidades.Parcela;
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

    @ManagedProperty(value = "#{beanSesionUsuario}")
    private BeanSesionUsuario beanSesionUsuario;

    public void setBeanSesionUsuario(BeanSesionUsuario beanSesionUsuario) {
        this.beanSesionUsuario = beanSesionUsuario;
    }
    @EJB
    private ParcelaBeanLocal parcelaBeanLocal;

    private String nombre;
    private String padron;
    private String departamento;
    private List<SelectItem> parcelas;
    private List<Parcela> parcelasHome;
    private List<SelectItem> departamentos;
    private String departamentoSeleccionado;
    private String actualLatitud = "-32.5583168";
    private String actualLongitud = "-55.8117213";
    private String actualZoom = "6";
    private MapModel mapModel = new DefaultMapModel();
    private List<SelectItem> parcelasSelect;

    /**
     * Creates a new instance of BeanParcela
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
    public List<SelectItem> getParcelas() {
        return parcelas;
    }

    /**
     * @param parcelas the parcelas to set
     */
    public void setParcelas(List<SelectItem> parcelas) {
        this.parcelas = parcelas;
    }

    /**
     * @return the departamentos
     */
    public List<SelectItem> getDepartamentos() {
        return departamentos;
    }

    /**
     * @param departamentos the departamentos to set
     */
    public void setDepartamentos(List<SelectItem> departamentos) {
        this.departamentos = departamentos;
    }

    /**
     * @return the departamentoSeleccionado
     */
    public String getDepartamentoSeleccionado() {
        return departamentoSeleccionado;
    }

    /**
     * @param departamentoSeleccionado the departamentoSeleccionado to set
     */
    public void setDepartamentoSeleccionado(String departamentoSeleccionado) {
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

    /**
     * @return the actualLatitud
     */
    public String getActualLatitud() {
        return actualLatitud;
    }

    /**
     * @param actualLatitud the actualLatitud to set
     */
    public void setActualLatitud(String actualLatitud) {
        this.actualLatitud = actualLatitud;
    }

    /**
     * @return the actualLongitud
     */
    public String getActualLongitud() {
        return actualLongitud;
    }

    /**
     * @param actualLongitud the actualLongitud to set
     */
    public void setActualLongitud(String actualLongitud) {
        this.actualLongitud = actualLongitud;
    }

    /**
     * @return the actualZoom
     */
    public String getActualZoom() {
        return actualZoom;
    }

    /**
     * @param actualZoom the actualZoom to set
     */
    public void setActualZoom(String actualZoom) {
        this.actualZoom = actualZoom;
    }

    public List<SelectItem> getParcelasSelect() {
        return parcelasSelect;
    }

    public void setParcelasSelect(List<SelectItem> parcelasSelect) {
        this.parcelasSelect = parcelasSelect;
    }

    //</editor-fold>
    
    @PostConstruct
    public void init() {
        parcelasHome = parcelaBeanLocal.obtenerParcelas();
        departamentos = new ArrayList<>();
        List<Departamento> departamentosAux = parcelaBeanLocal.obtenerDepartamentos();
        for (Departamento dep : departamentosAux) {
            departamentos.add(new SelectItem(dep.getIdDepartamento(), dep.getNombre()));
        }
        parcelas = new ArrayList<>();
        for (Parcela p : parcelasHome) {
            parcelas.add(new SelectItem(p, p.getNombre() + "-" + p.getDepartamento()));
        }
    }

    public String crearParcela() {
        try {
            parcelaBeanLocal.crearParcela(nombre, padron, departamento, beanSesionUsuario.getCuentaActual());
            return "homeClient";
        } catch (ParcelaPadronExistenteException exp) {
            UtilsMensajes.mostrarMensajeError(null, "Error", "Ya existe una parcela asociada a al padrón " + padron + ", porfavor elija otro padrón");
            return "";
        }
    }

    public void centrarMapa() {
        if (!(departamentoSeleccionado == null)) {
            Departamento dep = parcelaBeanLocal.obtenerDepartamento(departamentoSeleccionado);
            actualLatitud = dep.getLatitud();
            actualLongitud = dep.getLongitud();
            actualZoom = dep.getZoom();
        }
    }

    /**
     * @return the parcelasHome
     */
    public List<Parcela> getParcelasHome() {
        return parcelasHome;
    }

    /**
     * @param parcelasHome the parcelasHome to set
     */
    public void setParcelasHome(List<Parcela> parcelasHome) {
        this.parcelasHome = parcelasHome;
    }
}
