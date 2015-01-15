/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.insumos.entidades;

import uy.edu.ort.sigamas.campos.entidades.Campo;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Pikachuss
 */
@Entity
@Table(name = "valor", catalog = "sigamas_sigamas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Valor.findAll", query = "SELECT v FROM Valor v"),
    @NamedQuery(name = "Valor.findByIdValor", query = "SELECT v FROM Valor v WHERE v.idValor = :idValor"),
    @NamedQuery(name = "Valor.findByValor", query = "SELECT v FROM Valor v WHERE v.valor = :valor"),
    @NamedQuery(name = "Valor.findByUnidad", query = "SELECT v FROM Valor v WHERE v.unidad = :unidad"),
    @NamedQuery(name = "Valor.findByActivo", query = "SELECT v FROM Valor v WHERE v.activo = :activo")})
public class Valor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_valor", nullable = false)
    private Integer idValor;
    @Column(name = "valor", length = 45)
    private String valor;
    @Column(name = "unidad", length = 45)
    private String unidad;
    @Column(name = "activo")
    private Integer activo;
    @ManyToMany(mappedBy = "valorList", fetch = FetchType.EAGER)
    private List<Campo> campoList;

    public Valor() {
    }

    public Valor(Integer idValor) {
        this.idValor = idValor;
    }

    public Integer getIdValor() {
        return idValor;
    }

    public void setIdValor(Integer idValor) {
        this.idValor = idValor;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }

    @XmlTransient
    public List<Campo> getCampoList() {
        return campoList;
    }

    public void setCampoList(List<Campo> campoList) {
        this.campoList = campoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idValor != null ? idValor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Valor)) {
            return false;
        }
        Valor other = (Valor) object;
        if ((this.idValor == null && other.idValor != null) || (this.idValor != null && !this.idValor.equals(other.idValor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.edu.ort.sigamas.seguridad.entidades.Valor[ idValor=" + idValor + " ]";
    }
    
}
