/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.sigamasweb.cuenta;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import uy.edu.ort.sigamas.sigamasweb.utils.UtilsMensajes;
import uy.edu.ort.sigamas.seguridad.cuenta.CuentaBeanLocal;
import uy.edu.ort.sigamas.seguridad.cuenta.excepciones.CreacionCuentaInvalidaException;
import uy.edu.ort.sigamas.seguridad.cuenta.excepciones.CuentaExistenteException;
import uy.edu.ort.sigamas.seguridad.entidades.Cuenta;

/**
 *
 * @author Pikachuss
 */
@ManagedBean(name = "beanCuenta")
@RequestScoped
public class BeanCuenta {

    @EJB
    private CuentaBeanLocal cuentaBeanLocal;
    private String nombre;
    private String empresa;
    private String rut;
    private List<Cuenta> cuentas;
    private String nombreUsuario;
    private String emailUsuario;
    private String nombreSeleccionada;
    private String empresaSeleccionada;
    private String rutSeleccionada;
    private Cuenta cuentaSeleccionada;

    /**
     * Creates a new instance of BeanCuenta
     */
    public BeanCuenta() {

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
     * @return the empresa
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /**
     * @return the rut
     */
    public String getRut() {
        return rut;
    }

    /**
     * @param rut the rut to set
     */
    public void setRut(String rut) {
        this.rut = rut;
    }

    /**
     * @return the cuentas
     */
    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    /**
     * @param cuentas the cuentas to set
     */
    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }
    
    
    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @return the emailUsuario
     */
    public String getEmailUsuario() {
        return emailUsuario;
    }

    /**
     * @param emailUsuario the emailUsuario to set
     */
    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    /**
     * @return the nombreSeleccionada
     */
    public String getNombreSeleccionada() {
        return nombreSeleccionada;
    }

    /**
     * @param nombreSeleccionada the nombreSeleccionada to set
     */
    public void setNombreSeleccionada(String nombreSeleccionada) {
        this.nombreSeleccionada = nombreSeleccionada;
    }

    /**
     * @return the empresaSeleccionada
     */
    public String getEmpresaSeleccionada() {
        return empresaSeleccionada;
    }

    /**
     * @param empresaSeleccionada the empresaSeleccionada to set
     */
    public void setEmpresaSeleccionada(String empresaSeleccionada) {
        this.empresaSeleccionada = empresaSeleccionada;
    }

    /**
     * @return the rutSeleccionada
     */
    public String getRutSeleccionada() {
        return rutSeleccionada;
    }

    /**
     * @param rutSeleccionada the rutSeleccionada to set
     */
    public void setRutSeleccionada(String rutSeleccionada) {
        this.rutSeleccionada = rutSeleccionada;
    }

    /**
     * @return the cuentaSeleccionada
     */
    public Cuenta getCuentaSeleccionada() {
        return cuentaSeleccionada;
    }

    /**
     * @param cuentaSeleccionada the cuentaSeleccionada to set
     */
    public void setCuentaSeleccionada(Cuenta cuentaSeleccionada) {
        this.cuentaSeleccionada = cuentaSeleccionada;
    }

    // </editor-fold>

    @PostConstruct
    public void init(){
        cuentas = cuentaBeanLocal.obtenerCuentas();
    }
    /**
     * crearCuenta Permite la alta de una nueva cuenta
     *
     * @return boolean
     */
    public boolean crearCuenta() {
        try {
            Cuenta cuenta = cuentaBeanLocal.crearCuenta(nombre, empresa, rut);
            getCuentas().add(cuenta);
            return true;
        } catch (CreacionCuentaInvalidaException exp) {
            UtilsMensajes.mostrarMensajeError("Error", "Error durante la creación de la cuenta");
            return false;
        } catch (CuentaExistenteException exp){
            UtilsMensajes.mostrarMensajeError("Error", "Error, ya existe una cuenta con este nombre");
            return false;
        }
    }

    /**
     * obtenerCuentas permite obtener todas las cuentas de la base de datos
     */
    public void obtenerCuentas() {
        this.cuentas = cuentaBeanLocal.obtenerCuentas();
    }
    
    /**
     * abrirCreacionCuenta permite redirigir a la pagina de creacion de una nueva cuenta
     * @return String
     */
    public String abrirCreacionCuenta() {
        return "crearCuenta";
    }

    /**
     * onRowSelect permite guardar la fila seleccionada en cuentaSeleccionada
     * @param event 
     */
    public void onRowSelect(SelectEvent event) {
        cuentaSeleccionada = (Cuenta) event.getObject();
    }

    /**
     * onRowUnselect permite desvincular la cuentaSelecciona de la fila deseleccionada
     * @param event 
     */
    public void onRowUnselect(UnselectEvent event) {
        cuentaSeleccionada = null;

    }

    /**
     * onFlowProcess controla el manejo del wizard para la creacion de cuenta
     * @param event
     * @return 
     */
    public String onFlowProcess(FlowEvent event) {

        if ("cuenta".equals(event.getOldStep())) {
            try {
                cuentaBeanLocal.verificarNombreCuenta(getNombre());
            } catch (CuentaExistenteException exp) {
                UtilsMensajes.mostrarMensajeError("Error", "Ya existe una cuenta con este nombre");
                return event.getOldStep();
            }

        }
        return event.getNewStep();

    }
}
