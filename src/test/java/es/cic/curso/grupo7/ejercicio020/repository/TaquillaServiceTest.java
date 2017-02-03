package es.cic.curso.grupo7.ejercicio020.repository;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import es.cic.curso.grupo7.ejercicio020.dto.Sala;
import es.cic.curso.grupo7.ejercicio020.exception.MyException;
import es.cic.curso.grupo7.ejercicio020.service.TaquillaService;
import es.cic.curso.grupo7.ejercicio020.dto.Sesion;
import es.cic.curso.grupo7.ejercicio020.dto.Taquilla;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations={
				"classpath:es/cic/curso/grupo7/ejercicio020/applicationContext.xml"
				})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
	TransactionalTestExecutionListener.class})
@Transactional
public class TaquillaServiceTest {

	@Autowired
	private TaquillaService sut;
	
	@PersistenceContext
	private EntityManager em;

	
	private Long claveSala;
	private Long claveSesion;
	private Taquilla taquilla;
	
	@Before
	public void setUp() throws Exception {
		
		Sala sala = new Sala();
		sala.setAforo(300);
		sala.setNumeroSala(1);
		sala.setRecaudacion(100);
		em.persist(sala);
		claveSala = sala.getId();
		
		Sesion sesion = new Sesion();
		sesion.setNumeroSesion(1);
		sesion.setAforoLibre(290);
		sesion.setAforoOcupado(10);

		
		em.persist(sesion);
		claveSesion = sesion.getId();
	}

	
	@Test
	public void testVendeEntradas() throws MyException {
		
		assertTrue(true);

		
	}
	@Ignore
	@Test
	public void testCalcularAsientosLibres() {
		
	}
	@Ignore
	@Test
	public void testHayAsientosLibres() {
		
	}
	
		
}
