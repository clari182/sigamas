/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.entidades;

import uy.edu.ort.sigamas.insumos.entidades.Insumo;
import uy.edu.ort.sigamas.campos.entidades.Parcela;
import uy.edu.ort.sigamas.campos.entidades.Campo;
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
@Table(name = "cuenta", catalog = "sigamas_sigamas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c"),
    @NamedQuery(name = "Cuenta.findByIdCuenta", query = "SELECT c FROM Cuenta c WHERE c.idCuenta = :idCuenta"),
    @NamedQuery(name = "Cuenta.findByNombre", query = "SELECT c FROM Cuenta c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Cuenta.findByEmpresa", query = "SELECT c FROM Cuenta c WHERE c.empresa = :empresa"),
    @NamedQuery(name = "Cuenta.findByRut", query = "SELECT c FROM Cuenta c WHERE c.rut = :rut")})
public class Cuenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cuenta", nullable = false)
    private Integer idCuenta;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "empresa", nullable = false, length = 45)
    private String empresa;
    @Column(name = "rut", length = 45)
    private String rut;
    @JoinTable(name = "cuenta_usuario", joinColumns = {
        @JoinColumn(name = "id_cuenta", referencedColumnName = "id_cuenta", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Usuario> usuarioList;
    @OneToMany(mappedBy = "idCuenta", fetch = FetchType.EAGER)
    private List<Campo> campoList;
    @OneToMany(mappedBy = "idCuenta", fetch = FetchType.EAGER)
    private List<Login> loginList;
    @OneToMany(mappedBy = "idCuenta", fetch = FetchType.EAGER)
    private List<Insumo> insumoList;
    @OneToMany(mappedBy = "idCuenta", fetch = FetchType.EAGER)
    private List<Parcela> parcelaList;

    public Cuenta() {
    }

    public Cuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Cuenta(Integer idCuenta, String nombre, String empresa) {
        this.idCuenta = idCuenta;
        this.nombre = nombre;
        this.empresa = empresa;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @XmlTransient
    public List<Campo> getCampoList() {
        return campoList;
    }

    public void setCampoList(List<Campo> campoList) {
        this.campoList = campoList;
    }

    @XmlTransient
    public List<Login> getLoginList() {
        return loginList;
    }

    public void setLoginList(List<Login> loginList) {
        this.loginList = loginList;
    }

    @XmlTransient
    public List<Insumo> getInsumoList() {
        return insumoList;
    }

    public void setInsumoList(List<Insumo> insumoList) {
        this.insumoList = insumoList;
    }

    @XmlTransient
    public List<Parcela> getParcelaList() {
        return parcelaList;
    }

    public void setParcelaList(List<Parcela> parcelaList) {
        this.parcelaList = parcelaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuenta != null ? idCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuenta)) {
            return false;
        }
        Cuenta other = (Cuenta) object;
        if ((this.idCuenta == null && other.idCuenta != null) || (this.idCuenta != null && !this.idCuenta.equals(other.idCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.edu.ort.sigamas.seguridad.entidades.Cuenta[ idCuenta=" + idCuenta + " ]";
    }
    
}
