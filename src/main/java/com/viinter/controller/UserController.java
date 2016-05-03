package com.viinter.controller;



import javax.validation.Valid;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.viinter.constants.Pages;
import com.viinter.converters.representationtomodel.UserFormToUserBusinessModel;
import com.viinter.forms.RegistrationForm;
import com.viinter.representations.IUserBusinessModel;
import com.viinter.services.IUserService;

@RestController
@RequestMapping(value="/user")
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	//ObjectFactories
	private ObjectFactory<IUserBusinessModel> userBusinessModelFactory;
	
	
	


	//Services
	private IUserService userService;

	//converters
	private UserFormToUserBusinessModel userFormToBusinesModel;

	@Autowired
	public void setUserFormToBusinesModel(UserFormToUserBusinessModel userFormToBusinesModel) {
		this.userFormToBusinesModel = userFormToBusinesModel;
	}

	@Autowired
	public void setUserBusinessModelFactory(ObjectFactory<IUserBusinessModel> userBusinessModelFactory) {
		this.userBusinessModelFactory = userBusinessModelFactory;
	}

	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}


	@RequestMapping(value="/register", method = RequestMethod.POST)
	public ModelAndView registerUser(@Valid RegistrationForm registrationForm, BindingResult result){
		try{
			ModelAndView model = new ModelAndView();
			Validate.notNull(registrationForm);
			if(result.hasErrors()){
				LOGGER.error("Total errors: {}", result.getErrorCount());
				model.setViewName(Pages.Registration.name());
				return model;
			}
			IUserBusinessModel userBusinessModel = userBusinessModelFactory.getObject();
     		//converting userForm obj to userBusinesModel obj
			userFormToBusinesModel.setFactoryObject(userBusinessModel);
			userBusinessModel = userFormToBusinesModel.convert(registrationForm);
			int userId = userService.createNewUser(userBusinessModel);
			
		}catch(Exception e){
			e.printStackTrace();
		}
     		
			//Return response based on view
		return null;
	}

}
