package classe_abstrata.main;

import java.util.ArrayList;
import java.util.List;

import classe_abstrata.entities.Account;
import classe_abstrata.entities.BusinessAccount;
import classe_abstrata.entities.SavingsAccount;


public class Program {

	public static void main(String[] args) {


		List<Account> list = new ArrayList<>();
		list.add(new SavingsAccount(1001, "Mary", 1500.00, 0.01));
		list.add(new SavingsAccount(1002, "Bob", 15000.00, 0.01));
		list.add(new SavingsAccount(1003, "Clara", 18000.00, 0.01));
		list.add(new BusinessAccount(1004, "Kate", 2000.00, 500.00));
		list.add(new BusinessAccount(1005, "Harry", 700.00, 300.00));
		
		// Totalizar o saldo de todas as contas
		double sum = 0;
		for(Account acc : list) {
			sum += acc.getBalance();
		}
		System.out.println(sum);
		
		// Depositar 10.00 em todas as contas
		
		for(Account acc: list) {
			 acc.deposit(10.00); 
		}
		
		for(Account acc: list) {
			System.out.println("conta: " + acc.getNumber() + " - saldo : " + acc.getBalance()); 
		}
	}

}
