package interface_exercicio_fixacao.model.entities;

import java.util.Date;

public class Installment {

	private Date dueDate;
	private double amount;
	
	public Installment() {}

	public Installment(Date dueDate, double amount) {
		super();
		this.dueDate = dueDate;
		this.amount = amount;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
