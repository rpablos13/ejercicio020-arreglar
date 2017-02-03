package es.cic.curso.grupo7.ejercicio020.service;

import java.util.List;


import es.cic.curso.grupo7.ejercicio020.dto.Sala;

public interface SalaService {
	
	Long aniadirSala(int numeroSala);
	void modificarSala(int numeroSala, int aforo, double recaudacion, Long id);
	void eliminarSala(Long id);
	Sala listarSalas(Long id);
	List<Sala> obtenerListaSalas();

}