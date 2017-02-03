package es.cic.curso.grupo7.ejercicio020.repository;

import es.cic.curso.grupo7.ejercicio020.dto.Sala;
import es.cic.curso.grupo7.ejercicio020.dto.Sesion;
import es.cic.curso.grupo7.ejercicio020.exception.MyException;

public interface TaquillaRepository {

	
	public void vendeEntrada(int entradas,int sesion, Sala sala) throws MyException;
	
	public boolean hayEntradas(int numeroEntradas,int sala, int sesion) throws MyException;
	
	public int calcularAsientosLibres(Sesion sesion);

	boolean hayAsientosLibres(int aforo, Sesion entrada);
	
	
}
