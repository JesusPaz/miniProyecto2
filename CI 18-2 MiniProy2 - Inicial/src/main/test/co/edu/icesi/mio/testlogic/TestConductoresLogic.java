package co.edu.icesi.mio.testlogic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

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

	@Test
	public void saveTest() {

		conductorLogic=new Tmio1_Conductores_Logic();
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
		
		assertTrue(conductorLogic.crearConductor(conductor));
		assertTrue(conductorLogic.crearConductor(conductor2));
		
	}
	
	
	@Test
	public void bTest() {

		assertNotNull(conductorLogic);
		
		
		
		
	}
	
	
	@Test
	public void cTest() {

		assertNotNull(conductorLogic);
		
		
	
		
	}
	
	
	@Test
	public void dTest() {

		assertNotNull(conductorLogic);
		
		
		
	}
	
	
	@Test
	public void eTest() {

		
		
	}
}
