package es.cic.curso.grupo7.ejercicio020.repository;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import es.cic.curso.grupo7.ejercicio020.dto.Sesion;
import es.cic.curso.grupo7.ejercicio020.service.SesionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations={
				"classpath:es/cic/curso/grupo7/ejercicio020/applicationContext.xml"
				})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
	TransactionalTestExecutionListener.class})
@Transactional
public class SesionServiceTest {

	@Autowired
	private SesionService sut;
	
	@PersistenceContext
	private EntityManager em;
	
	@Before
	public void setUp() throws Exception {
		
		
	}
	
	@Test
	public void testAniadirSesion() {
	
		Long nuevaSesion = sut.aniadirSesion(1);
		
		assertNotNull(nuevaSesion);
	}
	
	@Test
	 public void testEliminarSesion() {
		
		Long sesionAniadida = sut.aniadirSesion(1);
		
		sut.eliminarSesion(sesionAniadida);
		
		List<Sesion> listaSesiones = sut.obtenerListaSesiones();
		
		assertTrue(listaSesiones.size() == 0);
		
		
	}

	@Test
	public void testListarSesiones() {
		
		List<Sesion> listaSesiones = sut.obtenerListaSesiones();
		for(Sesion sesiones : listaSesiones){
		assertNotNull(sesiones.getId());
		
		
		}
	}

}
