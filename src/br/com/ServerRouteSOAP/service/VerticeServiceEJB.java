package br.com.ServerRouteSOAP.service;

import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.ServerRouteSOAP.DAO.GenericDAO;
import br.com.ServerRouteSOAP.DAO.VerticeService;
import br.com.ServerRouteSOAP.model.Vertice;

public class VerticeServiceEJB extends GenericDAO<Vertice, Long> implements
		VerticeService {

	@PersistenceContext(unitName = "rotasPU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public VerticeServiceEJB() {
		super(Vertice.class);
	}

	@Override
	public Vertice find(BigInteger id) {
		// TODO Auto-generated method stub
		return null;
	}
}
