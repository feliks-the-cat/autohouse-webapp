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

import com.autohouse.domain.Car_VouchakIM;
import com.autohouse.service.CarService_VouchakIM;
import com.autohouse.web.validator.CarValidator_VouchakIM;

@Controller
public class CarController_VouchakIM {
	
	@Autowired
	private CarService_VouchakIM carService;
	
	@Autowired
	private CarValidator_VouchakIM carValidator;
	
	@RequestMapping(value = "/CarList")
	public ModelAndView getCarList(@RequestParam(required=false) String request){
		ModelMap modelMap = new ModelMap();
		List<Car_VouchakIM> carList;
		if (request == null || request == "") 
			carList = carService.getCarList();
		else
			carList = carService.getCarByBrand(request);
		modelMap.addAttribute("carList", carList);
		return new ModelAndView("car_list", modelMap);
	}
	
	@RequestMapping(value = "/CarAdd", method = RequestMethod.POST) 
	public String saveOrUpdateCar(@ModelAttribute("car") Car_VouchakIM car, BindingResult result, Model model) {   
		carValidator.validate(car, result);
		if (result.hasErrors()){
			model.addAttribute("bodyList", carService.getBodyList());
			return "/car_edit";
		}
		Integer bodyId = car.getBody().getBodyId();
		car.setBody(carService.getBodyById(bodyId));
		carService.saveOrUpdateCar(car);  
		return "redirect:/CarList";
	}
	
	@RequestMapping(value = "/CarUpdate", method = RequestMethod.GET) 
	public String updateCustomer(@RequestParam Integer id, Model model) {
		Car_VouchakIM car = carService.getCarById(id);
		model.addAttribute("car", car);
		model.addAttribute("bodyList", carService.getBodyList());
		return "/car_edit";
	}
}