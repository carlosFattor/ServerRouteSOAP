package br.com.ServerRouteSOAP.ws;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.ServerRouteSOAP.DAO.ArestaService;
import br.com.ServerRouteSOAP.DAO.VerticeService;
import br.com.ServerRouteSOAP.algoritmo.Dijkstra;
import br.com.ServerRouteSOAP.model.Aresta;
import br.com.ServerRouteSOAP.model.Grafo;
import br.com.ServerRouteSOAP.model.Vertice;

public class RouteServerCB {

	@Inject
	private VerticeService daoVertice;
	private ArestaService daoAresta;
	private Aresta aresta;
	private Grafo grafo;
	private List<Vertice> menorCaminho;
	private Dijkstra algDijkstra;
	
	
	public RouteServerCB() {
		super();
	}

	public boolean addVertice(Vertice vertice) {
		if (daoVertice.save(vertice).getId() != null) {
			return true;
		}
		return false;
	}

	public boolean addAresta(Vertice origem, Vertice destino, int peso) {
		aresta = new Aresta(origem, destino);
		aresta.setPeso(peso);
		origem.getVizinhos().add(destino);
		origem.getArestas().add(aresta);
		if (daoAresta.save(aresta).getId() != null) {
			return true;
		}
		return false;
	}

	public List<Aresta> listAresta() {
		return daoAresta.findAll();
	}

	public List<Vertice> listVertice() {
		return daoVertice.findAll();
	}

	public String menorCaminho(Vertice origem, Vertice destino) {
		this.criaGrafo();
		return this.calcMenorCaminho(origem, destino);
	}
	
	private String calcMenorCaminho(Vertice origem, Vertice destino) {
		algDijkstra = new Dijkstra();
		menorCaminho = new ArrayList<Vertice>();
		menorCaminho = algDijkstra.encontrarMenorCaminhoDijkstra(grafo, origem,
				destino);
		String resp = "";

		System.out.println("O menor caminho entre " + destino.getDescricao()
				+ " e " + origem.getDescricao() + " é: ");
		resp += "O menor caminho entre " + destino.getDescricao() + " e "
				+ origem.getDescricao() + " é: ";

		for (int i = 0; i < menorCaminho.size() - 1; i++) {
			System.out.print(menorCaminho.get(i).getDescricao() + " -> ");
			resp += menorCaminho.get(i).getDescricao() + " -> ";
		}

		System.out.println(destino.getDescricao());
		resp += destino.getDescricao();
		return resp;
	}

	private void criaGrafo() {
		grafo = new Grafo();
		grafo.setVertices(this.listVertice());
	}
	
	public Double calcCusto(Vertice origem, Vertice destino) {
		// TODO Auto-generated method stub
		return null;
	}

}
