package co.edu.icesi.mio.logic;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.icesi.mio.dao.Tmio1_Conductores_DAO;
import co.edu.icesi.mio.dao.Tmio1_Servicios_DAO;
import co.edu.icesi.mio.model.Tmio1Conductore;
import co.edu.icesi.mio.model.Tmio1Servicio;

@Service
public class Tmio1_Servicios_Logic {
	

EntityManagerFactory managerFactor = Persistence.createEntityManagerFactory("MiniProyectoComputacion");
	
	// atributos
	@PersistenceContext
    private EntityManager em= managerFactor.createEntityManager();
	
	@Autowired
    private Tmio1_Servicios_DAO serviciosDAO;
	
	
	//METODOS
	
		// SERVICIOS
		
//	 las llaves foráneas existan; la fecha inicio esté definida y sea menor o
//	 igual que la fecha final. “La solución debe validar que al momento de crear un nuevo servicio,
//	 tanto el bus como el conductor se encuentren disponibles, es decir que no se encuentren
//	 asignados a otro servicio que coincida con las fechas, días y horarios establecidos.”
	 
		public boolean validarServicio(Tmio1Servicio servicio) {
			//TODO
			boolean ret =false;
			// validar llaves foraneas
			if(servicio.getTmio1Bus()!=null) {
				//validar fecha inicio y fin
				if(servicio.getTmio1Ruta().getDiaFin()!=null) {
					// validar bus y conductor esten disponibles
					if(servicio.getTmio1Bus()!=null) {
						ret=true;
					}
				}
				
			}
			return ret;
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
