package com.viinter.controller;

import javax.validation.Valid;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.viinter.SecurityConfiguration;
import com.viinter.constants.Pages;
import com.viinter.forms.RegistrationForm;

@Controller
public class RecruitmentController {
	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfiguration.class);

	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView welcome(@Valid RegistrationForm registrationForm) {
		LOGGER.debug("Returning Registration::{}", Pages.valueOf("Registration"));
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName(Pages.Registration.name());
		return modelView;
	}

	@RequestMapping(value="/registration", method = RequestMethod.POST)
	public ModelAndView registration(@Valid RegistrationForm registrationForm, BindingResult result) {
		try{
			ModelAndView model = new ModelAndView();
			Validate.notNull(registrationForm);
			if(result.hasErrors()){
				LOGGER.error("Total errors: {}", result.getErrorCount());
				model.setViewName(Pages.Registration.name());
				return model;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;

	}
}
