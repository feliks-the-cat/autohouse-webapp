package com.autohouse.web;

import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.autohouse.domain.Car_VouchakIM;
import com.autohouse.domain.Customer_VouchakIM;
import com.autohouse.domain.Sale_VouchakIM;
import com.autohouse.service.CarService_VouchakIM;
import com.autohouse.service.CustomerService_VouchakIM;
import com.autohouse.service.SaleService_VouchakIM;
import com.autohouse.web.validator.SaleValidator_VouchakIM;

@Controller
public class SaleController_VouchakIM {
	
	@Autowired
	public CustomerService_VouchakIM customerService;
	
	@Autowired
	public CarService_VouchakIM carService;
	
	@Autowired
	public SaleService_VouchakIM saleService;
	
	@Autowired
	public SaleValidator_VouchakIM saleValidator;
	
	@RequestMapping(value = "/CarSale", method = RequestMethod.GET)
	public ModelAndView saleCar(@RequestParam Integer id, Model model){
		ModelMap modelMap = new ModelMap();
		Sale_VouchakIM sale = new Sale_VouchakIM();
		
		Car_VouchakIM car = carService.getCarById(id);
		
		sale.setCar(car);
		sale.setSalePlace("г. Минск");
		
		Date currentDate = new Date();
	    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");
		sale.setSaleDate(dateFormatter.format(currentDate));
		
		modelMap.addAttribute("sale", sale);
		modelMap.addAttribute("carInfo", car);
		modelMap.addAttribute("customerList", customerService.getCustomerList());
		
		return new ModelAndView("car_sale", modelMap);
	}
	
	@RequestMapping(value = "/CarSaleConfirm", method = RequestMethod.POST)
	public String confirmSaleCar(@ModelAttribute("sale") Sale_VouchakIM sale, BindingResult result, Model model){
		saleValidator.validate(sale, result);
		if (result.hasErrors()){
			Integer carId = sale.getCar().getCarId();
			model.addAttribute("carInfo", carService.getCarById(carId));
			model.addAttribute("customerList", customerService.getCustomerList());
			return "/car_sale";
		}
		Car_VouchakIM car = sale.getCar();
		sale.setCar(carService.getCarById(car.getCarId()));
		
		Customer_VouchakIM customer = sale.getCustomer();
		sale.setCustomer(customerService.getCustomerById(customer.getCustomerId()));
		
		saleService.saveOrUpdateSale(sale);
		
		return "redirect:/CarList";
	}
	
	@RequestMapping(value = "/SaleStat")
	public ModelAndView getSaleStat(Model model){
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("saleList", saleService.getSaleList());
		modelMap.addAttribute("sum", saleService.getSummAllSales());
		
		return new ModelAndView("sale_stat", modelMap);		
	}
}