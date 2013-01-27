package com.autohouse.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.autohouse.dao.GenericDAO_VouchakIM;
import com.autohouse.domain.Car_VouchakIM;
import com.autohouse.domain.Customer_VouchakIM;
import com.autohouse.domain.Sale_VouchakIM;

@Transactional
public class SaleServiceImpl_VouchakIM implements SaleService_VouchakIM {

	public GenericDAO_VouchakIM<Sale_VouchakIM> saleDAO;
	
	public void setSaleDAO(GenericDAO_VouchakIM<Sale_VouchakIM> saleDAO) {
		this.saleDAO = saleDAO;
	}
	
	public GenericDAO_VouchakIM<Car_VouchakIM> carDAO;
	
	public void setCarDAO(GenericDAO_VouchakIM<Car_VouchakIM> carDAO) {
		this.carDAO = carDAO;
	}
	
	@Override
	@Transactional
	public void saveOrUpdateSale(Sale_VouchakIM sale) {
		Car_VouchakIM car = sale.getCar();
		car.setCarIsSold("Y");
		carDAO.saveOrUpdate(car);
		saleDAO.saveOrUpdate(sale);
	}

	@Override
	@Transactional
	public List<Sale_VouchakIM> getSaleList() {
		return saleDAO.getList();
	}

	@Override
	@Transactional
	public void deleteSale(Sale_VouchakIM sale) {
		saleDAO.delete(sale.getSaleId());
	}

	@Override
	@Transactional
	public List<Sale_VouchakIM> getCustomerSalesByCustomerId(Customer_VouchakIM customer) {
		return saleDAO.getByObject("customer", customer);
	}

	@Override
	@Transactional
	public Sale_VouchakIM getSaleById(Integer id) {
		return saleDAO.getById(id);
	}

	@Override
	@Transactional
	public void deleteSale(Integer id) {
		Sale_VouchakIM sale = saleDAO.getById(id);
		Car_VouchakIM car = sale.getCar();
		car.setCarIsSold("N");
		carDAO.saveOrUpdate(car);
		saleDAO.delete(id);
	}

	@Override
	@Transactional
	public Integer getSummAllSales() {
		Integer summ = 0;
		List<Sale_VouchakIM> saleList = saleDAO.getList();
		for (Sale_VouchakIM sale: saleList)
			summ += sale.getCar().getCarPrice();
		return summ;
	}
}