package com.autohouse.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.autohouse.domain.Customer_VouchakIM;
import com.autohouse.service.CustomerService_VouchakIM;
import com.autohouse.service.SaleService_VouchakIM;

@Controller
public class CustomerSalesController_VouchakIM {
	@Autowired
	public CustomerService_VouchakIM customerService;
	
	@Autowired
	public SaleService_VouchakIM saleService;
	
	@RequestMapping(value = "/CustomerSales", method = RequestMethod.GET)
	public String listCustomerSales(@RequestParam Integer id, Model model) {
		Customer_VouchakIM customer = customerService.getCustomerById(id);
		
		model.addAttribute("customer", customer);
		model.addAttribute("customerSales", saleService.getCustomerSalesByCustomerId(customer));
		return "/customer_sales";
	}
	
	@RequestMapping(value = "/DealPrint", method = RequestMethod.GET)
	public String printDeal(@RequestParam Integer id, Model model) {
		model.addAttribute("deal", saleService.getSaleById(id));
		return "/deal_print";
	}
	
	@RequestMapping(value = "/DealDelete", method = RequestMethod.GET)
	public String deleteDeal(@RequestParam Integer id, Model model) {
		saleService.deleteSale(id);
		return "redirect:/CustomerList";
	}
}