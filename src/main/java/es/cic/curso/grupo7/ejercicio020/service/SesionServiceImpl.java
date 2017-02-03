package es.cic.curso.grupo7.ejercicio020.service;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cic.curso.grupo7.ejercicio020.dto.Sesion;
import es.cic.curso.grupo7.ejercicio020.exception.MyException;
import es.cic.curso.grupo7.ejercicio020.repository.SesionRepository;

@Service
public class SesionServiceImpl implements SesionService {

	@Autowired
	private SesionRepository sesionRepo;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Long aniadirSesion(int numeroSesion) {
		Sesion sesion = new Sesion();
		sesion.setNumeroSesion(numeroSesion);
		
		Sesion aniadido = aniadirSesion(sesion);
		
		return aniadido.getId();
	}
	
	
	private Sesion aniadirSesion(Sesion nuevaSesion) {
		
		sesionRepo.add(nuevaSesion);
		entityManager.flush();
		
		return nuevaSesion;
	}

	

	@Override
	public void modificarSesion(int numeroSesion, int aforoLibre, int aforoOcupado, Long id) {
		comprobarExistencia(id);
		
		Sesion sesionExistente = sesionRepo.read(id);
		sesionExistente.setNumeroSesion(numeroSesion);
		
		sesionRepo.update(sesionExistente);
		
	}

	@Override
	public void eliminarSesion(Long id) {
		Sesion viejaSesion = listarSesiones(id);
		sesionRepo.delete(viejaSesion);
		
	}

	@Override
	public Sesion listarSesiones(Long id) {
		return sesionRepo.read(id);
	}

	@Override
	public List<Sesion> obtenerListaSesiones() {
		return sesionRepo.list();
	}

	
	private void comprobarExistencia(Long id) {
		if (sesionRepo.read(id) == null) {
			throw new MyException("No existe la sesion: " + id);
		}
	}
	

}
