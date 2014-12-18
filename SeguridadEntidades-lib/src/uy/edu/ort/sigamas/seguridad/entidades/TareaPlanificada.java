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
@Table(name = "tarea_planificada", catalog = "sigamas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TareaPlanificada.findAll", query = "SELECT t FROM TareaPlanificada t"),
    @NamedQuery(name = "TareaPlanificada.findByIdTareaPlanificada", query = "SELECT t FROM TareaPlanificada t WHERE t.idTareaPlanificada = :idTareaPlanificada"),
    @NamedQuery(name = "TareaPlanificada.findByNombre", query = "SELECT t FROM TareaPlanificada t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TareaPlanificada.findByFecha", query = "SELECT t FROM TareaPlanificada t WHERE t.fecha = :fecha"),
    @NamedQuery(name = "TareaPlanificada.findByValidada", query = "SELECT t FROM TareaPlanificada t WHERE t.validada = :validada")})
public class TareaPlanificada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tarea_planificada", nullable = false)
    private Integer idTareaPlanificada;
    @Column(name = "nombre", length = 45)
    private String nombre;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "validada")
    private Integer validada;
    @JoinColumn(name = "id_fase", referencedColumnName = "id_fase")
    @ManyToOne(fetch = FetchType.EAGER)
    private Fase idFase;
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto")
    @ManyToOne(fetch = FetchType.EAGER)
    private Proyecto idProyecto;
    @JoinColumn(name = "id_tarea_real", referencedColumnName = "id_tarea_real")
    @ManyToOne(fetch = FetchType.EAGER)
    private TareaReal idTareaReal;

    public TareaPlanificada() {
    }

    public TareaPlanificada(Integer idTareaPlanificada) {
        this.idTareaPlanificada = idTareaPlanificada;
    }

    public Integer getIdTareaPlanificada() {
        return idTareaPlanificada;
    }

    public void setIdTareaPlanificada(Integer idTareaPlanificada) {
        this.idTareaPlanificada = idTareaPlanificada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getValidada() {
        return validada;
    }

    public void setValidada(Integer validada) {
        this.validada = validada;
    }

    public Fase getIdFase() {
        return idFase;
    }

    public void setIdFase(Fase idFase) {
        this.idFase = idFase;
    }

    public Proyecto getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Proyecto idProyecto) {
        this.idProyecto = idProyecto;
    }

    public TareaReal getIdTareaReal() {
        return idTareaReal;
    }

    public void setIdTareaReal(TareaReal idTareaReal) {
        this.idTareaReal = idTareaReal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTareaPlanificada != null ? idTareaPlanificada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TareaPlanificada)) {
            return false;
        }
        TareaPlanificada other = (TareaPlanificada) object;
        if ((this.idTareaPlanificada == null && other.idTareaPlanificada != null) || (this.idTareaPlanificada != null && !this.idTareaPlanificada.equals(other.idTareaPlanificada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.edu.ort.sigamas.seguridad.entidades.TareaPlanificada[ idTareaPlanificada=" + idTareaPlanificada + " ]";
    }
    
}
