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
import co.edu.icesi.mio.logic.Tmio1_Conductores_Logic;
import co.edu.icesi.mio.model.Tmio1Bus;
import co.edu.icesi.mio.model.Tmio1Servicio;
import co.edu.icesi.mio.model.Tmio1ServiciosSitio;

public class TestBusesLogic {

	
	private IBusesLogic busesLogic ;
	
	@Before
	public void setupEscenario1() {

		busesLogic= new Tmio1_Buses_Logic();
	}
	

	
//	@Test
//	@Before
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
	
	/*
	 * Prueba con modelo = 2015 por lo tanto funciona bien
	 */
	
	@Test
	public void buscarModeloTest1() {
		
		assertNotNull(busesLogic);
		
		
		List<Tmio1Bus> buses = busesLogic.buscarBusModelo(new BigDecimal(2015));
	
		assertNotNull("No se encontro el bus por ese modelo", buses);	
		assertEquals(2, buses.size());
		
	}
	
	/*
	 * Prueba con modelo = 2018 por lo tanto funciona bien
	 */
	
	@Test
	public void buscarModeloTest2() {
		
		assertNotNull(busesLogic);
		
		
		List<Tmio1Bus> buses = busesLogic.buscarBusModelo(new BigDecimal(2018));
	
		assertNotNull("No se encontro el bus por ese modelo", buses);	
		assertEquals(1, buses.size());
		
	}
	
	/*
	 * Prueba con modelo = null por lo tanto funciona mal
	 */
	
	
	@Test
	public void buscarModeloTest3() {
		
		assertNotNull(busesLogic);
	
		List<Tmio1Bus> buses = busesLogic.buscarBusModelo(null);
	
		assertNull("No se encontro el bus por ese modelo", buses);	
		
		
	}
	
	/*
	 * Prueba con modelo = 1000 por lo tanto funciona bien
	 */
	
	
	@Test
	public void buscarModeloTest4() {
		
		assertNotNull(busesLogic);
		
		
		List<Tmio1Bus> buses = busesLogic.buscarBusModelo(new BigDecimal(1000));
	
		assertNotNull("No se encontro el bus por ese modelo", buses);	
		assertEquals(0, buses.size());
		
	}
	
	
	/*
	 * Prueba con modelo = 2 por lo tanto funciona mal
	 */
	
	@Test
	public void buscarModeloTest5() {
		
		assertNotNull(busesLogic);
		
		
		List<Tmio1Bus> buses = busesLogic.buscarBusModelo(new BigDecimal(2));
	
		assertNull("No se encontro el bus por ese modelo", buses);	
		
		
	}
	
	/*
	 * Prueba con tipo = T por lo tanto funciona bien
	 */
	
	@Test
	public void buscarTipoTest1() {
		assertNotNull(busesLogic);
		List<Tmio1Bus> buses = busesLogic.buscarBusTipo("T");
		
		assertNotNull("No se encontro el bus por ese modelo", buses);	
		assertEquals(2, buses.size());
	}
	
	/*
	 * Prueba con tipo = P por lo tanto funciona bien
	 */
	
	@Test
	public void buscarTipoTest2() {
		assertNotNull(busesLogic);
		List<Tmio1Bus> buses = busesLogic.buscarBusTipo("P");
		
		assertNotNull("No se encontro el bus por ese modelo", buses);	
		assertEquals(0, buses.size());
	}
	
	/*
	 * Prueba con tipo = A por lo tanto funciona bien
	 */
	
	@Test
	public void buscarTipoTest3() {
		assertNotNull(busesLogic);
		List<Tmio1Bus> buses = busesLogic.buscarBusTipo("A");
		
		assertNotNull("No se encontro el bus por ese modelo", buses);	
		assertEquals(2, buses.size());
	}
	
	/*
	 * Prueba con tipo = null por lo tanto funciona mal
	 */
	
	@Test
	public void buscarTipoTest4() {
		assertNotNull(busesLogic);
		List<Tmio1Bus> buses = busesLogic.buscarBusTipo(null);
		
		assertNull("No se encontro el bus por ese modelo", buses);	
	
	}
	/*
	 * Prueba con tipo = w por lo tanto funciona bien
	 */
	
	
	@Test
	public void buscarTipoTest5() {
		assertNotNull(busesLogic);
		List<Tmio1Bus> buses = busesLogic.buscarBusTipo("W");
		
		assertNull("No se encontro el bus por ese modelo", buses);	
		
	}

