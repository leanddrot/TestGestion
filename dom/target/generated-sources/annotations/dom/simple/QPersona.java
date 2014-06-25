package dom.simple;

import org.datanucleus.query.typesafe.*;
import org.datanucleus.api.jdo.query.*;

public class QPersona extends org.datanucleus.api.jdo.query.PersistableExpressionImpl<Persona> implements PersistableExpression<Persona>
{
    public static final QPersona jdoCandidate = candidate("this");

    public static QPersona candidate(String name)
    {
        return new QPersona(null, name, 5);
    }

    public static QPersona candidate()
    {
        return jdoCandidate;
    }

    public static QPersona parameter(String name)
    {
        return new QPersona(Persona.class, name, ExpressionType.PARAMETER);
    }

    public static QPersona variable(String name)
    {
        return new QPersona(Persona.class, name, ExpressionType.VARIABLE);
    }

    public final ObjectExpression<dom.simple.Persona.genero> sexo;

    public QPersona(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.sexo = new ObjectExpressionImpl<dom.simple.Persona.genero>(this, "sexo");
    }

    public QPersona(Class type, String name, org.datanucleus.api.jdo.query.ExpressionType exprType)
    {
        super(type, name, exprType);
        this.sexo = new ObjectExpressionImpl<dom.simple.Persona.genero>(this, "sexo");
    }
}
