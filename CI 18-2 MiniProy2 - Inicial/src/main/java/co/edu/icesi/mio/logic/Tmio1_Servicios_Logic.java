package co.edu.icesi.mio.logic;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.icesi.mio.dao.Tmio1_Conductores_DAO;
import co.edu.icesi.mio.dao.Tmio1_Servicios_DAO;
import co.edu.icesi.mio.model.Tmio1Conductore;
import co.edu.icesi.mio.model.Tmio1Servicio;

public class Tmio1_Servicios_Logic {
	

	// atributos
	@PersistenceContext
    private EntityManager em;
	
	@Autowired
    private Tmio1_Servicios_DAO serviciosDAO;
	
	
	//METODOS
	
		// SERVICIOS
		
		public boolean validarServicio(Tmio1Servicio servicio) {
			return false;
		}
	

		public boolean crearServicio(Tmio1Servicio servicio) {
			
			// falta hacer todas las validaciones
			if(validarServicio(servicio)) {

				em.getTransaction().begin();
				serviciosDAO.save(em, servicio);
				em.getTransaction().commit();
				
				return true;
			}else {
				return false;	
			}
			
			
		}
		
		
		public boolean actualizarServicio(Tmio1Servicio servicio) {
			
			// falta hacer todas las validaciones
			if(validarServicio(servicio)) {

				em.getTransaction().begin();
				serviciosDAO.update(em, servicio);
				em.getTransaction().commit();
				
				return true;
			}else {
				return false;	
			}
			
			
		}
		
		
		public boolean borrarServicio(Tmio1Servicio servicio) {
			
			// falta hacer todas las validaciones
			if(validarServicio(servicio)) {

				em.getTransaction().begin();
				serviciosDAO.delete(em, servicio);
				em.getTransaction().commit();
				
				return true;
			}else {
				return false;	
			}
			
			
		}
		
		

		public List<Tmio1Servicio> buscarServicioRangoFechas(Calendar fechaInicio, Calendar fechaFin ) {
			// falta hacer todas las validaciones
			if(fechaInicio!=null && fechaFin!=null) {

				em.getTransaction().begin();
				List<Tmio1Servicio> act= serviciosDAO.findByRangeOfDates(em, fechaInicio, fechaFin);
				em.getTransaction().commit();
				
				return act;
			}else {
				return null;	
			}
			
		}
		
		
		
}
