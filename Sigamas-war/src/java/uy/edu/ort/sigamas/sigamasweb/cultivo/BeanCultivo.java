/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.sigamasweb.cultivo;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import uy.edu.ort.sigamas.seguridad.entidades.Cultivo;

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
    private List<Cultivo> cultivos;
    
    public BeanCultivo() {
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
    
    public String abrirCreacionCultivo(){
        return "crearCultivo";
    }
    
}
