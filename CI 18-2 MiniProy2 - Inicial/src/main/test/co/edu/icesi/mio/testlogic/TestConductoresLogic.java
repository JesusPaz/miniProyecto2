package co.edu.icesi.mio.testlogic;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import co.edu.icesi.mio.logic.ICondutoresLogic;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class TestConductoresLogic {

	@Autowired
	private ICondutoresLogic conductorLogic;
	
	@Test
	public void aTest() {

		assertNotNull(conductorLogic);
		
//		dummyLogic.crearConductor();
		
	}
}
