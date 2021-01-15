package exercicio_fixacao_polimorfismo.entities;

public class ImportedProduct extends Product{

	private double customsFee;

	public ImportedProduct() {}
	
	public ImportedProduct(String name, double price, double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	public double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(double customsFee) {
		this.customsFee = customsFee;
	}
	
	@Override
	public String priceTag() {
		double price = super.getPrice() + customsFee;
		return (super.getName() + " $ " + String.format("%.2f", price) + " (Customs fee: $ " + String.format("%.2f", customsFee) + ")");
	}
	
	
	
}
