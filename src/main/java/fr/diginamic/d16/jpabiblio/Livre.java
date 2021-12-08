package fr.diginamic.d16.jpabiblio;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LIVRE")
public class Livre implements Serializable {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "TITRE")
	private String titre;

	@Column(name = "AUTEUR", length = 50)
	private String auteur;
	
	
	@ManyToMany
	@JoinTable(name="COMPO", joinColumns=@JoinColumn(name="id_liv", referencedColumnName="ID"),
	inverseJoinColumns=@JoinColumn(name="id_emp", referencedColumnName="id"))
	private Set<Emprunt> emprunts ;

	// le constructeur par défaut est obligatoire pour utiliser JPA !!!
	public Livre() {
		super();
		this.emprunts = new HashSet<>();
	}

	public Livre(String titre, String auteur) {
		super();
		this.titre = titre;
		this.auteur = auteur;
		this.emprunts = new HashSet<>(); 
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + ", auteur=" + auteur + "]";
	}

}
