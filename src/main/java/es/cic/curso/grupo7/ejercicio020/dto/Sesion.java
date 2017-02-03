package es.cic.curso.grupo7.ejercicio020.dto;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import es.cic.curso.grupo7.ejercicio020.repository.Identificable;


@Entity
@Table(name="SESION")
public class Sesion implements Identificable<Long>  {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1971606077299347265L;


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="numeroSesion")
	private int numeroSesion;
	
	@Column(name="aforoOcupado")
	private int aforoOcupado;
	
	@Column(name="aforoLibre")
	private int aforoLibre;
	
	@Transient
	private boolean cerrado;
	

	@JoinColumn(name="numeroSala")
	@ManyToOne(fetch=FetchType.LAZY)
	private Sala sala;
	
	
	//Getters and Setterss
	
	public int getAforoOcupado() {
		return aforoOcupado;
	}
	public void setAforoOcupado(int aforoOcupado) {
		this.aforoOcupado = aforoOcupado;
	}
	public int getAforoLibre() {
		return aforoLibre;
	}
	public void setAforoLibre(int aforoLibre) {
		this.aforoLibre = aforoLibre;
	}
	public void vendeEntrada(int x){
		aforoLibre -= x;
		aforoOcupado += x;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isCerrado() {
		return cerrado;
	}
	public void setCerrado(boolean cerrado) {
		this.cerrado = cerrado;
	}
	public Long getIdSesion() {
		return id;
	}
	public void setIdSesion(Long idSesion) {
		this.id = idSesion;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	@Override
	public String toString() {
		return "Sesion [idSesion=" + id + ", aforoLibre=" + aforoLibre + ", aforoOcupado=" + aforoOcupado
				 + ", cerrado=" + cerrado + ", sala=" + sala + "]";
	}
	public int getNumeroSesion() {
		return numeroSesion;
	}
	public void setNumeroSesion(int numeroSesion) {
		this.numeroSesion = numeroSesion;
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
		Sesion other = (Sesion) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
