package co.edu.icesi.mio.logic;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.icesi.mio.dao.Tmio1_Buses_DAO;
import co.edu.icesi.mio.model.Tmio1Bus;

public class Tmio1_Buses_Logic {
	

	// atributos
	@PersistenceContext
    private EntityManager em;
	
	@Autowired
    private Tmio1_Buses_DAO busesDAO;
	
	
	

	public boolean validarBus(Tmio1Bus bus) {
		return false;
	}
	
	public boolean crearBus(Tmio1Bus bus) {
		
		// falta hacer todas las validaciones
		if(validarBus(bus)) {

			em.getTransaction().begin();
			busesDAO.save(em, bus);
			em.getTransaction().commit();
			
			return true;
		}else {
			return false;	
		}
		
		
	}
	
	public boolean actualizarBus(Tmio1Bus bus) {
		
		// falta hacer todas las validaciones
		if(validarBus(bus)) {

			em.getTransaction().begin();
			busesDAO.update(em, bus);
			em.getTransaction().commit();
			
			return true;
		}else {
			return false;	
		}

	}
	
	
	public boolean borrarBus(Tmio1Bus bus) {
		
		// falta hacer todas las validaciones
		if(validarBus(bus)) {

			em.getTransaction().begin();
			busesDAO.delete(em, bus);
			em.getTransaction().commit();
			
			return true;
		}else {
			return false;	
		}

	}
	
	
	public List<Tmio1Bus> buscarBusModelo(BigDecimal modelo) {
		
		
		// falta hacer todas las validaciones
		if(modelo!=null) {

			em.getTransaction().begin();
			List<Tmio1Bus> act= busesDAO.findByModel(em, modelo);
			em.getTransaction().commit();
			
			return act;
		}else {
			return null;	
		}
		
	}
	

	public List<Tmio1Bus> buscarBusTipo(String tipo) {
		
		// falta hacer todas las validaciones
		if(tipo!=null) {

			em.getTransaction().begin();
			List<Tmio1Bus> act= busesDAO.findByType(em, tipo);
			em.getTransaction().commit();
			
			return act;
		}else {
			return null;	
		}
		
	}
	

	public List<Tmio1Bus> buscarBusCapacidad(BigDecimal capacidad) {
		
		// falta hacer todas las validaciones
		if(capacidad!=null) {

			em.getTransaction().begin();
			List<Tmio1Bus> act= busesDAO.findByCapacity(em, capacidad);
			em.getTransaction().commit();
			
			return act;
		}else {
			return null;	
		}
		
	}


}
