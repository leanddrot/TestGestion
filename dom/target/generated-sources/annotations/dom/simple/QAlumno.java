package dom.simple;

import org.datanucleus.query.typesafe.*;
import org.datanucleus.api.jdo.query.*;

public class QAlumno extends org.datanucleus.api.jdo.query.PersistableExpressionImpl<Alumno> implements PersistableExpression<Alumno>
{
    public static final QAlumno jdoCandidate = candidate("this");

    public static QAlumno candidate(String name)
    {
        return new QAlumno(null, name, 5);
    }

    public static QAlumno candidate()
    {
        return jdoCandidate;
    }

    public static QAlumno parameter(String name)
    {
        return new QAlumno(Alumno.class, name, ExpressionType.PARAMETER);
    }

    public static QAlumno variable(String name)
    {
        return new QAlumno(Alumno.class, name, ExpressionType.VARIABLE);
    }

    public final StringExpression nombre;
    public final StringExpression apellido;
    public final NumericExpression<Integer> dni;
    public final dom.simple.QDireccion direccion;
    public final dom.simple.QLegajo legajo;
    public final ObjectExpression<org.apache.isis.applib.DomainObjectContainer> container;

    public QAlumno(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.nombre = new StringExpressionImpl(this, "nombre");
        this.apellido = new StringExpressionImpl(this, "apellido");
        this.dni = new NumericExpressionImpl<Integer>(this, "dni");
        if (depth > 0)
        {
            this.direccion = new dom.simple.QDireccion(this, "direccion", depth-1);
        }
        else
        {
            this.direccion = null;
        }
        if (depth > 0)
        {
            this.legajo = new dom.simple.QLegajo(this, "legajo", depth-1);
        }
        else
        {
            this.legajo = null;
        }
        this.container = new ObjectExpressionImpl<org.apache.isis.applib.DomainObjectContainer>(this, "container");
    }

    public QAlumno(Class type, String name, org.datanucleus.api.jdo.query.ExpressionType exprType)
    {
        super(type, name, exprType);
        this.nombre = new StringExpressionImpl(this, "nombre");
        this.apellido = new StringExpressionImpl(this, "apellido");
        this.dni = new NumericExpressionImpl<Integer>(this, "dni");
        this.direccion = new dom.simple.QDireccion(this, "direccion", 5);
        this.legajo = new dom.simple.QLegajo(this, "legajo", 5);
        this.container = new ObjectExpressionImpl<org.apache.isis.applib.DomainObjectContainer>(this, "container");
    }
}
