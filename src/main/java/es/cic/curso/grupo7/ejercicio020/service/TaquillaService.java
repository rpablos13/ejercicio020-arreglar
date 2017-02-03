package es.cic.curso.grupo7.ejercicio020.service;

import es.cic.curso.grupo7.ejercicio020.dto.Sala;
import es.cic.curso.grupo7.ejercicio020.dto.Sesion;
import es.cic.curso.grupo7.ejercicio020.exception.MyException;

public interface TaquillaService {

	void venderEntradas(int entradas, int sesion, Sala sala) throws MyException;
	int calcularAsientosLibres(Sesion sesion);
	boolean hayAsientosLibres(Sesion sesion);
	
	
	
	
}
