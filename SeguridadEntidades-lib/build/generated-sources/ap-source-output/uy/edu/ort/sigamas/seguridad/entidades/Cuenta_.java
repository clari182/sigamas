package uy.edu.ort.sigamas.seguridad.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uy.edu.ort.sigamas.seguridad.entidades.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-10-23T23:26:46")
@StaticMetamodel(Cuenta.class)
public class Cuenta_ { 

    public static volatile SingularAttribute<Cuenta, String> rut;
    public static volatile ListAttribute<Cuenta, Usuario> usuarioList;
    public static volatile SingularAttribute<Cuenta, Integer> idCuenta;
    public static volatile SingularAttribute<Cuenta, String> empresa;
    public static volatile SingularAttribute<Cuenta, String> nombre;

}