package ms.test.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {
	private int id;

	private String nome;

	private String cognome;

	private int eta;

	private String telefono;

	private String email;

	public Person() {
	}

	public Person(Integer Id, String Nome, String Cognome, Integer Eta, String Telefono, String Email) {
		this.id = Id;
		this.nome = Nome;
		this.cognome = Cognome;
		this.eta = Eta;
		this.telefono = Telefono;
		this.email = Email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
