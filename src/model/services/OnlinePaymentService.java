package model.services;

public interface OnlinePaymentService {

			double PaymentFee(double amount);
			
			double interest(double amount, int moths);
}
