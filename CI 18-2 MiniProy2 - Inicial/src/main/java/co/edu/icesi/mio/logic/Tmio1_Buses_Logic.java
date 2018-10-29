package co.edu.icesi.mio.logic;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.mio.dao.Tmio1_Buses_DAO;
import co.edu.icesi.mio.model.Tmio1Bus;

@Service
public class Tmio1_Buses_Logic {
	

EntityManagerFactory managerFactor = Persistence.createEntityManagerFactory("MiniProyectoComputacion");
	
	// atributos
	@PersistenceContext
    private EntityManager em= managerFactor.createEntityManager();
	
	@Autowired
    private Tmio1_Buses_DAO busesDAO;
	
	

//	 la placa esté definida y tenga seis caracteres; la marca esté definida y tenga
//	 al menos tres caracteres; el modelo sea numérico de cuatro dígitos; el tipo sea P, A, o T; la
//	 capacidad sea numérica mayor a cero.
	
	public boolean validarBus(Tmio1Bus bus) {
		/*
		 * Validación esta completa
		 */
		boolean ret=false;
		// valida la placa
		if(!bus.getPlaca().equals("") && bus.getPlaca()!=null && bus.getPlaca().length()==6) {
			// valida la marca
			if(!bus.getMarca().equals("") && bus.getMarca()!=null && bus.getMarca().length()>=3) {
				// valida el modelo
				if(bus.getModelo()!=null && bus.getModelo().compareTo(new BigDecimal(1000))>=0 ) {
					// valida el tipo
					if(bus.getTipo()!=null && (bus.getTipo().equals("P")||bus.getTipo().equals("A")||bus.getTipo().equals("T"))) {
						// valida la capacidad
						if(bus.getCapacidad()!=null && bus.getCapacidad().compareTo(new BigDecimal(0))>0) {
							ret=true;	
						}
					}
				}	
			}
		}
		return ret;
	}
	
	@Transactional
	public boolean crearBus(Tmio1Bus bus) {
		
		
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
		
		
		
		if(modelo!=null && modelo.compareTo(new BigDecimal(1000))>=0) {

			em.getTransaction().begin();
			List<Tmio1Bus> act= busesDAO.findByModel(em, modelo);
			em.getTransaction().commit();
			
			return act;
		}else {
			return null;	
		}
		
	}
	

	public List<Tmio1Bus> buscarBusTipo(String tipo) {
		
		
		if(tipo!=null && (tipo.equals("P")||tipo.equals("A")||tipo.equals("T"))) {

			em.getTransaction().begin();
			List<Tmio1Bus> act= busesDAO.findByType(em, tipo);
			em.getTransaction().commit();
			
			return act;
		}else {
			return null;	
		}
		
	}
	

	public List<Tmio1Bus> buscarBusCapacidad(BigDecimal capacidad) {
		
		
		if(capacidad!=null && capacidad.compareTo(new BigDecimal(0))>0) {

			em.getTransaction().begin();
			List<Tmio1Bus> act= busesDAO.findByCapacity(em, capacidad);
			em.getTransaction().commit();
			
			return act;
		}else {
			return null;	
		}
		
	}


}
