package fr.diginamic.d16.banque;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "compte")
public abstract class Compte implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "numero", length = 11)
	private String numero;

	@Column(name = "solde")
	private Double solde;

	@ManyToMany(mappedBy = "comptes")
	private Set<Client> client;

	@OneToMany(mappedBy = "compte")
	private Set<Operation> operations;

	public Compte() {
		super();
	}

	public Compte(String numero, Double solde) {
		super();
		this.numero = numero;
		this.solde = solde;
		this.client = new HashSet<Client>();
		this.operations = new HashSet<Operation>();
	}

	public Integer getId() {
		return id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	public Set<Client> getClient() {
		return client;
	}

	public void setClient(Set<Client> client) {
		this.client = client;
	}

	public Set<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}

}
