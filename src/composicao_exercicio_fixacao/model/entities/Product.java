package composicao_exercicio_fixacao.model.entities;

public class Product {

	// Fields
	private String name;
	private double price;
	
	// Constructors
	public Product() {}

	public Product(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	// Getters and Setters
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
}
