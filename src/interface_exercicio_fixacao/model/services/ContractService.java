package interface_exercicio_fixacao.model.services;

import java.util.Calendar;
import java.util.Date;

import interface_exercicio_fixacao.model.entities.Contract;
import interface_exercicio_fixacao.model.entities.Installment;

public class ContractService {
	

	// Utilizando a injeção de dependência utilizando construtor
	private OnlinePaymentService onlinePaymentService;
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public void processContract(Contract contract, int months) {
		// Quantidade base das parcelas com base no valor total que foi informado
		double basicQuota = contract.getTotalValue() / months;
		// Itera pelos meses para calcular o valor da parcela, com base no basicQuota e no serviço online de pagamento, com suas devidas taxas.
		for(int i = 1; i<=months; i++) {
			 double updatedQuota = basicQuota + onlinePaymentService.interest(basicQuota, i);
			 double fullQuota = updatedQuota + onlinePaymentService.paymentFee(updatedQuota);
			 
			 Date dueDate = addMonths(contract.getDate(), i);
			 // Adiciona uma nova Installment ao contrato
			 contract.getInstallments().add(new Installment(dueDate, fullQuota));
		}
	}
	
	// Função auxiliar para acrescentar meses a uma data
	private Date addMonths(Date date, int nMonths) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, nMonths);
		return calendar.getTime();
	}
}
