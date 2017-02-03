package es.cic.curso.grupo7.ejercicio020.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cic.curso.grupo7.ejercicio020.dto.Sala;
import es.cic.curso.grupo7.ejercicio020.dto.Sesion;
import es.cic.curso.grupo7.ejercicio020.dto.Taquilla;
import es.cic.curso.grupo7.ejercicio020.exception.MyException;
import es.cic.curso.grupo7.ejercicio020.repository.SalaRepository;
import es.cic.curso.grupo7.ejercicio020.repository.SesionRepository;
import es.cic.curso.grupo7.ejercicio020.repository.TaquillaRepository;
import es.cic.curso.grupo7.ejercicio020.service.TaquillaService;

@Service
public class TaquillaServiceImpl implements TaquillaService {

	
	@Autowired
	private TaquillaRepository taquillaRepo;
	
	@Autowired
	private SesionRepository sesionRepo;
	
	@Autowired
	private SalaRepository salaRepo;
	
	
	@Override
	public void venderEntradas(int entradas, int sesion, Sala sala) throws MyException {
			
		int asientosLibres = sala.getSesiones().get(sesion).getAforoLibre();
		
		int butacas = asientosLibres - entradas;
		if(butacas<0) {
			return;
		}
		
		taquillaRepo.vendeEntrada(entradas, sesion, sala);
		
	}

	@Override
	public int calcularAsientosLibres(Sesion sesion) {
		return taquillaRepo.calcularAsientosLibres(sesion);
	}

	@Override
	public boolean hayAsientosLibres(Sesion sesion) {
		
		if (sesion.getAforoLibre() > 0) {
			return true;
		}else {
			return false;
		}
	}


}
