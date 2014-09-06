package br.com.ServerRouteSOAP.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Aresta implements AbstractEntity, Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;
	@Column
	private int peso;
	
	@ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "origem")
    private Vertice origem;
	
	@ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "destino")
    private Vertice destino;
    
    public Aresta() {
		super();
	}

	public Aresta(Vertice v1, Vertice v2){
            this.peso = 1;
            this.origem = v1;
            this.destino = v2;
    }
    
    public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public void setPeso(int novoPeso){
            
            this.peso = novoPeso;
    }
    
    public int getPeso(){
            
            return peso;
    }
    

    public void setDestino(Vertice destino) {
            this.destino = destino;
    }

    public Vertice getDestino() {
            return destino;
    }

    public void setOrigem(Vertice origem) {
            this.origem = origem;
    }

    public Vertice getOrigem() {
            return origem;
    }
}
