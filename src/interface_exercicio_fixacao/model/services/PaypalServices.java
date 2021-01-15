package interface_exercicio_fixacao.model.services;

public class PaypalServices implements OnlinePaymentService{

	// Setou como constante, pois para este exemplo as taxas são fixas
	private static final double PAYMENT_FEE = 0.02;
	private static final double MONTHLY_INTEREST = 0.01; 
	
	@Override
	public double paymentFee(double amout) {
		return amout * PAYMENT_FEE;
	}

	@Override
	public double interest(double amount, int months) {
		return amount * MONTHLY_INTEREST * months;
	}

}
