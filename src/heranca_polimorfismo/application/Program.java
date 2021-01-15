package heranca_polimorfismo.application;

import heranca_polimorfismo.entities.Account;
import heranca_polimorfismo.entities.BusinessAccount;
import heranca_polimorfismo.entities.SavingsAccount;

public class Program {

	public static void main(String[] args) {

		Account acc = new Account(1001, "Alex", 0.0);
		BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);

		// UPCASTING - objeto de uma subclasse e atribuir para uma variável da superclasse
		// Uma business account é uma conta, então pode ser atribuido para uma conta.
		Account acc1 = bacc;
		Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
		//SavingsAccount também é um conta, portanto é possível atribuir a uma conta.
		Account acc3 = new SavingsAccount(1004, "Ana", 0.0, 0.01);
		
		
		//DOWNCASTING - Converter um objeto da superclasse para a subclasse
		//BusinessAccount acc4 = acc2; // não é possível converter de Account para BusinessAccount
		BusinessAccount acc4 = (BusinessAccount)acc2;  // é necessário forçar a conversão fazendo casting manual, colocando em parenteses o tipo da subclasse, que é o BusinessAccount
		acc4.loan(100.0); // é possível chamar o método loan, pois este é método pertencente ao BusinessAccount. Se tentar realizar no acc2, que é tipo Account, não é possível.
		
		
		if(acc3 instanceof BusinessAccount) {
			BusinessAccount acc5 = (BusinessAccount)acc3;
			acc5.loan(200);
			System.out.println("Loan");
		}
		if(acc3 instanceof SavingsAccount) {
			SavingsAccount acc5 = (SavingsAccount)acc3;
			acc5.updateBalance();
			System.out.println("Update");
		}
		
		
		/*******************************************************/
		
		Account acc6 = new Account(1006, "Alex", 1000.0);
		acc6.withdraw(200.0);
		System.out.println(acc6.getBalance());
		
		Account acc7 = new SavingsAccount(1007, "Maria", 1000.0, 0.1);
		acc7.withdraw(200.0);
		System.out.println(acc7.getBalance());
		
		Account acc8 = new BusinessAccount(1008, "Bob", 1000.0, 500.0);
		acc8.withdraw(200.0);
		System.out.println(acc8.getBalance());
		
		
	}

}
