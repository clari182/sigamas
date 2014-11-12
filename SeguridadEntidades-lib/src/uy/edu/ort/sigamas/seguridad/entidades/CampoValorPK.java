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
public class CampoValorPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_campo", nullable = false)
    private int idCampo;
    @Basic(optional = false)
    @Column(name = "id_valor", nullable = false)
    private int idValor;

    public CampoValorPK() {
    }

    public CampoValorPK(int idCampo, int idValor) {
        this.idCampo = idCampo;
        this.idValor = idValor;
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
        hash += (int) idCampo;
        hash += (int) idValor;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CampoValorPK)) {
            return false;
        }
        CampoValorPK other = (CampoValorPK) object;
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
        return "uy.edu.ort.sigamas.seguridad.entidades.CampoValorPK[ idCampo=" + idCampo + ", idValor=" + idValor + " ]";
    }
    
}
