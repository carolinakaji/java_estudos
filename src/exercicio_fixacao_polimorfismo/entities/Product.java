package exercicio_fixacao_polimorfismo.entities;

public class Product {

	// Atributos
	private String name;
	private double price;
	
	// Construtores
	public Product() {
	}

	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}

	// Getters e setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	// Métodos
	public String priceTag() {
		
		return (name + " $ " + String.format("%.2f", price));
	}
	
}
