package fr.diginamic.d16.jpabiblio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COMPO")
public class Compo implements Serializable {

	@Id
	@ManyToOne
	@JoinColumn(name = "id_liv")
	private Livre livre;

	@Id
	@ManyToOne
	@JoinColumn(name = "id_emp")
	private Emprunt emprunt;

	public Compo() {
		super();
	}

	public Compo(Livre livre, Emprunt emprunt) {
		super();
		this.livre = livre;
		this.emprunt = emprunt;
	}

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	public Emprunt getEmprunt() {
		return emprunt;
	}

	public void setEmprunt(Emprunt emprunt) {
		this.emprunt = emprunt;
	}

	@Override
	public String toString() {
		return "Compo [livre=" + livre + ", emprunt=" + emprunt + "]";
	}

}
