/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.insumos.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import uy.edu.ort.sigamas.seguimiento.entidades.TareaPlanificada;
import uy.edu.ort.sigamas.seguimiento.entidades.TareaReal;

/**
 *
 * @author Mattahari
 */
@Entity
@Table(name = "insumo_tarea", catalog = "sigamas_sigamas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InsumoTarea.findAll", query = "SELECT i FROM InsumoTarea i"),
    @NamedQuery(name = "InsumoTarea.findByIdInsumoTarea", query = "SELECT i FROM InsumoTarea i WHERE i.idInsumoTarea = :idInsumoTarea")})
public class InsumoTarea implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_insumo_tarea", nullable = false)
    private Integer idInsumoTarea;
    @JoinColumn(name = "id_tarea_real", referencedColumnName = "id_tarea_real")
    @ManyToOne(fetch = FetchType.EAGER)
    private TareaReal idTareaReal;
    @JoinColumn(name = "id_tarea_planificada", referencedColumnName = "id_tarea_planificada")
    @ManyToOne(fetch = FetchType.EAGER)
    private TareaPlanificada idTareaPlanificada;
    @JoinColumn(name = "id_insumo", referencedColumnName = "id_insumo")
    @ManyToOne(fetch = FetchType.EAGER)
    private Insumo idInsumo;

    public InsumoTarea() {
    }

    public InsumoTarea(Integer idInsumoTarea) {
        this.idInsumoTarea = idInsumoTarea;
    }

    public Integer getIdInsumoTarea() {
        return idInsumoTarea;
    }

    public void setIdInsumoTarea(Integer idInsumoTarea) {
        this.idInsumoTarea = idInsumoTarea;
    }

    public TareaReal getIdTareaReal() {
        return idTareaReal;
    }

    public void setIdTareaReal(TareaReal idTareaReal) {
        this.idTareaReal = idTareaReal;
    }

    public TareaPlanificada getIdTareaPlanificada() {
        return idTareaPlanificada;
    }

    public void setIdTareaPlanificada(TareaPlanificada idTareaPlanificada) {
        this.idTareaPlanificada = idTareaPlanificada;
    }

    public Insumo getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(Insumo idInsumo) {
        this.idInsumo = idInsumo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInsumoTarea != null ? idInsumoTarea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InsumoTarea)) {
            return false;
        }
        InsumoTarea other = (InsumoTarea) object;
        if ((this.idInsumoTarea == null && other.idInsumoTarea != null) || (this.idInsumoTarea != null && !this.idInsumoTarea.equals(other.idInsumoTarea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.edu.ort.sigamas.seguridad.entidades.InsumoTarea[ idInsumoTarea=" + idInsumoTarea + " ]";
    }
    
}
