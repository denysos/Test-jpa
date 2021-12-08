package fr.diginamic.d16.jpabiblio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AppBiblio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory mgf = Persistence.createEntityManagerFactory("jpa-biblio");
		EntityManager em = mgf.createEntityManager();
		System.out.println(mgf);
		System.out.println(em);

		Livre livre = em.find(Livre.class, 1);

		System.out.println(livre.toString());

		// premiere transaction MAJ
		em.getTransaction().begin();

		// inserer un nouveau livre
		Livre livreInsert = new Livre("Les lettres de mon moulin", "A. Daudet");
		em.persist(livreInsert);
		System.out.println(livreInsert.toString());
		System.out.println("livre cree");

		// modifier le titre du livre id=5
		Livre livreModif;
		livreModif = em.find(Livre.class, 5);
		if (livreModif != null) {
			livreModif.setTitre("Du plaisir dans la cuisine");
		}

		em.getTransaction().commit();

		// Query Germinal
		Query rqT = em.createQuery("SELECT l from Livre l WHERE l.titre = :titre");
		rqT.setParameter("titre", "Germinal");
		Livre livreParTitre;// = new Livre();
		livreParTitre = (Livre) rqT.getSingleResult();

		System.out.println("voici le livre Germinal : ");
		System.out.println(livreParTitre.toString());

		// Query A. Daudet
		Query rqA = em.createQuery("SELECT l from Livre l WHERE l.auteur = :auteur");
		rqA.setParameter("auteur", "A. Daudet");
		Livre livreParAuteur;// = new Livre();
		livreParAuteur = (Livre) rqA.getSingleResult();

		System.out.println("voici le livre de A. Daudet : ");
		System.out.println(livreParAuteur.toString());

		// transaction delete
		em.getTransaction().begin();

		if (livreParAuteur != null) {
			System.out.println("livre supprimé : " + livreParAuteur);
			em.remove(livreParAuteur);

		}
		em.getTransaction().commit();
		
		
		
		//liste de tous les livres de la base :
		
		Query rqListe = em.createQuery("SELECT l FROM Livre l");
		List<Livre> listeLivre = new ArrayList<Livre>();
		listeLivre = rqListe.getResultList();
		
		for (Livre livre2 : listeLivre) {
			System.out.println(livre2.toString());
		}
		
		em.close();
		mgf.close();
	}

}
