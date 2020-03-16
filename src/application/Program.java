package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contratc;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter contract data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		Date data = sdf.parse(sc.next());
		System.out.print("Contract value: ");
		double totalvalue = sc.nextDouble();
		
		Contratc contratc = new Contratc(number, data, totalvalue);
		
		System.out.print("Enter number of installments: ");
		int n = sc.nextInt();
		ContractService contractservice = new ContractService(new PaypalService());
		
		contractservice.prossecContract(contratc, n);
		
		System.out.println("Installments:");
		for(Installment x: contratc.getInstallment()) {
			System.out.println(x);
		}
			
		
		
		
		
		
		
		
		
		sc.close();
	}

}
