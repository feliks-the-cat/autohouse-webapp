package com.autohouse.web.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

import com.autohouse.domain.Customer_VouchakIM;
import com.autohouse.service.CustomerService_VouchakIM;

@Component
public class CustomerValidator_VouchakIM implements Validator{
	
	@Autowired
	private CustomerService_VouchakIM customerService;

	@Override
	public boolean supports(Class<?> clazz) { 
		return clazz.equals(Customer_VouchakIM.class); 
	}

	@Override 
	public void validate(Object obj, Errors errors) {
		Customer_VouchakIM customer = (Customer_VouchakIM) obj;
		String  passportNo = customer.getCustomerPassportNumber();
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerFio",            "fio.requied");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerAddress",        "address.requied");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerPassportNumber", "passport.requied");
		
		if (passportNo != null)
			if (passportNo.trim() != "")
				if (customerService.passportIsInDatabase(passportNo))
					if (customer.getCustomerId() == null)
						errors.rejectValue("customerPassportNumber", "passport.duplicated");
	}
}