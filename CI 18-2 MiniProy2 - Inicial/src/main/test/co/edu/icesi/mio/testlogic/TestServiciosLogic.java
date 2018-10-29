package co.edu.icesi.mio.testlogic;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import co.edu.icesi.mio.logic.*;
import co.edu.icesi.mio.logic.*;

public class TestServiciosLogic {
	
	@Autowired
	private IServiciosLogic serviciosLogic;

	public void setupEscenario1() {

		serviciosLogic=new Tmio1_Servicios_Logic();
	}
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
