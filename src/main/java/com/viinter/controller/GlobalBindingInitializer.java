package com.viinter.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.viinter.forms.IRegistrationForm;

@ControllerAdvice
public class GlobalBindingInitializer {
	
	@ModelAttribute("RegistrationForm")
	public IRegistrationForm RegistrationForm(){
		return new com.viinter.forms.RegistrationForm();
	}
	

}
