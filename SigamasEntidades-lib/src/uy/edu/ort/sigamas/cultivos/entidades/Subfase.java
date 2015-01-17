/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.cultivos.entidades;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import uy.edu.ort.sigamas.seguimiento.entidades.Proyecto;
import uy.edu.ort.sigamas.seguimiento.entidades.TareaPlanificada;

/**
 *
 * @author Mattahari
 */
@Entity
@Table(name = "subfase", catalog = "sigamas_sigamas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subfase.findAll", query = "SELECT s FROM Subfase s"),
    @NamedQuery(name = "Subfase.findByIdSubfase", query = "SELECT s FROM Subfase s WHERE s.idSubfase = :idSubfase"),
    @NamedQuery(name = "Subfase.findByEtapa", query = "SELECT s FROM Subfase s WHERE s.etapa = :etapa"),
    @NamedQuery(name = "Subfase.findByNombre", query = "SELECT s FROM Subfase s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "Subfase.findByDias", query = "SELECT s FROM Subfase s WHERE s.dias = :dias"),
    @NamedQuery(name = "Subfase.findByDescripcion", query = "SELECT s FROM Subfase s WHERE s.descripcion = :descripcion")})
public class Subfase implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_subfase", nullable = false)
    private Integer idSubfase;
    @Column(name = "etapa", length = 45)
    private String etapa;
    @Column(name = "nombre", length = 45)
    private String nombre;
    @Column(name = "dias")
    private Integer dias;
    @Column(name = "descripcion", length = 45)
    private String descripcion;
    @OneToMany(mappedBy = "idSubfase", fetch = FetchType.EAGER)
    private List<TareaPlanificada> tareaPlanificadaList;
    @OneToMany(mappedBy = "idFasePlanificada", fetch = FetchType.EAGER)
    private List<Proyecto> proyectoList;
    @OneToMany(mappedBy = "idFaseActual", fetch = FetchType.EAGER)
    private List<Proyecto> proyectoList1;
    @JoinColumn(name = "id_fase", referencedColumnName = "id_fase")
    @ManyToOne(fetch = FetchType.EAGER)
    private Fase idFase;
    @JoinColumn(name = "id_cultivo", referencedColumnName = "id_cultivo")
    @ManyToOne(fetch = FetchType.EAGER)
    private Cultivo idCultivo;

    public Subfase() {
    }

    public Subfase(Integer idSubfase) {
        this.idSubfase = idSubfase;
    }

    public Integer getIdSubfase() {
        return idSubfase;
    }

    public void setIdSubfase(Integer idSubfase) {
        this.idSubfase = idSubfase;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<TareaPlanificada> getTareaPlanificadaList() {
        return tareaPlanificadaList;
    }

    public void setTareaPlanificadaList(List<TareaPlanificada> tareaPlanificadaList) {
        this.tareaPlanificadaList = tareaPlanificadaList;
    }

    @XmlTransient
    public List<Proyecto> getProyectoList() {
        return proyectoList;
    }

    public void setProyectoList(List<Proyecto> proyectoList) {
        this.proyectoList = proyectoList;
    }

    @XmlTransient
    public List<Proyecto> getProyectoList1() {
        return proyectoList1;
    }

    public void setProyectoList1(List<Proyecto> proyectoList1) {
        this.proyectoList1 = proyectoList1;
    }

    public Fase getIdFase() {
        return idFase;
    }

    public void setIdFase(Fase idFase) {
        this.idFase = idFase;
    }

    public Cultivo getIdCultivo() {
        return idCultivo;
    }

    public void setIdCultivo(Cultivo idCultivo) {
        this.idCultivo = idCultivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubfase != null ? idSubfase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subfase)) {
            return false;
        }
        Subfase other = (Subfase) object;
        if ((this.idSubfase == null && other.idSubfase != null) || (this.idSubfase != null && !this.idSubfase.equals(other.idSubfase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.edu.ort.sigamas.seguridad.entidades.Subfase[ idSubfase=" + idSubfase + " ]";
    }
    
}
