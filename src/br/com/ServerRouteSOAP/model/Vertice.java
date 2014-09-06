package br.com.ServerRouteSOAP.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Vertice implements AbstractEntity, Comparable<Vertice>, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;
	@Column
	private String descricao;
	@Column
	private int distancia;
	@Transient
	private List<Aresta> arestas = new ArrayList<>();
	@Transient
	private List<Vertice> vizinhos = new ArrayList<>();
	@Transient
	private boolean visitado = false;
	@Transient
	private Vertice pai;

	public Vertice() {
		super();
	}

	public BigInteger getId() {
		return id;
	}



	public void setId(BigInteger id) {
		this.id = id;
	}



	public boolean isVisitado() {
		return visitado;
	}



	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}



	public void setDescricao(String nome) {

		this.descricao = nome;
	}

	public String getDescricao() {

		return descricao;

	}

	public void visitar() {

		this.visitado = true;
	}

	public boolean verificarVisita() {

		return visitado;
	}

	public void setDistancia(int distancia) {

		this.distancia = distancia;
	}

	public int getDistancia() {

		return this.distancia;
	}

	public void setPai(Vertice pai) {

		this.pai = pai;
	}

	public Vertice getPai() {

		return this.pai;
	}

	public void setVizinhos(List<Vertice> vizinhos) {

		this.vizinhos.addAll(vizinhos);

	}

	public List<Vertice> getVizinhos() {

		return this.vizinhos;
	}

	public void setArestas(List<Aresta> arestas) {

		this.arestas.addAll(arestas);

	}

	public List<Aresta> getArestas() {

		return arestas;
	}

	@Override
	public int compareTo(Vertice vertice) {
		if (this.getDistancia() < vertice.getDistancia())
			return -1;
		else if (this.getDistancia() == vertice.getDistancia())
			return 0;

		return 1;

	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vertice) {
			Vertice vRef = (Vertice) obj;
			if (this.getDescricao().equals(vRef.getDescricao()))
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		String s = " ";
		s += this.getDescricao();
		return s;
	}

}
