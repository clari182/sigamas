/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Pikachuss
 */
@Entity
@Table(name = "campo_valor", catalog = "sigamas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CampoValor.findAll", query = "SELECT c FROM CampoValor c"),
    @NamedQuery(name = "CampoValor.findByIdCampo", query = "SELECT c FROM CampoValor c WHERE c.campoValorPK.idCampo = :idCampo"),
    @NamedQuery(name = "CampoValor.findByIdValor", query = "SELECT c FROM CampoValor c WHERE c.campoValorPK.idValor = :idValor")})
public class CampoValor implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CampoValorPK campoValorPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "campoValor", fetch = FetchType.EAGER)
    private List<InsumoCampoValor> insumoCampoValorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "campoValor1", fetch = FetchType.EAGER)
    private List<InsumoCampoValor> insumoCampoValorList1;
    @JoinColumn(name = "id_campo", referencedColumnName = "id_campo", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Campo campo;
    @JoinColumn(name = "id_valor", referencedColumnName = "id_valor", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Valor valor;

    public CampoValor() {
    }

    public CampoValor(CampoValorPK campoValorPK) {
        this.campoValorPK = campoValorPK;
    }

    public CampoValor(int idCampo, int idValor) {
        this.campoValorPK = new CampoValorPK(idCampo, idValor);
    }

    public CampoValorPK getCampoValorPK() {
        return campoValorPK;
    }

    public void setCampoValorPK(CampoValorPK campoValorPK) {
        this.campoValorPK = campoValorPK;
    }

    @XmlTransient
    public List<InsumoCampoValor> getInsumoCampoValorList() {
        return insumoCampoValorList;
    }

    public void setInsumoCampoValorList(List<InsumoCampoValor> insumoCampoValorList) {
        this.insumoCampoValorList = insumoCampoValorList;
    }

    @XmlTransient
    public List<InsumoCampoValor> getInsumoCampoValorList1() {
        return insumoCampoValorList1;
    }

    public void setInsumoCampoValorList1(List<InsumoCampoValor> insumoCampoValorList1) {
        this.insumoCampoValorList1 = insumoCampoValorList1;
    }

    public Campo getCampo() {
        return campo;
    }

    public void setCampo(Campo campo) {
        this.campo = campo;
    }

    public Valor getValor() {
        return valor;
    }

    public void setValor(Valor valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (campoValorPK != null ? campoValorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CampoValor)) {
            return false;
        }
        CampoValor other = (CampoValor) object;
        if ((this.campoValorPK == null && other.campoValorPK != null) || (this.campoValorPK != null && !this.campoValorPK.equals(other.campoValorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.edu.ort.sigamas.seguridad.entidades.CampoValor[ campoValorPK=" + campoValorPK + " ]";
    }
    
}
