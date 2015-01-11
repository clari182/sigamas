/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Pikachuss
 */
@Entity
@Table(name = "tarea_real", catalog = "sigamas_sigamas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TareaReal.findAll", query = "SELECT t FROM TareaReal t"),
    @NamedQuery(name = "TareaReal.findByIdTareaReal", query = "SELECT t FROM TareaReal t WHERE t.idTareaReal = :idTareaReal"),
    @NamedQuery(name = "TareaReal.findByNombre", query = "SELECT t FROM TareaReal t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TareaReal.findByFecha", query = "SELECT t FROM TareaReal t WHERE t.fecha = :fecha"),
    @NamedQuery(name = "TareaReal.findByValidada", query = "SELECT t FROM TareaReal t WHERE t.validada = :validada")})
public class TareaReal implements Serializable {
    @JoinColumn(name = "id_tarea_planificada", referencedColumnName = "id_tarea_planificada")
    @ManyToOne(fetch = FetchType.EAGER)
    private TareaPlanificada idTareaPlanificada;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tarea_real", nullable = false)
    private Integer idTareaReal;
    @Column(name = "nombre", length = 45)
    private String nombre;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "validada")
    private Integer validada;
    @OneToMany(mappedBy = "idTarea", fetch = FetchType.EAGER)
    private List<Notificacion> notificacionList;
    @OneToMany(mappedBy = "idTareaReal", fetch = FetchType.EAGER)
    private List<TareaPlanificada> tareaPlanificadaList;
    @JoinColumn(name = "id_fase", referencedColumnName = "id_fase")
    @ManyToOne(fetch = FetchType.EAGER)
    private Fase idFase;
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto")
    @ManyToOne(fetch = FetchType.EAGER)
    private Proyecto idProyecto;

    public TareaReal() {
    }

    public TareaReal(Integer idTareaReal) {
        this.idTareaReal = idTareaReal;
    }

    public Integer getIdTareaReal() {
        return idTareaReal;
    }

    public void setIdTareaReal(Integer idTareaReal) {
        this.idTareaReal = idTareaReal;
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

    @XmlTransient
    public List<Notificacion> getNotificacionList() {
        return notificacionList;
    }

    public void setNotificacionList(List<Notificacion> notificacionList) {
        this.notificacionList = notificacionList;
    }

    @XmlTransient
    public List<TareaPlanificada> getTareaPlanificadaList() {
        return tareaPlanificadaList;
    }

    public void setTareaPlanificadaList(List<TareaPlanificada> tareaPlanificadaList) {
        this.tareaPlanificadaList = tareaPlanificadaList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTareaReal != null ? idTareaReal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TareaReal)) {
            return false;
        }
        TareaReal other = (TareaReal) object;
        if ((this.idTareaReal == null && other.idTareaReal != null) || (this.idTareaReal != null && !this.idTareaReal.equals(other.idTareaReal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.edu.ort.sigamas.seguridad.entidades.TareaReal[ idTareaReal=" + idTareaReal + " ]";
    }

    public TareaPlanificada getIdTareaPlanificada() {
        return idTareaPlanificada;
    }

    public void setIdTareaPlanificada(TareaPlanificada idTareaPlanificada) {
        this.idTareaPlanificada = idTareaPlanificada;
    }
    
}
