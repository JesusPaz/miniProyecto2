package co.edu.icesi.mio.logic;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.icesi.mio.dao.Tmio1_Rutas_DAO;
import co.edu.icesi.mio.model.Tmio1Ruta;

public class Tmio1_Rutas_Logic {
	

	// atributos
	@PersistenceContext
    private EntityManager em;
	
	@Autowired
    private Tmio1_Rutas_DAO rutasDAO;
	
	
	
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


}
