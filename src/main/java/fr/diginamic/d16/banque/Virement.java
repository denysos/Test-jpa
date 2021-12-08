package fr.diginamic.d16.banque;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("V")
public class Virement extends Operation  implements Serializable {

	@Column(name = "beneficiaire", length = 50)
	private String beneficiaire;

	public Virement() {
		super();
	}

	public Virement(LocalDate date, Double montant, String motif, Compte compte, String beneficiaire) {
		super(date, montant, motif, compte);
		this.beneficiaire = beneficiaire;
	}

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

}
