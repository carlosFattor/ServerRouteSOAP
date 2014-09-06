package br.com.ServerRouteSOAP.ws;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebService;

import br.com.ServerRouteSOAP.model.Aresta;
import br.com.ServerRouteSOAP.model.Vertice;

@Stateless
@WebService(targetNamespace = "http://serverroutesoap.com.br/routeserverimpl/v1")
public class RouteServerImpl implements RouteServer{

	private Vertice vertice;
	private RouteServerCB routeServerCB;

	public RouteServerImpl() {
		vertice = new Vertice();
		}

	@Override
	public boolean adicionarVertice(String descricao, String token) {
		if (token == null || !token.equals("TOKEN123")) {
			throw new AutorizacaoException("Não Autorizado");
		}
		
		vertice.setDescricao(descricao);
		return routeServerCB.addVertice(vertice);
	}

	@Override
	public boolean adicionarAresta(Vertice origem, Vertice destino, int peso, String token) {
		if (token == null || !token.equals("TOKEN123")) {
			throw new AutorizacaoException("Não Autorizado");
		}
		return routeServerCB.addAresta(origem, destino, peso);
	}

	@Override
	public List<Aresta> getAresta(String token) {
		if (token == null || !token.equals("TOKEN123")) {
			throw new AutorizacaoException("Não Autorizado");
		}
		return routeServerCB.listAresta();
	}

	@Override
	public List<Vertice> getVertice(String token) {
		if (token == null || !token.equals("TOKEN123")) {
			throw new AutorizacaoException("Não Autorizado");
		}
		return routeServerCB.listVertice();
	}

	@Override
	public String calcularMenorRota(Vertice origem, Vertice destino,
			String token) {
		if (token == null || !token.equals("TOKEN123")) {
			throw new AutorizacaoException("Não Autorizado");
		}

		return routeServerCB.menorCaminho(origem, destino);
		
	}

	@Override
	public Double calcularCusto(Vertice origem, Vertice destino, String token) {
		if (token == null || !token.equals("TOKEN123")) {
			throw new AutorizacaoException("Não Autorizado");
		}
		return routeServerCB.calcCusto(origem, destino);
	}
}
