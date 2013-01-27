package com.autohouse.service;

import java.util.List;

import com.autohouse.domain.Body_VouchakIM;
import com.autohouse.domain.Car_VouchakIM;

public interface CarService_VouchakIM {
	public void                 saveOrUpdateCar(Car_VouchakIM car);
	public List<Car_VouchakIM>  getCarList();
	public Car_VouchakIM        getCarById(Integer id);
	public void                 deleteCar(Car_VouchakIM car);
	public boolean    carIsInDatabase(String vin);
	public List<Car_VouchakIM>  getCarByBrand(String request);
	public List<Body_VouchakIM> getBodyList();
	public Body_VouchakIM       getBodyById(Integer id);
	public Car_VouchakIM        getCarByVin(String request);
}