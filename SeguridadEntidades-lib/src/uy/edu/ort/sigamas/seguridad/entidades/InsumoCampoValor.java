/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.entidades;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pikachuss
 */
@Entity
@Table(name = "insumo_campo_valor", catalog = "sigamas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InsumoCampoValor.findAll", query = "SELECT i FROM InsumoCampoValor i"),
    @NamedQuery(name = "InsumoCampoValor.findByIdInsumo", query = "SELECT i FROM InsumoCampoValor i WHERE i.insumoCampoValorPK.idInsumo = :idInsumo"),
    @NamedQuery(name = "InsumoCampoValor.findByIdCampo", query = "SELECT i FROM InsumoCampoValor i WHERE i.insumoCampoValorPK.idCampo = :idCampo"),
    @NamedQuery(name = "InsumoCampoValor.findByIdValor", query = "SELECT i FROM InsumoCampoValor i WHERE i.insumoCampoValorPK.idValor = :idValor")})
public class InsumoCampoValor implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InsumoCampoValorPK insumoCampoValorPK;
    @JoinColumn(name = "id_insumo", referencedColumnName = "id_insumo", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Insumo insumo;
    @JoinColumn(name = "id_campo", referencedColumnName = "id_campo", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private CampoValor campoValor;
    @JoinColumn(name = "id_valor", referencedColumnName = "id_valor", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private CampoValor campoValor1;

    public InsumoCampoValor() {
    }

    public InsumoCampoValor(InsumoCampoValorPK insumoCampoValorPK) {
        this.insumoCampoValorPK = insumoCampoValorPK;
    }

    public InsumoCampoValor(int idInsumo, int idCampo, int idValor) {
        this.insumoCampoValorPK = new InsumoCampoValorPK(idInsumo, idCampo, idValor);
    }

    public InsumoCampoValorPK getInsumoCampoValorPK() {
        return insumoCampoValorPK;
    }

    public void setInsumoCampoValorPK(InsumoCampoValorPK insumoCampoValorPK) {
        this.insumoCampoValorPK = insumoCampoValorPK;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public CampoValor getCampoValor() {
        return campoValor;
    }

    public void setCampoValor(CampoValor campoValor) {
        this.campoValor = campoValor;
    }

    public CampoValor getCampoValor1() {
        return campoValor1;
    }

    public void setCampoValor1(CampoValor campoValor1) {
        this.campoValor1 = campoValor1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (insumoCampoValorPK != null ? insumoCampoValorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InsumoCampoValor)) {
            return false;
        }
        InsumoCampoValor other = (InsumoCampoValor) object;
        if ((this.insumoCampoValorPK == null && other.insumoCampoValorPK != null) || (this.insumoCampoValorPK != null && !this.insumoCampoValorPK.equals(other.insumoCampoValorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.edu.ort.sigamas.seguridad.entidades.InsumoCampoValor[ insumoCampoValorPK=" + insumoCampoValorPK + " ]";
    }
    
}
