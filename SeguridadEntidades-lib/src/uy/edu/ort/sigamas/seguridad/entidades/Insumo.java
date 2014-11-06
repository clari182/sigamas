/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "insumo", catalog = "sigamas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Insumo.findAll", query = "SELECT i FROM Insumo i"),
    @NamedQuery(name = "Insumo.findByIdInsumo", query = "SELECT i FROM Insumo i WHERE i.idInsumo = :idInsumo"),
    @NamedQuery(name = "Insumo.findByCodigo", query = "SELECT i FROM Insumo i WHERE i.codigo = :codigo"),
    @NamedQuery(name = "Insumo.findByNombre", query = "SELECT i FROM Insumo i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "Insumo.findByTipo", query = "SELECT i FROM Insumo i WHERE i.tipo = :tipo"),
    @NamedQuery(name = "Insumo.findByDescripcion", query = "SELECT i FROM Insumo i WHERE i.descripcion = :descripcion"),
    @NamedQuery(name = "Insumo.findByFamilia", query = "SELECT i FROM Insumo i WHERE i.familia = :familia"),
    @NamedQuery(name = "Insumo.findByActivo", query = "SELECT i FROM Insumo i WHERE i.activo = :activo")})
public class Insumo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_insumo", nullable = false)
    private Integer idInsumo;
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "nombre", length = 45)
    private String nombre;
    @Column(name = "tipo", length = 45)
    private String tipo;
    @Column(name = "descripcion", length = 45)
    private String descripcion;
    @Column(name = "familia", length = 45)
    private String familia;
    @Column(name = "activo")
    private Integer activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "insumo", fetch = FetchType.EAGER)
    private List<InsumoCampoValor> insumoCampoValorList;

    public Insumo() {
    }

    public Insumo(Integer idInsumo) {
        this.idInsumo = idInsumo;
    }

    public Integer getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(Integer idInsumo) {
        this.idInsumo = idInsumo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }

    @XmlTransient
    public List<InsumoCampoValor> getInsumoCampoValorList() {
        return insumoCampoValorList;
    }

    public void setInsumoCampoValorList(List<InsumoCampoValor> insumoCampoValorList) {
        this.insumoCampoValorList = insumoCampoValorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInsumo != null ? idInsumo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Insumo)) {
            return false;
        }
        Insumo other = (Insumo) object;
        if ((this.idInsumo == null && other.idInsumo != null) || (this.idInsumo != null && !this.idInsumo.equals(other.idInsumo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.edu.ort.sigamas.seguridad.entidades.Insumo[ idInsumo=" + idInsumo + " ]";
    }
    
}
