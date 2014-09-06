package br.com.ServerRouteSOAP.DAO;

import java.math.BigInteger;
import java.util.List;

import br.com.ServerRouteSOAP.model.Vertice;

public interface VerticeService {

	public Vertice save(Vertice vertice);

	public void remove(Vertice vertice);

	public Vertice find(BigInteger id);

	public List<Vertice> findAll();
}
