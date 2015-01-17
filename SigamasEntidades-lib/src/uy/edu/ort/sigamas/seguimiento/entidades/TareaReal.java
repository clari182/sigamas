/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguimiento.entidades;

import uy.edu.ort.sigamas.notificaciones.entidades.Notificacion;
import uy.edu.ort.sigamas.insumos.entidades.InsumoTarea;
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
 * @author Mattahari
 */
@Entity
@Table(name = "tarea_real", catalog = "sigamas_sigamas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TareaReal.findAll", query = "SELECT t FROM TareaReal t"),
    @NamedQuery(name = "TareaReal.findByIdTareaReal", query = "SELECT t FROM TareaReal t WHERE t.idTareaReal = :idTareaReal"),
    @NamedQuery(name = "TareaReal.findByNombre", query = "SELECT t FROM TareaReal t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TareaReal.findByFecha", query = "SELECT t FROM TareaReal t WHERE t.fecha = :fecha"),
    @NamedQuery(name = "TareaReal.findByValidada", query = "SELECT t FROM TareaReal t WHERE t.validada = :validada"),
    @NamedQuery(name = "TareaReal.findByIdFase", query = "SELECT t FROM TareaReal t WHERE t.idFase = :idFase")})
public class TareaReal implements Serializable {
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
    @Column(name = "id_fase")
    private Integer idFase;
    @OneToMany(mappedBy = "idTareaReal", fetch = FetchType.EAGER)
    private List<InsumoTarea> insumoTareaList;
    @OneToMany(mappedBy = "idTarea", fetch = FetchType.EAGER)
    private List<Notificacion> notificacionList;
    @JoinColumn(name = "id_tarea_planificada", referencedColumnName = "id_tarea_planificada")
    @ManyToOne(fetch = FetchType.EAGER)
    private TareaPlanificada idTareaPlanificada;
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

    public Integer getIdFase() {
        return idFase;
    }

    public void setIdFase(Integer idFase) {
        this.idFase = idFase;
    }

    @XmlTransient
    public List<InsumoTarea> getInsumoTareaList() {
        return insumoTareaList;
    }

    public void setInsumoTareaList(List<InsumoTarea> insumoTareaList) {
        this.insumoTareaList = insumoTareaList;
    }

    @XmlTransient
    public List<Notificacion> getNotificacionList() {
        return notificacionList;
    }

    public void setNotificacionList(List<Notificacion> notificacionList) {
        this.notificacionList = notificacionList;
    }

    public TareaPlanificada getIdTareaPlanificada() {
        return idTareaPlanificada;
    }

    public void setIdTareaPlanificada(TareaPlanificada idTareaPlanificada) {
        this.idTareaPlanificada = idTareaPlanificada;
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
    
}
