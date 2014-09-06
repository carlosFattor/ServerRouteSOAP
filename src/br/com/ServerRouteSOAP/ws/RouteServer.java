package br.com.ServerRouteSOAP.ws;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import br.com.ServerRouteSOAP.model.Aresta;
import br.com.ServerRouteSOAP.model.Vertice;

@WebService
@SOAPBinding(style = Style.RPC)
public interface RouteServer {
	boolean adicionarVertice(
			@WebParam(name = "descricao") String descricao, 
			@WebParam(name = "token", header = true) String token);
	
	boolean adicionarAresta(
			@WebParam(name = "noOrigem") Vertice origem,
			@WebParam(name = "noDestino") Vertice destino,
			@WebParam(name = "peso") int peso,
			@WebParam(name = "token", header = true) String token);
	
	List<Aresta> getAresta(
			@WebParam(name = "token", header = true) String token);
	
	List<Vertice> getVertice(
			@WebParam(name = "token", header = true) String token);
	
	String calcularMenorRota(
			@WebParam(name = "noOrigem") Vertice origem,
			@WebParam(name = "noDestino") Vertice destino,
			@WebParam(name = "token", header = true) String token);
	
	Double calcularCusto(
			@WebParam(name = "noOrigem") Vertice origem,
			@WebParam(name = "noDestino") Vertice destino,
			@WebParam(name = "token", header = true) String token);

}
