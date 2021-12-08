package fr.diginamic.d16.banque;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "assurancevie")
public class AssuranceVie extends Compte implements Serializable {

	@Column(name = "datefin")
	private LocalDate dateFin;

	@Column(name = "taux")
	private Double taux;

	public AssuranceVie() {
		super();
	}

	public AssuranceVie(String numero, Double solde, LocalDate dateFin, Double taux) {
		super(numero, solde);
		this.dateFin = dateFin;
		this.taux = taux;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}

}
