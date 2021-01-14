package enumeracao_composicao.entities;

import java.util.Date;

public class HourContract {

	// Fields
	private Date date;
	private double valuePerHour;
	private int hours;

	
	// Constructors
	public HourContract() {}
	
	public HourContract(Date date, double valuePerHour, int hours) {
		this.date = date;
		this.valuePerHour = valuePerHour;
		this.hours = hours;
	}

	// Getters and Setters
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getValuePerHour() {
		return valuePerHour;
	}

	public void setValuePerHour(double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	
	// Method
	public double totalValue() {
		return valuePerHour * hours;
	}
	
}
