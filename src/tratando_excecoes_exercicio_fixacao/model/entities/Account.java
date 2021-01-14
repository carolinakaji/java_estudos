package tratando_excecoes_exercicio_fixacao.model.entities;

import tratando_excecoes_exercicio_fixacao.model.exceptions.DomainException;

public class Account {

	// Atributos
	private int number;
	private String holder;
	private double balance;
	private double withdrawLimit;
	
	// Construtores
	public Account() {}
	
	public Account(int number, String holder, double balance, double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	// Getter e Setter
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	// Métodos
	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdraw(double amount) {
		if(amount > withdrawLimit) {
			throw new DomainException("The amount exceeds withdaw limit");
		}
		if(amount > balance) {
			throw new DomainException("Not enough balance");
		}
		balance -= amount;
		
	}
	
}
