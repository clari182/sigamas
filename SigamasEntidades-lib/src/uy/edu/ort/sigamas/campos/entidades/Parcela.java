/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.campos.entidades;

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
import uy.edu.ort.sigamas.seguridad.entidades.Cuenta;
import uy.edu.ort.sigamas.seguimiento.entidades.Proyecto;

/**
 *
 * @author Mattahari
 */
@Entity
@Table(name = "parcela", catalog = "sigamas_sigamas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parcela.findAll", query = "SELECT p FROM Parcela p"),
    @NamedQuery(name = "Parcela.findByIdParcela", query = "SELECT p FROM Parcela p WHERE p.idParcela = :idParcela"),
    @NamedQuery(name = "Parcela.findByNombre", query = "SELECT p FROM Parcela p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Parcela.findByPadron", query = "SELECT p FROM Parcela p WHERE p.padron = :padron"),
    @NamedQuery(name = "Parcela.findByDepartamento", query = "SELECT p FROM Parcela p WHERE p.departamento = :departamento")})
public class Parcela implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_parcela", nullable = false)
    private Integer idParcela;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "padron", nullable = false, length = 45)
    private String padron;
    @Column(name = "departamento", length = 45)
    private String departamento;
    @OneToMany(mappedBy = "idParcela", fetch = FetchType.EAGER)
    private List<Proyecto> proyectoList;
    @JoinColumn(name = "id_cuenta", referencedColumnName = "id_cuenta")
    @ManyToOne(fetch = FetchType.EAGER)
    private Cuenta idCuenta;

    public Parcela() {
    }

    public Parcela(Integer idParcela) {
        this.idParcela = idParcela;
    }

    public Parcela(Integer idParcela, String nombre, String padron) {
        this.idParcela = idParcela;
        this.nombre = nombre;
        this.padron = padron;
    }

    public Integer getIdParcela() {
        return idParcela;
    }

    public void setIdParcela(Integer idParcela) {
        this.idParcela = idParcela;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPadron() {
        return padron;
    }

    public void setPadron(String padron) {
        this.padron = padron;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @XmlTransient
    public List<Proyecto> getProyectoList() {
        return proyectoList;
    }

    public void setProyectoList(List<Proyecto> proyectoList) {
        this.proyectoList = proyectoList;
    }

    public Cuenta getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Cuenta idCuenta) {
        this.idCuenta = idCuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParcela != null ? idParcela.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parcela)) {
            return false;
        }
        Parcela other = (Parcela) object;
        if ((this.idParcela == null && other.idParcela != null) || (this.idParcela != null && !this.idParcela.equals(other.idParcela))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.edu.ort.sigamas.seguridad.entidades.Parcela[ idParcela=" + idParcela + " ]";
    }
    
}
