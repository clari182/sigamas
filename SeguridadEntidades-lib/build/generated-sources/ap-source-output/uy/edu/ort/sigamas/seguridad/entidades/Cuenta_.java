package uy.edu.ort.sigamas.seguridad.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uy.edu.ort.sigamas.seguridad.entidades.Usuario;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-10-23T14:31:26")
@StaticMetamodel(Cuenta.class)
public class Cuenta_ { 

    public static volatile SingularAttribute<Cuenta, String> nombre;
    public static volatile SingularAttribute<Cuenta, String> rut;
    public static volatile ListAttribute<Cuenta, Usuario> usuarioList;
    public static volatile SingularAttribute<Cuenta, String> empresa;
    public static volatile SingularAttribute<Cuenta, Integer> idCuenta;

}