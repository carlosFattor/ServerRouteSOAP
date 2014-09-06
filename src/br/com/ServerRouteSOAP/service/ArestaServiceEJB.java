package br.com.ServerRouteSOAP.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.ServerRouteSOAP.DAO.ArestaService;
import br.com.ServerRouteSOAP.DAO.GenericDAO;
import br.com.ServerRouteSOAP.model.Aresta;

@Stateless
public class ArestaServiceEJB extends GenericDAO<Aresta, Long> implements
		ArestaService {

	
	public ArestaServiceEJB(Class<Aresta> entityClass) {
		super(entityClass);
	}

	@PersistenceContext(unitName = "rotasPU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public ArestaServiceEJB() {
		super(Aresta.class);
	}
}