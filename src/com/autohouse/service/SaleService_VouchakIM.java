package com.autohouse.service;

import java.util.List;

import com.autohouse.domain.Customer_VouchakIM;
import com.autohouse.domain.Sale_VouchakIM;

public interface SaleService_VouchakIM {
	public void                 saveOrUpdateSale(Sale_VouchakIM sale);
	public void                 deleteSale(Sale_VouchakIM sale);
	public List<Sale_VouchakIM> getSaleList();
	public List<Sale_VouchakIM> getCustomerSalesByCustomerId(Customer_VouchakIM customer);
	public Sale_VouchakIM       getSaleById(Integer id);
	public void                 deleteSale(Integer id);
	public Integer              getSummAllSales();
}