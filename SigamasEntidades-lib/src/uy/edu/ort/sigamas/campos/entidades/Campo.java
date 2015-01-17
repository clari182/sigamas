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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import uy.edu.ort.sigamas.seguridad.entidades.Cuenta;
import uy.edu.ort.sigamas.insumos.entidades.Insumo;
import uy.edu.ort.sigamas.insumos.entidades.Valor;

/**
 *
 * @author Mattahari
 */
@Entity
@Table(name = "campo", catalog = "sigamas_sigamas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Campo.findAll", query = "SELECT c FROM Campo c"),
    @NamedQuery(name = "Campo.findByIdCampo", query = "SELECT c FROM Campo c WHERE c.idCampo = :idCampo"),
    @NamedQuery(name = "Campo.findByNombre", query = "SELECT c FROM Campo c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Campo.findByDescripcion", query = "SELECT c FROM Campo c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Campo.findByActivo", query = "SELECT c FROM Campo c WHERE c.activo = :activo")})
public class Campo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_campo", nullable = false)
    private Integer idCampo;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    @Column(name = "descripcion", length = 45)
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "activo", nullable = false)
    private int activo;
    @ManyToMany(mappedBy = "campoList", fetch = FetchType.EAGER)
    private List<Insumo> insumoList;
    @JoinTable(name = "campo_valor", joinColumns = {
        @JoinColumn(name = "id_campo", referencedColumnName = "id_campo", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_valor", referencedColumnName = "id_valor", nullable = false)})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Valor> valorList;
    @JoinColumn(name = "id_cuenta", referencedColumnName = "id_cuenta")
    @ManyToOne(fetch = FetchType.EAGER)
    private Cuenta idCuenta;

    public Campo() {
    }

    public Campo(Integer idCampo) {
        this.idCampo = idCampo;
    }

    public Campo(Integer idCampo, String nombre, int activo) {
        this.idCampo = idCampo;
        this.nombre = nombre;
        this.activo = activo;
    }

    public Integer getIdCampo() {
        return idCampo;
    }

    public void setIdCampo(Integer idCampo) {
        this.idCampo = idCampo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    @XmlTransient
    public List<Insumo> getInsumoList() {
        return insumoList;
    }

    public void setInsumoList(List<Insumo> insumoList) {
        this.insumoList = insumoList;
    }

    @XmlTransient
    public List<Valor> getValorList() {
        return valorList;
    }

    public void setValorList(List<Valor> valorList) {
        this.valorList = valorList;
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
        hash += (idCampo != null ? idCampo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Campo)) {
            return false;
        }
        Campo other = (Campo) object;
        if ((this.idCampo == null && other.idCampo != null) || (this.idCampo != null && !this.idCampo.equals(other.idCampo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.edu.ort.sigamas.seguridad.entidades.Campo[ idCampo=" + idCampo + " ]";
    }
    
}
