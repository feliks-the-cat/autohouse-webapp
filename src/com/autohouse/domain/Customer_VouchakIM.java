package com.autohouse.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="customers")
public class Customer_VouchakIM implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CUSTOMER_ID")
	private Integer customerId;

	@Column(name="CUSTOMER_ADDRESS")
	private String customerAddress;

	@Column(name="CUSTOMER_FIO")
	private String customerFio;

	@Column(name="CUSTOMER_PASSPORT_ISSUE_DATE")
	private String customerPassportIssueDate;

	@Column(name="CUSTOMER_PASSPORT_ISSUE_PLACE")
	private String customerPassportIssuePlace;

	@Column(name="CUSTOMER_PASSPORT_NUMBER")
	private String customerPassportNumber;

	@Column(name="CUSTOMER_PHONE_NUMBER")
	private String customerPhoneNumber;
	
    public Customer_VouchakIM() {
    }

	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerAddress() {
		return this.customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerFio() {
		return this.customerFio;
	}

	public void setCustomerFio(String customerFio) {
		this.customerFio = customerFio;
	}

	public String getCustomerPassportIssueDate(){
		return this.customerPassportIssueDate;
	}

	public void setCustomerPassportIssueDate(String customerPassportIssueDate) {
		this.customerPassportIssueDate = customerPassportIssueDate;
	}

	public String getCustomerPassportIssuePlace() {
		return this.customerPassportIssuePlace;
	}

	public void setCustomerPassportIssuePlace(String customerPassportIssuePlace) {
		this.customerPassportIssuePlace = customerPassportIssuePlace;
	}

	public String getCustomerPassportNumber() {
		return this.customerPassportNumber;
	}

	public void setCustomerPassportNumber(String customerPassportNumber) {
		this.customerPassportNumber = customerPassportNumber;
	}

	public String getCustomerPhoneNumber() {
		return this.customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}
}