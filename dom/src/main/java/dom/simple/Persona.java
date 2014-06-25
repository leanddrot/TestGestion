package dom.simple;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import org.apache.isis.applib.annotation.MemberOrder;


@PersistenceCapable
public class Persona {
	
	// {{ Sexo (property)
	private genero sexo;

	@Persistent
	@MemberOrder(sequence = "1.4")
	@javax.jdo.annotations.Column(allowsNull="false")
	public genero getSexo() {
		return sexo;
	}

	public void setSexo(final genero sexo) {
		this.sexo = sexo;
	}
	// }}

	
	
	public enum genero{
		
		MASCULINO, FEMENINO
	}
	

}
