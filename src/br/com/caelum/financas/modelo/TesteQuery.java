package br.com.caelum.financas.modelo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TesteQuery {

	public static void main(String[] args) {
		System.out.println("criando emf");

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("notas");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();

		/*
		TypedQuery<Movimentacao> query = manager
				.createQuery(
						"select m from Movimentacao m where m.conta.titular = :titular",
						Movimentacao.class).setParameter("titular",
						"foo");
		*/
		
		TypedQuery<Conta> query = manager.createQuery("select c from Conta c", Conta.class);
		query.setHint("javax.persistence.fetchgraph", manager.getEntityGraph("ContaComMovimentacao"));
		
		List<Conta> contas = query.getResultList();

		manager.close();
		factory.close();
		
		System.out.println("EM fechado");
		
		for (Conta conta : contas) {
			for(Movimentacao m : conta.getMovimentacoes()) { 
				System.out.println(m.getValor());
			}
			
		}
		
	}

}
