package dom.simple;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.MaxLength;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.MultiLine;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.util.ObjectContracts;

@PersistenceCapable
public class Tarjeta implements Comparable<Tarjeta>{
	
	// {{ TituloDocumento (property)
	private String tituloTarjeta;

	@Title
	@Persistent
	@MemberOrder(sequence = "1")
	@Column(allowsNull = "true")
	public String getTituloTarjeta() {
		return tituloTarjeta;
	}

	public void setTituloTarjeta(final String TituloTarjeta) {
		this.tituloTarjeta = TituloTarjeta;
	}
	// }}


	
	// {{ TextoDocumento (property)
	
	private String textoTarjeta;

	@Persistent
	@MemberOrder(sequence = "1.1")
	@Column(allowsNull = "true", length = 2048)
	@MaxLength(2048)
    @MultiLine
	public String getTextoTarjeta() {
		return textoTarjeta;
	}

	public void setTextoTarjeta(final String textoTarjeta) {
		this.textoTarjeta = textoTarjeta;
	}
	// }}

	
	 // //////////////////////////////////////
    // Injected services
    // //////////////////////////////////////

    @javax.inject.Inject 
    DomainObjectContainer container;

	@Override
	public int compareTo(Tarjeta other) {
		return ObjectContracts.compare(this, other, "tituloTarjeta");
	}
	

}
