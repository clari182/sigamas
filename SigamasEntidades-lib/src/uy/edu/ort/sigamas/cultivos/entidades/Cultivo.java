/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.cultivos.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
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
import uy.edu.ort.sigamas.seguimiento.entidades.Proyecto;

/**
 *
 * @author Mattahari
 */
@Entity
@Table(name = "cultivo", catalog = "sigamas_sigamas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cultivo.findAll", query = "SELECT c FROM Cultivo c"),
    @NamedQuery(name = "Cultivo.findByIdCultivo", query = "SELECT c FROM Cultivo c WHERE c.idCultivo = :idCultivo"),
    @NamedQuery(name = "Cultivo.findByNombre", query = "SELECT c FROM Cultivo c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Cultivo.findByTipo", query = "SELECT c FROM Cultivo c WHERE c.tipo = :tipo"),
    @NamedQuery(name = "Cultivo.findByCoeficiente", query = "SELECT c FROM Cultivo c WHERE c.coeficiente = :coeficiente")})
public class Cultivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cultivo", nullable = false)
    private Integer idCultivo;
    @Column(name = "nombre", length = 45)
    private String nombre;
    @Column(name = "tipo")
    private Integer tipo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "coeficiente", precision = 6, scale = 4)
    private BigDecimal coeficiente;
    @OneToMany(mappedBy = "idCultivo", fetch = FetchType.EAGER)
    private List<Proyecto> proyectoList;
    @OneToMany(mappedBy = "idCultivo", fetch = FetchType.EAGER)
    private List<Subfase> subfaseList;

    public Cultivo() {
    }

    public Cultivo(Integer idCultivo) {
        this.idCultivo = idCultivo;
    }

    public Integer getIdCultivo() {
        return idCultivo;
    }

    public void setIdCultivo(Integer idCultivo) {
        this.idCultivo = idCultivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getCoeficiente() {
        return coeficiente;
    }

    public void setCoeficiente(BigDecimal coeficiente) {
        this.coeficiente = coeficiente;
    }

    @XmlTransient
    public List<Proyecto> getProyectoList() {
        return proyectoList;
    }

    public void setProyectoList(List<Proyecto> proyectoList) {
        this.proyectoList = proyectoList;
    }

    @XmlTransient
    public List<Subfase> getSubfaseList() {
        return subfaseList;
    }

    public void setSubfaseList(List<Subfase> subfaseList) {
        this.subfaseList = subfaseList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCultivo != null ? idCultivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cultivo)) {
            return false;
        }
        Cultivo other = (Cultivo) object;
        if ((this.idCultivo == null && other.idCultivo != null) || (this.idCultivo != null && !this.idCultivo.equals(other.idCultivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.edu.ort.sigamas.seguridad.entidades.Cultivo[ idCultivo=" + idCultivo + " ]";
    }
    
}
