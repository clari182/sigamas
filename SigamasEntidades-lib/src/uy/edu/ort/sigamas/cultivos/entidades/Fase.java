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
@Table(name = "fase", catalog = "sigamas_sigamas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fase.findAll", query = "SELECT f FROM Fase f"),
    @NamedQuery(name = "Fase.findByIdFase", query = "SELECT f FROM Fase f WHERE f.idFase = :idFase"),
    @NamedQuery(name = "Fase.findByNombreCorto", query = "SELECT f FROM Fase f WHERE f.nombreCorto = :nombreCorto"),
    @NamedQuery(name = "Fase.findByNombre", query = "SELECT f FROM Fase f WHERE f.nombre = :nombre")})
public class Fase implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_fase", nullable = false)
    private Integer idFase;
    @Basic(optional = false)
    @Column(name = "nombre_corto", nullable = false, length = 1)
    private String nombreCorto;
    @Column(name = "nombre", length = 45)
    private String nombre;
    @OneToMany(mappedBy = "idFase", fetch = FetchType.EAGER)
    private List<Subfase> subfaseList;

    public Fase() {
    }

    public Fase(Integer idFase) {
        this.idFase = idFase;
    }

    public Fase(Integer idFase, String nombreCorto) {
        this.idFase = idFase;
        this.nombreCorto = nombreCorto;
    }

    public Integer getIdFase() {
        return idFase;
    }

    public void setIdFase(Integer idFase) {
        this.idFase = idFase;
    }

    public String getNombreCorto() {
        return nombreCorto;
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        hash += (idFase != null ? idFase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fase)) {
            return false;
        }
        Fase other = (Fase) object;
        if ((this.idFase == null && other.idFase != null) || (this.idFase != null && !this.idFase.equals(other.idFase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.edu.ort.sigamas.seguridad.entidades.Fase[ idFase=" + idFase + " ]";
    }
    
}
