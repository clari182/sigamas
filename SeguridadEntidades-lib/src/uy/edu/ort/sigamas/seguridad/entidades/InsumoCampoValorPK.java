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
public class InsumoCampoValorPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_insumo", nullable = false)
    private int idInsumo;
    @Basic(optional = false)
    @Column(name = "id_campo", nullable = false)
    private int idCampo;
    @Basic(optional = false)
    @Column(name = "id_valor", nullable = false)
    private int idValor;

    public InsumoCampoValorPK() {
    }

    public InsumoCampoValorPK(int idInsumo, int idCampo, int idValor) {
        this.idInsumo = idInsumo;
        this.idCampo = idCampo;
        this.idValor = idValor;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    public int getIdCampo() {
        return idCampo;
    }

    public void setIdCampo(int idCampo) {
        this.idCampo = idCampo;
    }

    public int getIdValor() {
        return idValor;
    }

    public void setIdValor(int idValor) {
        this.idValor = idValor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idInsumo;
        hash += (int) idCampo;
        hash += (int) idValor;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InsumoCampoValorPK)) {
            return false;
        }
        InsumoCampoValorPK other = (InsumoCampoValorPK) object;
        if (this.idInsumo != other.idInsumo) {
            return false;
        }
        if (this.idCampo != other.idCampo) {
            return false;
        }
        if (this.idValor != other.idValor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.edu.ort.sigamas.seguridad.entidades.InsumoCampoValorPK[ idInsumo=" + idInsumo + ", idCampo=" + idCampo + ", idValor=" + idValor + " ]";
    }
    
}
