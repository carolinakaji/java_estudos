package interface_exercicio_fixacao.application;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import interface_exercicio_fixacao.model.entities.Contract;
import interface_exercicio_fixacao.model.entities.Installment;
import interface_exercicio_fixacao.model.services.ContractService;
import interface_exercicio_fixacao.model.services.PaypalServices;

public class Program {

	public static void main(String[] args) throws ParseException{
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter contract data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.next());
		System.out.print("Contract value: ");
		double totalValue = sc.nextDouble();
		
		// Instanciar contract com as informações do contrato
		Contract contract = new Contract(number, date, totalValue);
		// Instanciar o ContractService, com o serviço do Paypal, através de injeção de dependência do PaypalService
		ContractService cs = new ContractService(new PaypalServices());
		
		System.out.print("Enter number of installments: ");
		int n = sc.nextInt();
		
		// Processar o contrato como número de parcelas que são os meses
		cs.processContract(contract, n);
		
		System.out.println("Instalments:");
		// Itea pela lista de Installment no contrato
		for(Installment it : contract.getInstallments()) {
			System.out.println(it);
		}
		
		sc.close();
		

	}

}
