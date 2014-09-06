package br.com.ServerRouteSOAP.DAO;

import java.util.List;

import br.com.ServerRouteSOAP.model.Aresta;

public interface ArestaService {

	public Aresta save(Aresta aresta);

	public void remove(Aresta aresta);

	public Aresta find(Long id);

	public List<Aresta> findAll();
}
