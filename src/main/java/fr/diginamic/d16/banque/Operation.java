package fr.diginamic.d16.banque;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "operation")
@DiscriminatorColumn(name="type")
public abstract class Operation  implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "date")
	private LocalDate date;

	@Column(name = "montant")
	private Double montant;

	@Column(name = "motif")
	private String motif;

	@ManyToOne
	@JoinColumn(name = "id_cpt")
	private Compte compte;

	public Operation() {
		super();
	}

	public Operation(LocalDate date, Double montant, String motif, Compte compte) {
		super();
		this.date = date;
		this.montant = montant;
		this.motif = motif;
		this.compte = compte;
	}

	public Integer getId() {
		return id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

}
