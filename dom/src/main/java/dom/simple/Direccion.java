package dom.simple;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.EmbeddedOnly;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import org.apache.isis.applib.annotation.MemberOrder;

	@PersistenceCapable
	
public class Direccion {
	
	// {{ Calle (property)
	private String calle;
	@Column(allowsNull = "true")
	@MemberOrder(sequence = "1", name = "calle")
	@Persistent
	public String getCalle() {
		return calle;
	}

	
	public void setCalle(final String calle) {
		this.calle = calle;
	}
	// }}


	// {{ Numero (property)
	private int numero;

	@MemberOrder(sequence = "1.1", name = "numero")
	@Column(allowsNull = "true")
	@Persistent
	public int getNumero() {
		return numero;
	}

	public void setNumero(final int numero) {
		this.numero = numero;
	}
	// }}

	
	public String title() {
		return calle + " " + numero;
	}


}
