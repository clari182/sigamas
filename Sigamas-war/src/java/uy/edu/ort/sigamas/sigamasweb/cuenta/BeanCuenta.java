/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.sigamasweb.cuenta;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import uy.edu.ort.sigamas.sigamasweb.utils.UtilsMensajes;
import uy.edu.ort.sigamas.seguridad.cuenta.CuentaBeanLocal;
import uy.edu.ort.sigamas.seguridad.cuenta.excepciones.CreacionCuentaInvalidaException;
import uy.edu.ort.sigamas.seguridad.entidades.Cuenta;

/**
 *
 * @author Pikachuss
 */
@ManagedBean(name="beanCuenta")
@RequestScoped
public class BeanCuenta {

    @EJB
    private CuentaBeanLocal cuentaBeanLocal;
    private String nombre;
    private String empresa;
    private String rut;
    private List<Cuenta> cuentas;
    
   
    /**
     * Creates a new instance of BeanCuenta
     */
    public BeanCuenta() {
        cuentas = new ArrayList<Cuenta>();
        
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
    // </editor-fold>
    
    /** crearCuenta
 Permite la alta de una nueva cuenta
     * @return boolean
     */
    public boolean crearCuenta(){
        try
        {
            Cuenta cuenta = cuentaBeanLocal.crearCuenta(nombre, empresa, rut);
            //cuentas.add(cuenta);
            return true;
        }
        catch(CreacionCuentaInvalidaException exp){
            UtilsMensajes.mostrarMensajeError("Error", "Error durante la creación de la cuenta");
            return false;
        }
    }
    /** obtenerCuentas
     *  Permite obtener todas las cuentas.     
     */
    public void obtenerCuentas(){
        this.cuentas = cuentaBeanLocal.obtenerCuentas();
    }

}
