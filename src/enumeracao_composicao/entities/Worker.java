package enumeracao_composicao.entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import enumeracao_composicao.entities.enums.WorkerLevel;

public class Worker {

	// Fields
	private String name;
	private WorkerLevel level;
	private double baseSalary;
	private Department department;
	private List<HourContract> contracts = new ArrayList<>();
	
	
	// Constructors
	public Worker() {}
	

	// Não inclui no construtor LISTAS
	public Worker(String name, WorkerLevel level, double baseSalary, Department department) {
		super();
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}


	// Getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	
		
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	

	public List<HourContract> getContracts() {
		return contracts;
	}

/* NÃO PODE PERMITIR QUE A LISTA SEJA ALTERADA(no caso, seria uma substituição de lista). SOMENTE PELOS MÉTODOS addContract() e removeContract()
	public void setContracts(List<HourContract> contracts) {
		this.contracts = contracts;
	}
*/

	// Methods
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	public double income(int year, int month) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance(); 
		for(HourContract c : contracts) {
			cal.setTime(c.getDate()); // Data do contrato "c" definiu como a data do calendário
			int c_year = cal.get(Calendar.YEAR); // extrai do calendario o ano
			int c_month = 1 + cal.get(Calendar.MONTH); // extrai do calendario o mês. soma 1 pois o mês do calendar começa com 0
			
			if(c_month == month && c_year == year) {
				sum += c.totalValue();
			}
		}
		return sum;
	}
	
}
