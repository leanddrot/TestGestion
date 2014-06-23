package dom.simple;

import java.util.SortedSet;
import java.util.TreeSet;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.Element;
import javax.jdo.annotations.PersistenceCapable;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.MaxLength;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.MultiLine;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.Render;
import org.apache.isis.applib.annotation.Render.Type;



@PersistenceCapable

public class Legajo {
	
	
	@Column(allowsNull = "true", name = "TARJETAS_ID")
	@MemberOrder(sequence = "1.1", name = "Nueva Tarjeta")
	@Named("Nueva Tarjeta")
	public Tarjeta create (
			final @Named("Nombre") String nombre,
			final @MaxLength(2048)
		    	  @MultiLine 
		    	  @Named("Cuerpo") String cuerpo){
		final Tarjeta obj = new Tarjeta();
		obj.setTituloTarjeta(nombre);;
		obj.setTextoTarjeta(cuerpo);
		addTarjeta(obj);
		return obj;
	}
		
	public Legajo () {
		
	}
	
	public String title(){
		return "Legajo de " + getPropietario() ;
	}
	
	
	///////////////////////////////////////////////
	
	// {{ ListaDocumentos (Collection)
	
	@Element(column = "DOCUM", dependent = "false")
	private SortedSet<Tarjeta> listaTarjetas = new TreeSet<Tarjeta>();
	@Render(Type.EAGERLY)
	@MemberOrder(sequence = "1")
	public SortedSet<Tarjeta> getListaDocumentos() {
		return listaTarjetas;
	}

	public void setListaDocumentos(final SortedSet<Tarjeta> listaTarjetas) {
		this.listaTarjetas = listaTarjetas;
	}
	// }}
	
	
	// {{ Propietario (property)
	private String propietario;

	@MemberOrder(sequence = "1")
	@Hidden
	@Column(allowsNull = "true", name = "PROPIETARIO")
	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(final String propietario) {
		this.propietario = propietario;
	}
	// }}


	
	
	
	
	
	
			
	// ///////////////////////////////////////
	//  Action AddTarjeta
	// ///////////////////////////////////////
	@Hidden
	public void addTarjeta(Tarjeta tarjeta){
		this.listaTarjetas.add(tarjeta);
		;	
	}
	

    // //////////////////////////////////////
    // Injected services
    // //////////////////////////////////////

    @javax.inject.Inject 
    DomainObjectContainer container;
	
}
