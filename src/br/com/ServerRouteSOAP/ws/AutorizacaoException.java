package br.com.ServerRouteSOAP.ws;

public class AutorizacaoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AutorizacaoException(String arq){
		super(arq);
	}
}
