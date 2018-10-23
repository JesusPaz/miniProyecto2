package co.edu.icesi.mio.logic;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.icesi.mio.dao.Tmio1_Conductores_DAO;
import co.edu.icesi.mio.dao.Tmio1_Servicios_DAO;
import co.edu.icesi.mio.model.Tmio1Conductore;

public class Tmio1_Servicios_Logic {
	

	// atributos
	@PersistenceContext
    private EntityManager em;
	
	@Autowired
    private Tmio1_Servicios_DAO serviciosDAO;
	
	
	//METODOS
	
		// SERVICIOS
		
		public boolean validarConductor(Tmio1Conductore cond) {
			return false;
		}
	

}
