package fr.diginamic.d16.banque;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestBanqueJpa {

	public static void main(String[] args) {
		EntityManagerFactory mgf = Persistence.createEntityManagerFactory("jpa-banque");
		EntityManager em = mgf.createEntityManager();
		System.out.println(mgf);
		System.out.println(em);

		// population de la base :
		em.getTransaction().begin();
		// Banque :
		Banque banque = new Banque("BqPOP");
		em.persist(banque);
		System.out.println("id bq : " + banque.getId());
		
//		Compte compte1 = new Compte("00001285794",	5000.00);
		LocalDate dateNaissance1 = LocalDate.of(1980, 06, 30);
		Adresse adresse1 = new Adresse(1, "Sesame", 30000, "Perpignan");
		Client client1 = new Client("Bernardo", "Cyril", dateNaissance1 , banque, adresse1);
		em.persist(client1);
		
		Compte compte1 = new Compte("00000548692", 250.53);
		Compte compte2 = new Compte("00542987321", 5046.00);
		em.persist(compte1);
		em.persist(compte2);
		client1.addCompte(compte1);
		client1.addCompte(compte2);
		
		Operation ope1 = new Operation(LocalDate.of(2021,12,5), 100.00, "achat livre JPA", compte1);
		Operation ope2 = new Operation(LocalDate.of(2021,12,6), 15.50, "Retaurant les bonnes bases", compte1);
		Operation ope3 = new Operation(LocalDate.of(2021,12,7), 25.30, "Boucherie des garrigues", compte2);
		em.persist(ope1);
		em.persist(ope2);
		em.persist(ope3);
		
		em.merge(client1);
		
		

		
		em.getTransaction().commit();
		
		em.close();
		mgf.close();
	}

}
