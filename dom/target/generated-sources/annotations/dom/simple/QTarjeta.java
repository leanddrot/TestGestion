package dom.simple;

import org.datanucleus.query.typesafe.*;
import org.datanucleus.api.jdo.query.*;

public class QTarjeta extends org.datanucleus.api.jdo.query.PersistableExpressionImpl<Tarjeta> implements PersistableExpression<Tarjeta>
{
    public static final QTarjeta jdoCandidate = candidate("this");

    public static QTarjeta candidate(String name)
    {
        return new QTarjeta(null, name, 5);
    }

    public static QTarjeta candidate()
    {
        return jdoCandidate;
    }

    public static QTarjeta parameter(String name)
    {
        return new QTarjeta(Tarjeta.class, name, ExpressionType.PARAMETER);
    }

    public static QTarjeta variable(String name)
    {
        return new QTarjeta(Tarjeta.class, name, ExpressionType.VARIABLE);
    }

    public final StringExpression tituloTarjeta;
    public final StringExpression textoTarjeta;
    public final ObjectExpression<org.apache.isis.applib.DomainObjectContainer> container;

    public QTarjeta(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.tituloTarjeta = new StringExpressionImpl(this, "tituloTarjeta");
        this.textoTarjeta = new StringExpressionImpl(this, "textoTarjeta");
        this.container = new ObjectExpressionImpl<org.apache.isis.applib.DomainObjectContainer>(this, "container");
    }

    public QTarjeta(Class type, String name, org.datanucleus.api.jdo.query.ExpressionType exprType)
    {
        super(type, name, exprType);
        this.tituloTarjeta = new StringExpressionImpl(this, "tituloTarjeta");
        this.textoTarjeta = new StringExpressionImpl(this, "textoTarjeta");
        this.container = new ObjectExpressionImpl<org.apache.isis.applib.DomainObjectContainer>(this, "container");
    }
}
