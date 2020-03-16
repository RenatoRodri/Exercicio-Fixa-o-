package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contratc;
import model.entities.Installment;

public class ContractService {

	private OnlinePaymentService paymentService;

	public ContractService(OnlinePaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	public void prossecContract(Contratc contratc, int months) {
		
		double basicQuota = contratc.getTotalvalue() / months;
		for(int i=1; i<=months; i++) {
			Date date = addMonths(contratc.getData(),i);
			double updateQuota = basicQuota + paymentService.interest(basicQuota, i);
			double fullQuota = updateQuota + paymentService.PaymentFee(updateQuota);
			contratc.AddInstallment(new Installment(date,fullQuota));
		}
	}
	
	private Date addMonths(Date date, int n) {
		Calendar call = Calendar.getInstance();
		call.setTime(date);
		call.add(Calendar.MONTH, n);
		return call.getTime();
		
	}
}
