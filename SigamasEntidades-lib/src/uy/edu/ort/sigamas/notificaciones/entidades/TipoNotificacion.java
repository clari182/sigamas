/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.notificaciones.entidades;

import uy.edu.ort.sigamas.notificaciones.entidades.Notificacion;
import java.io.Serializable;
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

/**
 *
 * @author Mattahari
 */
@Entity
@Table(name = "tipo_notificacion", catalog = "sigamas_sigamas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoNotificacion.findAll", query = "SELECT t FROM TipoNotificacion t"),
    @NamedQuery(name = "TipoNotificacion.findByIdTipoNotificacion", query = "SELECT t FROM TipoNotificacion t WHERE t.idTipoNotificacion = :idTipoNotificacion"),
    @NamedQuery(name = "TipoNotificacion.findByNombre", query = "SELECT t FROM TipoNotificacion t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TipoNotificacion.findByMedio", query = "SELECT t FROM TipoNotificacion t WHERE t.medio = :medio")})
public class TipoNotificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_notificacion", nullable = false)
    private Integer idTipoNotificacion;
    @Column(name = "nombre", length = 45)
    private String nombre;
    @Column(name = "medio", length = 45)
    private String medio;
    @OneToMany(mappedBy = "idTipoNotificacion", fetch = FetchType.EAGER)
    private List<Notificacion> notificacionList;

    public TipoNotificacion() {
    }

    public TipoNotificacion(Integer idTipoNotificacion) {
        this.idTipoNotificacion = idTipoNotificacion;
    }

    public Integer getIdTipoNotificacion() {
        return idTipoNotificacion;
    }

    public void setIdTipoNotificacion(Integer idTipoNotificacion) {
        this.idTipoNotificacion = idTipoNotificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMedio() {
        return medio;
    }

    public void setMedio(String medio) {
        this.medio = medio;
    }

    @XmlTransient
    public List<Notificacion> getNotificacionList() {
        return notificacionList;
    }

    public void setNotificacionList(List<Notificacion> notificacionList) {
        this.notificacionList = notificacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoNotificacion != null ? idTipoNotificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoNotificacion)) {
            return false;
        }
        TipoNotificacion other = (TipoNotificacion) object;
        if ((this.idTipoNotificacion == null && other.idTipoNotificacion != null) || (this.idTipoNotificacion != null && !this.idTipoNotificacion.equals(other.idTipoNotificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.edu.ort.sigamas.seguridad.entidades.TipoNotificacion[ idTipoNotificacion=" + idTipoNotificacion + " ]";
    }
    
}
