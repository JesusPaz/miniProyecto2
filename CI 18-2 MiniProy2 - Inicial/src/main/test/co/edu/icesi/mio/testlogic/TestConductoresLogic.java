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
import co.edu.icesi.mio.model.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class TestConductoresLogic {

	@Autowired
	private ICondutoresLogic conductorLogic;
	
	
	ITmio1_Conductores_DAO conductorDao;
	
	@Test
	public void aTest() {

		assertNotNull(conductorLogic);
		assertNotNull(conductorDao);
		
		Tmio1Conductore conductor= new Tmio1Conductore();
		conductor.setCedula("01");
		conductor.setNombre("Diana");
		conductor.setApellidos("Torres");
		Calendar d = new GregorianCalendar(2018,01,20);
		conductor.setFechaContratacion(d.getTime());
		Calendar d1 = new GregorianCalendar(1998,01,20);
		conductor.setFechaNacimiento(d1.getTime());
		
		conductor.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		conductor.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		
		assertTrue(conductorLogic.crearConductor(conductor));
		
	}
}
