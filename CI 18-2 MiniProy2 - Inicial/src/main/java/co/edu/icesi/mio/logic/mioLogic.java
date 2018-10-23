package co.edu.icesi.mio.logic;


import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.icesi.mio.dao.Tmio1_Buses_DAO;
import co.edu.icesi.mio.dao.Tmio1_Conductores_DAO;
import co.edu.icesi.mio.dao.Tmio1_Rutas_DAO;
import co.edu.icesi.mio.model.Tmio1Bus;
import co.edu.icesi.mio.model.Tmio1Conductore;
import co.edu.icesi.mio.model.Tmio1Ruta;

public class mioLogic {
	
	// atributos
	@PersistenceContext
    private EntityManager em;
    
	@Autowired
    private Tmio1_Conductores_DAO conductorDAO;
	
	@Autowired
    private Tmio1_Rutas_DAO rutasDAO;
	
	
	@Autowired
    private Tmio1_Buses_DAO busesDAO;
	
	
	
	
	
	
	//METODOS
	
	// CONDUCTORES
	
	public boolean validarConductor(Tmio1Conductore cond) {
		return false;
	}
	public boolean crearConductor(Tmio1Conductore cond) {
		
		// falta hacer todas las validaciones
		if(validarConductor(cond)) {

			em.getTransaction().begin();
			conductorDAO.save(em, cond);
			em.getTransaction().commit();
			
			return true;
		}else {
			return false;	
		}
		
		
	}
	
	public boolean actualizarConductor(Tmio1Conductore cond) {
		
		
		// falta hacer todas las validaciones
		if(validarConductor(cond)) {

			em.getTransaction().begin();
			conductorDAO.update(em, cond);
			em.getTransaction().commit();
			
			return true;
		}else {
			return false;	
		}
		
	}
	
	
	public boolean borrarConductor(Tmio1Conductore cond) {
		
		// falta hacer todas las validaciones
		if(validarConductor(cond)) {

			em.getTransaction().begin();
			conductorDAO.delete(em, cond);
			em.getTransaction().commit();
			
			return true;
		}else {
			return false;	
		}
		
	}
	
	

	public List<Tmio1Conductore> buscarConductorNombre(String nombre) {
		// falta hacer todas las validaciones
		if(!nombre.equals("")) {

			em.getTransaction().begin();
			List<Tmio1Conductore> act=conductorDAO.findByName(em, nombre);
			em.getTransaction().commit();
			
			return act;
		}else {
			return null;	
		}
		
	}
	

	public List<Tmio1Conductore> buscarConductorApellido(String apellido) {
		// falta hacer todas las validaciones
		if(!apellido.equals("")) {

			em.getTransaction().begin();
			List<Tmio1Conductore> act=conductorDAO.findByLastName(em, apellido);
			em.getTransaction().commit();
			
			return act;
		}else {
			return null;	
		}
		
	}
	

	public Tmio1Conductore buscarConductorCedula(String cedula) {
		// falta hacer todas las validaciones
		if(!cedula.equals("")) {

			em.getTransaction().begin();
			Tmio1Conductore act=conductorDAO.findByCedula(em, cedula);
			em.getTransaction().commit();
			
			return act;
		}else {
			return null;	
		}
		
	}
	
	
		
	//RUTAS
	
	
	public boolean validarRuta(Tmio1Ruta ruta) {
		return false;
	}
	public boolean crearRuta(Tmio1Ruta ruta) {
		
		// falta hacer todas las validaciones
		if(validarRuta(ruta)) {

			em.getTransaction().begin();
			rutasDAO.save(em, ruta);
			em.getTransaction().commit();
			
			return true;
		}else {
			return false;	
		}
		
	}
	
	public boolean actualizarRuta(Tmio1Ruta ruta) {
		
		// falta hacer todas las validaciones
		if(validarRuta(ruta)) {

			em.getTransaction().begin();
			rutasDAO.update(em, ruta);
			em.getTransaction().commit();
			
			return true;
		}else {
			return false;	
		}
		
	}
	
	
	public boolean borrarRuta(Tmio1Ruta ruta) {
		
		// falta hacer todas las validaciones
		if(validarRuta(ruta)) {

			em.getTransaction().begin();
			rutasDAO.delete(em, ruta);
			em.getTransaction().commit();
			
			return true;
		}else {
			return false;	
		}
		
	}
	
	public List<Tmio1Ruta> buscarRutaRango(BigDecimal diaInicio, BigDecimal diaFin) {
		
		
		// falta hacer todas las validaciones
		if(diaInicio!=null&&diaFin!=null) {

			em.getTransaction().begin();
			List<Tmio1Ruta> act=rutasDAO.findByRangeOfDays(em, diaInicio, diaFin);
			em.getTransaction().commit();
			
			return act;
		}else {
			return null;	
		}
		
	}
	
	//	BUSES
	
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
