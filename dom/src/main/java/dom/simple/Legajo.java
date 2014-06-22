package dom.simple;

import java.util.SortedSet;
import java.util.TreeSet;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.Element;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.Render;
import org.apache.isis.applib.annotation.Render.Type;

import com.google.common.io.Resources;



@PersistenceCapable

public class Legajo {
	
	
	@Column(allowsNull = "true", name = "TARJETAS_ID")
	@MemberOrder(sequence = "1.1", name = "Nueva Tarjeta")
	@Named("Nueva Tarjeta")
	public Tarjeta create (
			final @Named("Nombre") String nombre,
			final @Named("Cuerpo") String cuerpo){
		final Tarjeta obj = new Tarjeta();
		obj.setTituloTarjeta(nombre);;
		obj.setTextoTarjeta(cuerpo);
		//container.persistIfNotAlready(obj);
		add(obj);
		return obj;
	}
		
	public Legajo () {
		
	}
	
	public String title(){
		return "Legajo";
	}
	
	
	///////////////////////////////////////////////
	
	// {{ ListaDocumentos (Collection)
	
	@Element(column = "DOCUM", dependent = "false")
	
	private SortedSet<Tarjeta> listaDocumentos = new TreeSet<Tarjeta>();
	@Render(Type.EAGERLY)
	@MemberOrder(sequence = "3")
	public SortedSet<Tarjeta> getListaDocumentos() {
		return listaDocumentos;
	}

	public void setListaDocumentos(final SortedSet<Tarjeta> listaDocumentos) {
		this.listaDocumentos = listaDocumentos;
	}
	// }}
			
	// ///////////////////////////////////////
	//  Action Add
	// ///////////////////////////////////////
	@Hidden
	public void add(Tarjeta documento){
		this.listaDocumentos.add(documento);
		;	
	}
	
	

    // //////////////////////////////////////
    // Injected services
    // //////////////////////////////////////

    @javax.inject.Inject 
    DomainObjectContainer container;
	
}
