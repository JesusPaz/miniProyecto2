package co.edu.icesi.mio.logic;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.icesi.mio.dao.Tmio1_Rutas_DAO;
import co.edu.icesi.mio.model.Tmio1Ruta;

@Service
public class Tmio1_Rutas_Logic {
	

EntityManagerFactory managerFactor = Persistence.createEntityManagerFactory("MiniProyectoComputacion");
	
	// atributos
	@PersistenceContext
    private EntityManager em= managerFactor.createEntityManager();
	
	@Autowired
    private Tmio1_Rutas_DAO rutasDAO;
	
	
//	 el número de ruta tenga tres caracteres; el día inicio y fin sean numéricos
//	 entre 1 y 7 y el inicio sea menor o igual al fin; la hora inicio y fin sean numéricos entre 1 y
//	 1440 y el inicio sea menor o igual al fin; activa sea S o N.

	public boolean validarRuta(Tmio1Ruta ruta) {
		boolean ret = false;
		//TODO
		// validar numero ruta
		if(ruta.getNumero()!=null) {
			// validar dia inicio y fin
			if(ruta.getDiaFin()!=null && ruta.getDiaInicio()!=null) {
				//validar hora inicio y fin
				if(ruta.getHoraInicio()!= null && ruta.getHoraFin()!=null) {
					//validar activa
					if(ruta.getActiva()!=null) {
						ret=true;
					}
				}
			}
		}
		return ret;
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
