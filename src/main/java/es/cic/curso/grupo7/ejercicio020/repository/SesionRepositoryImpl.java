package es.cic.curso.grupo7.ejercicio020.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.cic.curso.grupo7.ejercicio020.dto.Sesion;


@Repository
@Transactional
public class SesionRepositoryImpl extends AbstractRepositoryImpl<Long, Sesion> implements SesionRepository {
	
	@Override
	public Class<Sesion> getClassDeT() {
		return Sesion.class;
	}

	@Override
	public String getNombreTabla() {
		return "SESION";
	}	


}
