package es.cic.curso.grupo7.ejercicio020.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.cic.curso.grupo7.ejercicio020.dto.Sala;
import es.cic.curso.grupo7.ejercicio020.repository.AbstractRepositoryImpl;
import es.cic.curso.grupo7.ejercicio020.repository.SalaRepository;

@Repository
@Transactional
public class SalaRepositoryImpl extends AbstractRepositoryImpl<Long, Sala> implements SalaRepository {

	
	@Override
	public Class<Sala> getClassDeT() {
		return Sala.class;
	}

	@Override
	public String getNombreTabla() {
		return "SALA";
	}	


	
	
	
//	@PersistenceContext
//	private EntityManager entityManager;
//	
//	public Sala add(Sala nuevo) {
//		entityManager.persist(nuevo);
//		return nuevo;
//	}
//
//	
//	@Override
//	public Sala read(Long id) {
//		Sala resultado = entityManager.find(Sala.class, id);
//		return resultado;
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Sala> list() {
//		return entityManager
//				.createNativeQuery("select id, nombre from SALA", Sala.class)
//				.getResultList();
//	}
//
//	@Override
//	public List<Sala> listJPQL() {
//		return entityManager
//				.createQuery("select c from SALA c", Sala.class)
//				.getResultList();
//	}
//
//	@Override
//	public void delete(Long id) {
//		Sala sala = new Sala();
//		sala.setId(id);
//		delete(sala);
//	}	
//	
//
//	private void delete(Sala sala) {
//		sala = read(sala.getId());
//		entityManager.remove(sala);
//	}
//
//	@Override
//	public Sala update(Sala modificado) {
//		modificado = entityManager.merge(modificado);
//		return modificado;
//	}
//
//

}
