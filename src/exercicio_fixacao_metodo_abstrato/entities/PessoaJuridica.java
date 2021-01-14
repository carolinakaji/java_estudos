package exercicio_fixacao_metodo_abstrato.entities;

public class PessoaJuridica extends Pessoa{

	private int funcionarios;

	public PessoaJuridica() {
		super();
	}
	

	public PessoaJuridica(String nome, double rendaAnual, int funcionarios) {
		super(nome, rendaAnual);
		this.funcionarios = funcionarios;
	}

	

	public int getFuncionarios() {
		return funcionarios;
	}


	public void setFuncionarios(int funcionarios) {
		this.funcionarios = funcionarios;
	}


	@Override
	public double imposto() {
		if(funcionarios > 10) {
			return super.getRendaAnual() * 14/100;
		} else {
			return super.getRendaAnual() * 16/100;
		}
	}
	
	
}
