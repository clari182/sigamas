package uy.edu.ort.sigamas.seguridad.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uy.edu.ort.sigamas.seguridad.entidades.Cuenta;
import uy.edu.ort.sigamas.seguridad.entidades.Login;
import uy.edu.ort.sigamas.seguridad.entidades.Rol;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-10-23T14:31:26")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> claveUsuario;
    public static volatile SingularAttribute<Usuario, String> telefono;
    public static volatile SingularAttribute<Usuario, String> sexo;
    public static volatile SingularAttribute<Usuario, Date> fechaNacimiento;
    public static volatile SingularAttribute<Usuario, Integer> esSuperUsuario;
    public static volatile SingularAttribute<Usuario, String> primerNombre;
    public static volatile SingularAttribute<Usuario, String> segundoApellido;
    public static volatile ListAttribute<Usuario, Login> loginList;
    public static volatile SingularAttribute<Usuario, Integer> idUsuario;
    public static volatile SingularAttribute<Usuario, String> profesion;
    public static volatile SingularAttribute<Usuario, String> emailUsuario;
    public static volatile SingularAttribute<Usuario, String> primerApellido;
    public static volatile SingularAttribute<Usuario, String> segundoNombre;
    public static volatile ListAttribute<Usuario, Cuenta> cuentaList;
    public static volatile SingularAttribute<Usuario, Rol> idRol;
    public static volatile SingularAttribute<Usuario, String> nombreUsuario;

}