package composicao_exercicio_fixacao.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	// Fields
	private String name;
	private String email;
	private Date birthDate;
	
	
	// Constructors
	public Client() {
		
	}

	public Client(String name, String email, Date birthDate) {
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBrithDate() {
		return birthDate;
	}

	public void setBrithDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	@Override
	public String toString() {
		return "Client: " + name + " (" + sdf.format(birthDate) + ") - " + email;
	}
	
}