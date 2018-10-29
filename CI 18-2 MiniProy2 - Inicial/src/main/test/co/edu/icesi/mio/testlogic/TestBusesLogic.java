package co.edu.icesi.mio.testlogic;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import co.edu.icesi.mio.logic.IBusesLogic;
import co.edu.icesi.mio.logic.Tmio1_Buses_Logic;
import co.edu.icesi.mio.model.Tmio1Bus;
import co.edu.icesi.mio.model.Tmio1Servicio;
import co.edu.icesi.mio.model.Tmio1ServiciosSitio;

public class TestBusesLogic {

	@Autowired
	private IBusesLogic busesLogic;

	@Before
	public void setupEscenario1() {

		busesLogic=new Tmio1_Buses_Logic();
	}
	
	@Test
	@After
	public void crearTest() {
		
	
		assertNotNull(busesLogic);
		
		
		Tmio1Bus bus = new Tmio1Bus();
		
		bus.setCapacidad(new BigDecimal(2000));
		bus.setMarca("Renault");
		bus.setModelo(new BigDecimal(2015));
		bus.setPlaca("KGZ310");
		bus.setTipo("T");
		bus.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		bus.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		
		
		Tmio1Bus bus1 = new Tmio1Bus();
		
		bus1.setCapacidad(new BigDecimal(3000));
		bus1.setMarca("Renault");
		bus1.setModelo(new BigDecimal(2014));
		bus1.setPlaca("IZU339");
		bus1.setTipo("T");
		bus1.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		bus1.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		
		
		
		Tmio1Bus bus2 = new Tmio1Bus();
		
		bus2.setCapacidad(new BigDecimal(2000));
		bus2.setMarca("Kia");
		bus2.setModelo(new BigDecimal(2015));
		bus2.setPlaca("DMS444");
		bus2.setTipo("A");
		bus2.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		bus2.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		
		
		Tmio1Bus bus3 = new Tmio1Bus();
		
		bus3.setCapacidad(new BigDecimal(2000));
		bus3.setMarca("Mercedes");
		bus3.setModelo(new BigDecimal(2018));
		bus3.setPlaca("MSX233");
		bus3.setTipo("A");
		bus3.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		bus3.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		
		
		assertTrue(busesLogic.crearBus(bus));
		assertTrue(busesLogic.crearBus(bus1));
		assertTrue(busesLogic.crearBus(bus2));
		assertTrue(busesLogic.crearBus(bus3));
		
	}
	
	@Test
	public void buscarModeloTest() {
		
		assertNotNull(busesLogic);
		
		
		List<Tmio1Bus> buses = busesLogic.buscarBusModelo(new BigDecimal(2015));
	
		assertNotNull("No se encontro el bus por ese modelo", buses);	
		assertEquals(2, buses.size());
		
	}
	
	@Test
	public void buscarTipoTest() {
		assertNotNull(busesLogic);
		List<Tmio1Bus> buses = busesLogic.buscarBusTipo("T");
		
		assertNotNull("No se encontro el bus por ese modelo", buses);	
		assertEquals(2, buses.size());
	}

	@Test
	public void buscarCapacidadTest() {
		assertNotNull(busesLogic);
		List<Tmio1Bus> buses = busesLogic.buscarBusCapacidad(new BigDecimal(2000));
		
		assertNotNull("No se encontro el bus por ese modelo", buses);	
		assertEquals(2, buses.size());
	}
	
	
	
	

}
