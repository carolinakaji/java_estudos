package exercicio_fixacao_metodo_abstrato.entities;

public class PessoaFisica extends Pessoa {

	private double gastosSaude;
	
	
	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, double rendaAnual, double gastosSaude) {
		super(nome, rendaAnual);
		this.gastosSaude = gastosSaude;
	}

	public double getGastosSaude() {
		return gastosSaude;
	}

	public void setGastosSaude(double gastosSaude) {
		this.gastosSaude = gastosSaude;
	}

	@Override
	public double imposto() {
		if(super.getRendaAnual() < 20000.00) {
			if(gastosSaude > 0) {
				return (super.getRendaAnual() * 15/100) - (gastosSaude * 50/100);
			}
			
			return super.getRendaAnual() * 15/100;
		} else {
			if (gastosSaude> 0) {
				return (super.getRendaAnual() * 25/100) - (gastosSaude * 50/100);
			}
			
			return super.getRendaAnual() * 25/100;
		} 

	}

}
