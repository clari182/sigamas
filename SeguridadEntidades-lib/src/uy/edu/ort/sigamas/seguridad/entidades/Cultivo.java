/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pikachuss
 */
@Entity
@Table(name = "cultivo", catalog = "sigamas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cultivo.findAll", query = "SELECT c FROM Cultivo c"),
    @NamedQuery(name = "Cultivo.findByIdCultivo", query = "SELECT c FROM Cultivo c WHERE c.idCultivo = :idCultivo"),
    @NamedQuery(name = "Cultivo.findByNombre", query = "SELECT c FROM Cultivo c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Cultivo.findByFechaInicio", query = "SELECT c FROM Cultivo c WHERE c.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Cultivo.findByParcela", query = "SELECT c FROM Cultivo c WHERE c.idParcela = :idParcela")})
public class Cultivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cultivo", nullable = false)
    private Integer idCultivo;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @JoinColumn(name = "id_parcela", referencedColumnName = "id_parcela")
    @ManyToOne(fetch = FetchType.EAGER)
    private Parcela idParcela;

    public Cultivo() {
    }

    public Cultivo(Integer idCultivo) {
        this.idCultivo = idCultivo;
    }

    public Cultivo(Integer idCultivo, String nombre) {
        this.idCultivo = idCultivo;
        this.nombre = nombre;
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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Parcela getIdParcela() {
        return idParcela;
    }

    public void setIdParcela(Parcela idParcela) {
        this.idParcela = idParcela;
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
