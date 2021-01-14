package exercicio_fixacao_metodo_abstrato.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import exercicio_fixacao_metodo_abstrato.entities.Pessoa;
import exercicio_fixacao_metodo_abstrato.entities.PessoaFisica;
import exercicio_fixacao_metodo_abstrato.entities.PessoaJuridica;

public class Main {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Pessoa> list = new ArrayList<>();

		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			
			System.out.print("Individual or company (i/c)? ");
			char ch = sc.next().charAt(0);
			
			sc.nextLine();
			
			System.out.print("Name: ");
			String name = sc.nextLine();
			
			System.out.print("Annual income: " );
			double rendaAnual = sc.nextDouble();
			
			if(ch == 'i') {
				System.out.print("Health expenditures: ");
				double gastosSaude = sc.nextDouble();
				list.add(new PessoaFisica(name, rendaAnual, gastosSaude));
			} else {
				System.out.print("Number of employees: ");
				int funcionarios = sc.nextInt();
				list.add(new PessoaJuridica(name, rendaAnual, funcionarios));
			}
			
		}
		
		System.out.println();
		System.out.println("TAXES PAID: ");
		double total = 0;
		for(Pessoa pessoa : list) {
			System.out.println(pessoa.getNome() + ": $ " + pessoa.imposto());
			total += pessoa.imposto();
		}
		
		System.out.println("Total taxes: $" + total);
		
		
		sc.close();
	}

}
