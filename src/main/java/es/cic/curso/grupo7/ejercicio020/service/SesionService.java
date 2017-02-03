package es.cic.curso.grupo7.ejercicio020.service;

import java.util.List;


import es.cic.curso.grupo7.ejercicio020.dto.Sesion;

public interface SesionService {
	
	Long aniadirSesion(int numeroSesion);
	void modificarSesion(int numeroSesion, int aforoLibre, int aforoOcupado, Long id);
	void eliminarSesion(Long id);
	Sesion listarSesiones(Long id);
	List<Sesion> obtenerListaSesiones();

}