	/*
	 * Prueba con capacidad = 2000 por lo tanto funciona bien
	 */
	
	
	@Test
	public void buscarCapacidadTest1() {
		assertNotNull(busesLogic);
		List<Tmio1Bus> buses = busesLogic.buscarBusCapacidad(new BigDecimal(2000));
		
		assertNotNull("No se encontro el bus por ese modelo", buses);	
		assertEquals(3, buses.size());
	}
	
	/*
	 * Prueba con capacidad = 3000 por lo tanto funciona bien
	 */
	
	@Test
	public void buscarCapacidadTest2() {
		assertNotNull(busesLogic);
		List<Tmio1Bus> buses = busesLogic.buscarBusCapacidad(new BigDecimal(3000));
		
		assertNotNull("No se encontro el bus por ese modelo", buses);	
		assertEquals(1, buses.size());
	}
	
	/*
	 * Prueba con capacidad = null por lo tanto funciona mal
	 */
	
	@Test
	public void buscarCapacidadTest3() {
		assertNotNull(busesLogic);
		List<Tmio1Bus> buses = busesLogic.buscarBusCapacidad(null);
		
		assertNull("No se encontro el bus por ese modelo", buses);	
		
	}
	
	/*
	 * Prueba con capacidad = 0 por lo tanto funciona mal
	 */
	
	@Test
	public void buscarCapacidadTest4() {
		assertNotNull(busesLogic);
		List<Tmio1Bus> buses = busesLogic.buscarBusCapacidad(new BigDecimal(0));
		
		assertNull("No se encontro el bus por ese modelo", buses);	
		
	}
	
	/*
	 * Prueba con capacidad = -10 por lo tanto funciona mal
	 */
	
	@Test
	public void buscarCapacidadTest5() {
		assertNotNull(busesLogic);
		List<Tmio1Bus> buses = busesLogic.buscarBusCapacidad(new BigDecimal(-10));
		
		assertNull("No se encontro el bus por ese modelo", buses);	
		
	}
	
	
	public void actualizarTest() {
		
	}
	
	/*
	 * prueba con datos de la prueba crearTest, funciona bien
	 */
//	@Test
//	@After
	public void borrarTest1() {

		assertTrue(busesLogic.borrarBus(busesLogic.buscarPlaca("KGZ310")));
		assertTrue(busesLogic.borrarBus(busesLogic.buscarPlaca("IZU339")));
		assertTrue(busesLogic.borrarBus(busesLogic.buscarPlaca("DMS444")));
		assertTrue(busesLogic.borrarBus(busesLogic.buscarPlaca("MSX233")));
	}
	

	/*
	 * Prueba con placa = "" por lo tanto funciona mal
	 */
	@Test 
	public void borrarTest2() {
		
		Tmio1Bus bus = new Tmio1Bus();
		
		bus.setCapacidad(new BigDecimal(2000));
		bus.setMarca("Renault");
		bus.setModelo(new BigDecimal(2015));
		bus.setPlaca("");
		bus.setTipo("T");
		bus.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		bus.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		
	
		assertFalse(busesLogic.borrarBus(bus));
	}
	
	/*
	 * Prueba con placa = "ADS48552" por lo tanto funciona mal
	 */
	@Test 
	public void borrarTest3() {
		
		Tmio1Bus bus = new Tmio1Bus();
		
		bus.setCapacidad(new BigDecimal(2000));
		bus.setMarca("Renault");
		bus.setModelo(new BigDecimal(2015));
		bus.setPlaca("ADS48552");
		bus.setTipo("T");
		bus.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		bus.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		
	
		assertFalse(busesLogic.borrarBus(bus));
	}
	
	/*
	 * Prueba con modelo = -20 por lo tanto funciona mal
	 */
	
	@Test 
	public void borrarTest4() {
		
		Tmio1Bus bus = new Tmio1Bus();
		
		bus.setCapacidad(new BigDecimal(2000));
		bus.setMarca("Renault");
		bus.setModelo(new BigDecimal(-20));
		bus.setPlaca("KGZ310");
		bus.setTipo("T");
		bus.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		bus.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		
	
		assertFalse(busesLogic.borrarBus(bus));
	}
	
	/*
	 * Prueba con marca = "IP" por lo tanto funciona mal
	 */
	@Test 
	public void borrarTest5() {
		
		Tmio1Bus bus = new Tmio1Bus();
		
		bus.setCapacidad(new BigDecimal(2000));
		bus.setMarca("IP");
		bus.setModelo(new BigDecimal(2015));
		bus.setPlaca("KGZ310");
		bus.setTipo("T");
		bus.setTmio1Servicios(new ArrayList<Tmio1Servicio>());
		bus.setTmio1ServiciosSitios(new ArrayList<Tmio1ServiciosSitio>());
		
	
		assertFalse(busesLogic.borrarBus(bus));
	}
	
	
	

}
