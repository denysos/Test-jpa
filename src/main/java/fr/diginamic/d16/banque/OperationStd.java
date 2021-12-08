package fr.diginamic.d16.banque;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("S")
public class OperationStd extends Operation  implements Serializable{

	public OperationStd() {
		super();
	}

	public OperationStd(LocalDate date, Double montant, String motif, Compte compte) {
		super(date, montant, motif, compte);
	}

}
