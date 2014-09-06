package br.com.ServerRouteSOAP.model;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * Estipula um contrato base para as entidades persistentes da aplicação.
 * 
 * <p>Esse contrato é utilizado pelo componente base de persistência: <code>GenericDAO</code>.</p>
 * 
 */
public interface AbstractEntity extends Serializable {

	/**
	 * @return A referência para a chave primária (Primary Key) de cada objeto persistido.
	 * 		   Caso o objeto ainda não tenha sido persistido, deve retornar <code>null</code>.
	 */
	public BigInteger getId();
	
}