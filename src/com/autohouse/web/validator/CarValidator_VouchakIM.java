package com.autohouse.web.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

import com.autohouse.domain.Car_VouchakIM;
import com.autohouse.service.CarService_VouchakIM;

@Component
public class CarValidator_VouchakIM implements Validator{
	
	@Autowired
	private CarService_VouchakIM carService;

	@Override
	public boolean supports(Class<?> clazz) { 
		return clazz.equals(Car_VouchakIM.class); 
	}

	@Override 
	public void validate(Object obj, Errors errors) {
		Car_VouchakIM car = (Car_VouchakIM) obj;
		String  carVin = car.getCarVin();
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "carBrand",    "brand.requied");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "carModel",    "model.requied");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "carYear",     "year.requied");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "carMileage",  "mileage.requied");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "carPrice",    "price.requied");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "carVin",      "vin.requied");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "carCapacity", "capacity.requied");
		if(car.getBody() == null)
			errors.rejectValue("body", "body.requied");
		else
			if (car.getBody().getBodyId() == 0)
				errors.rejectValue("body", "body.requied");
		if (carVin != null)
			if (carVin.trim() != "")
				if (carService.carIsInDatabase(carVin))
					if (car.getCarId() == null)
						errors.rejectValue("carVin", "car.duplicated");
	}
}