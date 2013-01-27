package com.autohouse.service;

import java.util.List;

import com.autohouse.domain.Customer_VouchakIM;

public interface CustomerService_VouchakIM {
	public void                     saveOrUpdateCustomer(Customer_VouchakIM customer);
	public List<Customer_VouchakIM> getCustomerList();
	public List<Customer_VouchakIM> getCustomerByPassportNumber(String request);
	public Customer_VouchakIM       getCustomerById(Integer id);
	public void                     deleteCustomer(Customer_VouchakIM customer);
	public boolean                  passportIsInDatabase(String passportNo);
}