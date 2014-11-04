/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.sigamasbackofficeweb.superusuario;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import uy.edu.ort.sigamas.seguridad.entidades.Usuario;

/**
 *
 * @author Pikachuss
 */
@Named(value = "beanSuperUsuario")
@Dependent
public class BeanSuperUsuario {

    private List<Usuario> superUsuarios;
    /**
     * Creates a new instance of BeanSuperUsuario
     */
    public BeanSuperUsuario() {
    }

    /**
     * @return the superUsuarios
     */
    public List<Usuario> getSuperUsuarios() {
        return superUsuarios;
    }

    /**
     * @param superUsuarios the superUsuarios to set
     */
    public void setSuperUsuarios(List<Usuario> superUsuarios) {
        this.superUsuarios = superUsuarios;
    }
    
}
