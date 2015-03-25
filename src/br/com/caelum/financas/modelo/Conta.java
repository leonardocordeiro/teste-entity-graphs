package br.com.caelum.financas.modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.OneToMany;

@NamedEntityGraphs({
	@NamedEntityGraph(
			name="ContaComMovimentacao",
			attributeNodes = {
					@NamedAttributeNode("movimentacoes"),					
			}
	)
})

@Entity
public class Conta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titular;
	private String agencia;
	private String numero;
	private String banco;
	@ManyToOne
	private Gerente gerente;
	
	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}
	
	public Gerente getGerente() {
		return gerente;
	}

	@OneToMany(mappedBy="conta")
	private Set<Movimentacao> movimentacoes;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public Set<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public void setMovimentacoes(Set<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

}
