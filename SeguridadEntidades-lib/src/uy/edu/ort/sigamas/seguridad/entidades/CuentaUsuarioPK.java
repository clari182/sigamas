/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Pikachuss
 */
@Embeddable
public class CuentaUsuarioPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_cuenta", nullable = false)
    private int idCuenta;
    @Basic(optional = false)
    @Column(name = "id_usuario", nullable = false)
    private int idUsuario;

    public CuentaUsuarioPK() {
    }

    public CuentaUsuarioPK(int idCuenta, int idUsuario) {
        this.idCuenta = idCuenta;
        this.idUsuario = idUsuario;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCuenta;
        hash += (int) idUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentaUsuarioPK)) {
            return false;
        }
        CuentaUsuarioPK other = (CuentaUsuarioPK) object;
        if (this.idCuenta != other.idCuenta) {
            return false;
        }
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.edu.ort.sigamas.seguridad.entidades.CuentaUsuarioPK[ idCuenta=" + idCuenta + ", idUsuario=" + idUsuario + " ]";
    }
    
}
