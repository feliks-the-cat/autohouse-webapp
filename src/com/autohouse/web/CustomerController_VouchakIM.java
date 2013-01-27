package com.autohouse.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.autohouse.domain.Customer_VouchakIM;
import com.autohouse.service.CustomerService_VouchakIM;
import com.autohouse.web.validator.CustomerValidator_VouchakIM;

@Controller
public class CustomerController_VouchakIM  {
	
	@Autowired
	private CustomerService_VouchakIM customerService;
	
	@Autowired
	private CustomerValidator_VouchakIM customerValidator;
	
	@RequestMapping(value = "/CustomerList") 
	public ModelAndView getCustomerList(@RequestParam(required = false) String request) {
		ModelMap modelMap = new ModelMap();
		List<Customer_VouchakIM> customerList;
		if (request == null || request == "") 
			customerList = customerService.getCustomerList();
		else
			customerList = customerService.getCustomerByPassportNumber(request);
		modelMap.addAttribute("customerList", customerList);
		return new ModelAndView("customer_list", modelMap);
	}
	
	@RequestMapping(value = "/CustomerAdd", method = RequestMethod.POST) 
	public String saveOrUpdateCustomer(@ModelAttribute("customer") Customer_VouchakIM customer, BindingResult result) {   
		customerValidator.validate(customer, result);
		if (result.hasErrors())   
			return "/customer_edit";    
		customerService.saveOrUpdateCustomer(customer);  
		return "redirect:/CustomerList";
	}
	
	@RequestMapping(value = "/CustomerUpdate", method = RequestMethod.GET) 
	public String updateCustomer(@RequestParam Integer id, Model model) {
		Customer_VouchakIM customer = customerService.getCustomerById(id);
		model.addAttribute("customer", customer);
		return "/customer_edit";
	}
}