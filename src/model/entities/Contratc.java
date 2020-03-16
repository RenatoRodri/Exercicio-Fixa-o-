package model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contratc {
	
	private Integer number;
	private Date data;
	private Double totalvalue;
	private List<Installment> installment = new ArrayList<>();
	
	public Contratc() {
	}

	public Contratc(Integer number, Date data, Double totalvalue) {
		this.number = number;
		this.data = data;
		this.totalvalue = totalvalue;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getTotalvalue() {
		return totalvalue;
	}

	public void setTotalvalue(Double totalvalue) {
		this.totalvalue = totalvalue;
	}

	public List<Installment> getInstallment() {
		return installment;
	}

	public void AddInstallment(Installment installments) {
		installment.add(installments);
	}
	
	public void RemoveInstallment(Installment installments) {
		installment.remove(installments);
	}
}
