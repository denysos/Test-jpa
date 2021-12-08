package fr.diginamic.d16.banque;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "livretA")
public class LivretA extends Compte implements Serializable {

	@Column(name = "taux")
	private Double taux;

	public LivretA() {
		super();
	}

	public LivretA(String numero, Double solde, Double taux) {
		super(numero, solde);
		this.taux = taux;
	}

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}

}
