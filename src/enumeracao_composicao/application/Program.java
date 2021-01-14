package enumeracao_composicao.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import enumeracao_composicao.entities.Department;
import enumeracao_composicao.entities.HourContract;
import enumeracao_composicao.entities.Worker;
import enumeracao_composicao.entities.enums.WorkerLevel;
 

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department's name: ");
		String department = sc.nextLine();
		
		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();
		// Instanciando o Worker
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(department));

		System.out.print("How many contracts to this worker? ");
		int n = sc.nextInt();
		System.out.println();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Enter contract #" + i + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			Date dateValue = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			
			// Instanciando o Contrato
			HourContract contract = new HourContract(dateValue, valuePerHour, hours);
			// Associa o contrato ao trabalhador, através do método addContract
			worker.addContract(contract);
		}
		
		
		System.out.println();
		System.out.println("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		// Separa o mês da variável monthAndYear pelo método substring(posicaoInicial, posicaoFinalMaisUm) e transforma em inteiro
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		// Separa o ano da variável monthAndYear pelo método substring(aPartirDaPosicao) e transforma em inteiro
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		
		sc.close();
	}

}
