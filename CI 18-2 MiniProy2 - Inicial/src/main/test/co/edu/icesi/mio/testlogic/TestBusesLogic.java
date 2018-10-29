package co.edu.icesi.mio.testlogic;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import co.edu.icesi.mio.logic.IBusesLogic;
import co.edu.icesi.mio.logic.Tmio1_Buses_Logic;

public class TestBusesLogic {

	@Autowired
	private IBusesLogic busesLogic;

	public void setupEscenario1() {

		busesLogic=new Tmio1_Buses_Logic();
	}

}
