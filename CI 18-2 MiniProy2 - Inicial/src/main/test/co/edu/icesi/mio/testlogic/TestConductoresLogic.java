package co.edu.icesi.mio.testlogic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.icesi.mio.dao.*;
import co.edu.icesi.mio.dao.*;
import co.edu.icesi.mio.logic.ICondutoresLogic;
import co.edu.icesi.mio.logic.Tmio1_Conductores_Logic;
import co.edu.icesi.mio.model.*;


public class TestConductoresLogic {

	@Autowired
	private ICondutoresLogic conductorLogic;

	public void setupEscenario1() {

		conductorLogic=new Tmio1_Conductores_Logic();
	}
	
	
	@Test
	public void saveTest() {

		setupEscenario1();
		assertNotNull(conductorLogic);
		
		
		Tmio1Conductore conductor= new Tmio1Conductore();
		conductor.setCedula("01");
		conductor.setNombre("Diana");
		conductor.setApellidos("Torres");
		Calendar d = new GregorianCalendar(2018,01,10);
		conductor.setFechaContratacion(d.getTime());
		Calendar d1 = new GregorianCalendar(1997,07,22);
		conductor.setFechaNacimiento(d1.getTime());
		conductor.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		conductor.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		
		
		Tmio1Conductore conductor3= new Tmio1Conductore();
		conductor3.setCedula("06");
		conductor3.setNombre("Diana");
		conductor3.setApellidos("Prince");
		Calendar d4 = new GregorianCalendar(2000,03,18);
		conductor3.setFechaContratacion(d4.getTime());
		Calendar d5 = new GregorianCalendar(1960,12,24);
		conductor3.setFechaNacimiento(d5.getTime());
		conductor3.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		conductor3.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		
		Tmio1Conductore conductor2= new Tmio1Conductore();
		conductor2.setCedula("02");
		conductor2.setNombre("Jesús");
		conductor2.setApellidos("Pazi");
		Calendar d2 = new GregorianCalendar(2017,07,03);
		conductor2.setFechaContratacion(d2.getTime());
		Calendar d3 = new GregorianCalendar(1998,05,20);
		conductor2.setFechaNacimiento(d3.getTime());
		conductor2.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		conductor2.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		
		Tmio1Conductore conductor4= new Tmio1Conductore();
		conductor4.setCedula("10");
		conductor4.setNombre("Valentina");
		conductor4.setApellidos("Tamura");
		Calendar d6 = new GregorianCalendar(2017,02,10);
		conductor4.setFechaContratacion(d6.getTime());
		Calendar d7 = new GregorianCalendar(2000,10,20);
		conductor4.setFechaNacimiento(d7.getTime());
		conductor4.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		conductor4.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		
		
		Tmio1Conductore conductor5= new Tmio1Conductore();
		conductor5.setCedula("123");
		conductor5.setNombre("Hillary");
		conductor5.setApellidos("Clinton");
		Calendar d8 = new GregorianCalendar(1950,02,14);
		conductor5.setFechaContratacion(d8.getTime());
		Calendar d9 = new GregorianCalendar(1970,11,10);
		conductor5.setFechaNacimiento(d9.getTime());
		conductor5.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		conductor5.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		
		Tmio1Conductore conductor6= new Tmio1Conductore();
		conductor6.setCedula("15");
		conductor6.setNombre("Jose");
		conductor6.setApellidos("Clinton");
		Calendar d10 = new GregorianCalendar(2016,05,02);
		conductor6.setFechaContratacion(d10.getTime());
		Calendar d11 = new GregorianCalendar(1998,05,02);
		conductor6.setFechaNacimiento(d11.getTime());
		conductor6.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		conductor6.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		
		assertTrue(conductorLogic.crearConductor(conductor));
		assertTrue(conductorLogic.crearConductor(conductor3));
		assertTrue(conductorLogic.crearConductor(conductor2));
		assertTrue(conductorLogic.crearConductor(conductor4));
		assertTrue(conductorLogic.crearConductor(conductor5));
		assertTrue(conductorLogic.crearConductor(conductor6));

		
		
		
	}
	
	
	@Test
	public void buscarPorNombreTest() {
		setupEscenario1();
		assertNotNull(conductorLogic);
		
		List<Tmio1Conductore> lista =conductorLogic.buscarConductorNombre("Diana");
		assertNotNull(lista);
		assertEquals(2,lista.size());
		
		
		
	}
	
	
	@Test
	public void buscarPorCedulaTest() {
		setupEscenario1();
		
		assertNotNull(conductorLogic);
		
		Tmio1Conductore c =conductorLogic.buscarConductorCedula("02");
		assertNotNull(c);
		assertEquals("02",c.getCedula());
	
		Tmio1Conductore c1 =conductorLogic.buscarConductorCedula("123");
		assertNotNull(c1);
		assertEquals("123",c1.getCedula());
		
		
		Tmio1Conductore c2 =conductorLogic.buscarConductorCedula("199");
		assertNull(c2);
		
		
	}
	
	
	@Test
	public void buscarPorApellidoTest() {
		setupEscenario1();
		
		assertNotNull(conductorLogic);
		
		List<Tmio1Conductore> lista =conductorLogic.buscarConductorApellido("Clinton");
		assertNotNull(lista);
		assertEquals(2,lista.size());
		
		List<Tmio1Conductore> lista2 =conductorLogic.buscarConductorApellido("Tamura");
		assertNotNull(lista2);
		assertEquals(1,lista2.size());
		
	}

	
	@Test
	public void borrarTest() {
		setupEscenario1();

		
		assertNotNull(conductorLogic);
		
		assertTrue(conductorLogic.borrarConductor(conductorLogic.buscarConductorCedula("15")));
		assertNull(conductorLogic.buscarConductorCedula("15"));
		assertTrue(conductorLogic.borrarConductor(conductorLogic.buscarConductorCedula("123")));
		assertNull(conductorLogic.buscarConductorCedula("123"));
		
		
	}
	
//	@Test
//	public void actualizarTest() {
//		setupEscenario1();
//		
//		
//	}
}
