package fr.diginamic.d16.jpabiblio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestBibliothque {

	public static void main(String[] args) {
		EntityManagerFactory mgf = Persistence.createEntityManagerFactory("jpa-biblio");
		EntityManager em = mgf.createEntityManager();
		System.out.println(mgf);
		System.out.println(em);
		
//		List<Livre> listeLivre = new ArrayList<>();
		Emprunt emprunt = new Emprunt();
		
		
		emprunt = em.find(Emprunt.class, 1);
		System.out.println("emprunt : " + emprunt);
		for (Livre livre : emprunt.getLivres()) {
			System.out.println(livre.toString());
		}
		
		
		
//		Query rqLivres = em.createQuery("SELECT l FROM Livre l WHERE l.id = (SELECT idLivre FROM Compo)");
		
		em.close();
		mgf.close();
		
	}

}
