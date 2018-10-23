package co.edu.icesi.mio.logic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.icesi.mio.dao.Tmio1_Conductores_DAO;
import co.edu.icesi.mio.model.Tmio1Conductore;

public class Tmio1_Conductores_Logic {
	

	// atributos
	@PersistenceContext
    private EntityManager em;
	

	@Autowired
    private Tmio1_Conductores_DAO conductorDAO;
	
	
	
	//METODOS
	
	// CONDUCTORES
	
	
//	la cédula esté definida y sea numérica; el nombre esté definido y
//	tenga por lo menos tres caracteres; el apellido esté definido y tenga por lo menos tres
//	caracteres; la fecha de nacimiento esté definida y sea mayor de edad; la fecha de contratación
//	esté definida y sea menor a la fecha actual.
//	
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
		if(!nombre.equals("") && nombre != null) {

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
		if(!apellido.equals("") && apellido!=null) {

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
		if(!cedula.equals("") && cedula !=null) {

			em.getTransaction().begin();
			Tmio1Conductore act=conductorDAO.findByCedula(em, cedula);
			em.getTransaction().commit();
			
			return act;
		}else {
			return null;	
		}
		
	}
	


}
