package es.cic.curso.grupo7.ejercicio020.repository;

import static org.junit.Assert.*;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import es.cic.curso.grupo7.ejercicio020.dto.Sala;
import es.cic.curso.grupo7.ejercicio020.service.SalaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations={
				"classpath:es/cic/curso/grupo7/ejercicio020/applicationContext.xml"
				})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
	TransactionalTestExecutionListener.class})
@Transactional
public class SalaServiceTest {

	@Autowired
	private SalaService sut;
	
	@PersistenceContext
	private EntityManager em;
	
	@Before
	public void setUp() throws Exception {
		
		
	}
	
	@Test
	@Rollback(false)
	public void testAniadirSala() {
		
		
		Long nuevaSala = sut.aniadirSala(1);
		
		assertNotNull(nuevaSala);
	}
	
	@Test
	@Rollback(false)
	 public void testEliminarSala() {
		
		Long salaAniadida = sut.aniadirSala(1);
		
		sut.eliminarSala(salaAniadida);
		
		List<Sala> listaSalas = sut.obtenerListaSalas();
		
		assertTrue(listaSalas.size() == 0);
		
		
	}
	
	@Test
	@Rollback(false)
	public void testListarSalas() {
		
		List<Sala> listaSalas = sut.obtenerListaSalas();
		for(Sala salas : listaSalas){
		assertNotNull(salas.getId());
		
		
		}
	}

}
