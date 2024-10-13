package com.sai;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;


@Controller
public class CustomerController {

	// add an initBinder to convert trim input strings
	// remove leading and trailing white spaces
	// resolve issue for our validation

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor  trimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class,trimmerEditor);
	}

	@GetMapping("/")
	public String showForm(Model model) {
		model.addAttribute("customer",new Customer());
		return "customer-form";
	}

	@PostMapping("/processform")
	public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult) {
		if(theBindingResult.hasErrors()) {
			return "customer-form";
		}else {
			return "customer-confirmation";
		}
	}

}
