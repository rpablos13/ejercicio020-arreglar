package es.cic.curso.grupo7.ejercicio020.dto;

import java.util.ArrayList;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import es.cic.curso.grupo7.ejercicio020.repository.Identificable;


@Entity
@Table(name="SALA")
public class Sala implements Identificable<Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -83166149193914344L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="numeroSala")
	private int numeroSala;
	

	@Column(name="aforo")
	private int aforo;
	
	
	@Column(name="precioEntrada")
	private static final double PRECIO_ENTRADA = 5;
	
	@Column(name="recaudacion")
	private double recaudacion=0;
	
	@Transient
	private boolean cerrado;
	
	@Transient
	private List<Sesion> sesiones;
	
	@OneToMany(mappedBy="sala")
	private List<Sesion> sesion = new ArrayList<Sesion>();
	
	
	public Sala() {
		super();
	}
	
	public Sala(int numeroSala, int aforo, double recaudacion){
		super();
		this.numeroSala = numeroSala;
		this.aforo = aforo;
		this.recaudacion = recaudacion;
	}
	
	public Sala(int numeroSala, List<Sesion> sesiones) {
		super();
		this.numeroSala = numeroSala;
		this.sesiones = sesiones;
	}
	
	public Sala(int numeroSala) {
		super();
		this.numeroSala = numeroSala;
	}
	
	
	public int obtenLibres(int sesion){
		return sesiones.get(sesion).getAforoLibre();
	}
	

	public void sumaRecaudacion(double recaudacion) {
		this.recaudacion += recaudacion;
	}
	
	//Getters and Setters
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNumeroSala() {
		return numeroSala;
	}
	public void setNumeroSala(int numeroSala) {
		this.numeroSala = numeroSala;
	}
	public int getAforo() {
		return aforo;
	}
	public void setAforo(int aforo) {
		this.aforo = aforo;
	}
	public double getRecaudacion() {
		return recaudacion;
	}
	public void setRecaudacion(double recaudacion) {
		this.recaudacion = recaudacion;
	}
	public boolean isCerrado() {
		return cerrado;
	}
	public void setCerrado(boolean cerrado) {
		this.cerrado = cerrado;
	}
	public List<Sesion> getSesiones() {
		return sesiones;
	}
	public void setSesiones(List<Sesion> sesiones) {
		this.sesiones = sesiones;
	}
	public List<Sesion> getSesion() {
		return sesion;
	}
	public void setSesion(List<Sesion> sesion) {
		this.sesion = sesion;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Sala [id=" + id + ", numeroSala=" + numeroSala + ", aforo=" + aforo + ", recaudacion=" + recaudacion
				+ ", cerrado=" + cerrado + ", sesiones=" + sesiones + ", sesion=" + sesion + "]";
	}

	public static double getPrecioEntrada() {
		return PRECIO_ENTRADA;
	}


	
}
