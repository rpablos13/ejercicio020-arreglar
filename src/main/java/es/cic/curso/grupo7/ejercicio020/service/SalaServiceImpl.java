package es.cic.curso.grupo7.ejercicio020.service;

import java.util.List;


import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.cic.curso.grupo7.ejercicio020.dto.Sala;
import es.cic.curso.grupo7.ejercicio020.exception.MyException;
import es.cic.curso.grupo7.ejercicio020.repository.SalaRepository;

@Service
public class SalaServiceImpl implements SalaService {

	@Autowired
	private SalaRepository salaRepo;
	
	@PersistenceContext
	private EntityManager entityManager;

	
	
	@Override
	public void eliminarSala(Long id) {
		Sala viejaSala = listarSalas(id);
		salaRepo.delete(viejaSala);
		
	}

	@Override
	public Long aniadirSala(int numeroSala) {
		Sala salas = new Sala();
		salas.setNumeroSala(numeroSala);;
		
		Sala aniadido = aniadirSala(salas);
		
		return aniadido.getId();
	}
	
	private Sala aniadirSala(Sala nuevaSala) {
		
		salaRepo.add(nuevaSala);
		entityManager.flush();
		
		return nuevaSala;
	}

	@Override
	public void modificarSala(int numeroSala, int aforo, double recaudacion, Long id) {
		comprobarExistencia(id);
		
		Sala salaExistente = salaRepo.read(id);
		salaExistente.setNumeroSala(numeroSala);
		
		salaRepo.update(salaExistente);
	}

	@Override
	public Sala listarSalas(Long id) {
		return salaRepo.read(id);
	}

	@Override
	public List<Sala> obtenerListaSalas() {
		return salaRepo.list();
	}
	
	private void comprobarExistencia(Long id) {
		if (salaRepo.read(id) == null) {
			throw new MyException("No existe la sala: " + id);
		}
	}
	
	
		
}