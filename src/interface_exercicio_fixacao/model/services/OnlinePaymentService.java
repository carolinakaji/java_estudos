package interface_exercicio_fixacao.model.services;

public interface OnlinePaymentService {

	public double paymentFee(double amout);
	public double interest(double amount, int months);
	
}
