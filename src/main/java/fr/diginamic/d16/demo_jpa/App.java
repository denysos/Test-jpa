package fr.diginamic.d16.demo_jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		EntityManagerFactory mgf = Persistence.createEntityManagerFactory("jpa-test-connect");
		EntityManager em = mgf.createEntityManager();
		System.out.println(mgf);
		System.out.println(em);
		
		
		

		em.close();
		mgf.close();
	}
}
