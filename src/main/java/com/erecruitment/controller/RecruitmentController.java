package com.erecruitment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.erecruitment.SecurityConfiguration;
import com.erecruitment.constants.Pages;

@Controller
public class RecruitmentController {
	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfiguration.class);

	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView welcome() {
		LOGGER.debug("Returning Registration::{}", Pages.valueOf("Registration"));
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName(Pages.Registration.name());
		return modelView;
	}


}
