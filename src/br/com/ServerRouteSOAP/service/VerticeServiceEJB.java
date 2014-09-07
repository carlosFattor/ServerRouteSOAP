package br.com.ServerRouteSOAP.service;

import java.math.BigInteger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.ServerRouteSOAP.DAO.GenericDAO;
import br.com.ServerRouteSOAP.DAO.VerticeService;
import br.com.ServerRouteSOAP.model.Vertice;

@Stateless
public class VerticeServiceEJB extends GenericDAO<Vertice, Long> implements
		VerticeService {

	public VerticeServiceEJB(){
		super(Vertice.class);
	}
	
	public VerticeServiceEJB(Class<Vertice> entityClass) {
		super(entityClass);
	}

	@PersistenceContext(unitName = "rotasPU")
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	@Override
	public Vertice find(BigInteger id) {
		return em.find(Vertice.class, id);
	}
}
