/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "cuenta_usuario", catalog = "sigamas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuentaUsuario.findAll", query = "SELECT c FROM CuentaUsuario c"),
    @NamedQuery(name = "CuentaUsuario.findByIdCuenta", query = "SELECT c FROM CuentaUsuario c WHERE c.cuentaUsuarioPK.idCuenta = :idCuenta"),
    @NamedQuery(name = "CuentaUsuario.findByIdUsuario", query = "SELECT c FROM CuentaUsuario c WHERE c.cuentaUsuarioPK.idUsuario = :idUsuario"),
    @NamedQuery(name = "CuentaUsuario.findByAdmin", query = "SELECT c FROM CuentaUsuario c WHERE c.admin = :admin")})
public class CuentaUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CuentaUsuarioPK cuentaUsuarioPK;
    @Column(name = "admin")
    private Integer admin;
    @JoinColumn(name = "id_cuenta", referencedColumnName = "id_cuenta", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cuenta cuenta;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public CuentaUsuario() {
    }

    public CuentaUsuario(CuentaUsuarioPK cuentaUsuarioPK) {
        this.cuentaUsuarioPK = cuentaUsuarioPK;
    }

    public CuentaUsuario(int idCuenta, int idUsuario) {
        this.cuentaUsuarioPK = new CuentaUsuarioPK(idCuenta, idUsuario);
    }

    public CuentaUsuarioPK getCuentaUsuarioPK() {
        return cuentaUsuarioPK;
    }

    public void setCuentaUsuarioPK(CuentaUsuarioPK cuentaUsuarioPK) {
        this.cuentaUsuarioPK = cuentaUsuarioPK;
    }

    public Integer getAdmin() {
        return admin;
    }

    public void setAdmin(Integer admin) {
        this.admin = admin;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cuentaUsuarioPK != null ? cuentaUsuarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentaUsuario)) {
            return false;
        }
        CuentaUsuario other = (CuentaUsuario) object;
        if ((this.cuentaUsuarioPK == null && other.cuentaUsuarioPK != null) || (this.cuentaUsuarioPK != null && !this.cuentaUsuarioPK.equals(other.cuentaUsuarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.edu.ort.sigamas.seguridad.entidades.CuentaUsuario[ cuentaUsuarioPK=" + cuentaUsuarioPK + " ]";
    }
    
}
