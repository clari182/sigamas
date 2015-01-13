/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.entidades;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pikachuss
 */
@Entity
@Table(name = "notificacion", catalog = "sigamas_sigamas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notificacion.findAll", query = "SELECT n FROM Notificacion n"),
    @NamedQuery(name = "Notificacion.findByIdNotificacion", query = "SELECT n FROM Notificacion n WHERE n.idNotificacion = :idNotificacion"),
    @NamedQuery(name = "Notificacion.findByMensaje", query = "SELECT n FROM Notificacion n WHERE n.mensaje = :mensaje"),
    @NamedQuery(name = "Notificacion.findByAnterioridadDias", query = "SELECT n FROM Notificacion n WHERE n.anterioridadDias = :anterioridadDias"),
    @NamedQuery(name = "Notificacion.findByLeida", query = "SELECT n FROM Notificacion n WHERE n.leida = :leida"),
    @NamedQuery(name = "Notificacion.findNotificacionesHoy", query = "SELECT n FROM Notificacion n "
            + "join n.idTarea r "
            + "join r.idProyecto p "
            + "join p.idParcela pa "
            + "WHERE n.leida = 0 "
            + "and (r.fecha - n.anterioridadDias) >= CURRENT_DATE "
            + "and pa.idCuenta = :idCuenta"),
    @NamedQuery(name = "Notificacion.findNotificacionesSms", query = "SELECT n "
            + "FROM Notificacion n join TipoNotificacion t on n.idTipoNotificaicon = t.idTipoNotificacion "
            + "WHERE n.leida = 0 "
            + "and lower(t.medio) = lower('cel')"),
    @NamedQuery(name = "Notificacion.findByTipo", query = "SELECT n FROM Notificacion n WHERE n.tipo = :tipo")})
public class Notificacion implements Serializable {
    @Column(name = "leida")
    private Integer leida;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_notificacion", nullable = false)
    private Integer idNotificacion;
    @Column(name = "mensaje", length = 45)
    private String mensaje;
    @Column(name = "anterioridad_dias")
    private Integer anterioridadDias;
    @Column(name = "tipo")
    private Integer tipo;
    @JoinColumn(name = "id_tarea", referencedColumnName = "id_tarea_real")
    @ManyToOne(fetch = FetchType.EAGER)
    private TareaReal idTarea;
    @JoinColumn(name = "id_tipo_notificacion", referencedColumnName = "id_tipo_notificacion")
    @ManyToOne(fetch = FetchType.EAGER)
    private TipoNotificacion idTipoNotificacion;

    public Notificacion() {
    }

    public Notificacion(Integer idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public Integer getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(Integer idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Integer getAnterioridadDias() {
        return anterioridadDias;
    }

    public void setAnterioridadDias(Integer anterioridadDias) {
        this.anterioridadDias = anterioridadDias;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public TareaReal getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(TareaReal idTarea) {
        this.idTarea = idTarea;
    }

    public TipoNotificacion getIdTipoNotificacion() {
        return idTipoNotificacion;
    }

    public void setIdTipoNotificacion(TipoNotificacion idTipoNotificacion) {
        this.idTipoNotificacion = idTipoNotificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotificacion != null ? idNotificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notificacion)) {
            return false;
        }
        Notificacion other = (Notificacion) object;
        if ((this.idNotificacion == null && other.idNotificacion != null) || (this.idNotificacion != null && !this.idNotificacion.equals(other.idNotificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.edu.ort.sigamas.seguridad.entidades.Notificacion[ idNotificacion=" + idNotificacion + " ]";
    }

    public Integer getLeida() {
        return leida;
    }

    public void setLeida(Integer leida) {
        this.leida = leida;
    }
    
}
