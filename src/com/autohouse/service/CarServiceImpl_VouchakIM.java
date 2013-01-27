package com.autohouse.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.autohouse.dao.GenericDAO_VouchakIM;
import com.autohouse.domain.Body_VouchakIM;
import com.autohouse.domain.Car_VouchakIM;

@Transactional
public class CarServiceImpl_VouchakIM implements CarService_VouchakIM {

	public GenericDAO_VouchakIM<Car_VouchakIM> carDAO;
	
	public void setCarDAO(GenericDAO_VouchakIM<Car_VouchakIM> carDAO) {
		this.carDAO = carDAO;
	}

	public GenericDAO_VouchakIM<Body_VouchakIM> bodyDAO;
	
	public void setBodyDAO(GenericDAO_VouchakIM<Body_VouchakIM> bodyDAO) {
		this.bodyDAO = bodyDAO;
	}
	
	@Override
	@Transactional
	public void saveOrUpdateCar(Car_VouchakIM car) {
		if (car.getCarIsSold().equals(""))
			car.setCarIsSold("N");
		carDAO.saveOrUpdate(car);
	} 

	@Override
	@Transactional
	public List<Car_VouchakIM> getCarList() {
		return carDAO.getByObject("carIsSold", "N");
	}

	@Override
	@Transactional
	public Car_VouchakIM getCarById(Integer id) {
		return carDAO.getById(id);
	}

	@Override
	@Transactional
	public void deleteCar(Car_VouchakIM car) {
		carDAO.delete(car.getCarId());
	}

	@Override
	@Transactional
	public boolean carIsInDatabase(String vin) {
		return carDAO.findByParam("carVin", vin).size() > 0;
	}
	@Override
	@Transactional
	public List<Car_VouchakIM> getCarByBrand(String request) {
		return carDAO.getByObject("carBrand", request);
	}

	@Override
	@Transactional
	public List<Body_VouchakIM> getBodyList() {
		return bodyDAO.getList();
	}

	@Override
	@Transactional
	public Body_VouchakIM getBodyById(Integer id) {
		return bodyDAO.getById(id);
	}

	@Override
	@Transactional
	public Car_VouchakIM getCarByVin(String request) {
		List<Car_VouchakIM> temp = carDAO.findByParam("carVin", request);
		if (temp.size() == 1)
			return temp.get(0);
		else
			return null; 
	}
}