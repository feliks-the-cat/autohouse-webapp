package com.autohouse.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.autohouse.dao.GenericDAO_VouchakIM;
import com.autohouse.domain.Customer_VouchakIM;

@Transactional
public class CustomerServiceImpl_VouchakIM implements CustomerService_VouchakIM {
	
	public GenericDAO_VouchakIM<Customer_VouchakIM> customerDAO;
	
	public void setCustomerDAO(GenericDAO_VouchakIM<Customer_VouchakIM> customerDAO) {
		this.customerDAO = customerDAO;
	}
	
	@Override
	@Transactional
	public void saveOrUpdateCustomer(Customer_VouchakIM customer) {
		customerDAO.saveOrUpdate(customer);
	}
  
	@Override
	@Transactional
	public List<Customer_VouchakIM> getCustomerList() {
		return customerDAO.getList();
	}

	@Override
	@Transactional
	public void deleteCustomer(Customer_VouchakIM customer) {
		customerDAO.delete(customer.getCustomerId());
	}  

	@Override
	@Transactional
	public List<Customer_VouchakIM> getCustomerByPassportNumber(String request) {
		return customerDAO.getByObject("customerPassportNumber", request);
	} 
  
	@Override
	@Transactional
	public Customer_VouchakIM getCustomerById(Integer id) {
		return customerDAO.getById(id);
	}

	@Override
	@Transactional
	public boolean passportIsInDatabase(String passportNo) {
		return customerDAO.findByParam("customerPassportNumber", passportNo).size() > 0;
	}
}