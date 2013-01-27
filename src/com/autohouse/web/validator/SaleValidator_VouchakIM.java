package com.autohouse.web.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.autohouse.domain.Sale_VouchakIM;

@Component
public class SaleValidator_VouchakIM implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Sale_VouchakIM.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Sale_VouchakIM sale = (Sale_VouchakIM) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "salePlace", "place.requied");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "saleDate",  "date.requied");
		if(sale.getCustomer() == null)
			errors.rejectValue("customer", "customer.requied");
		else
			if (sale.getCustomer().getCustomerId() == 0)
				errors.rejectValue("customer", "customer.requied");
	}
}