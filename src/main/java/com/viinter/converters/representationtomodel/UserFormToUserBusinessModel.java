package com.viinter.converters.representationtomodel;

import org.springframework.stereotype.Component;

import com.viinter.forms.IRegistrationForm;
import com.viinter.representations.IUserBusinessModel;

@Component
public class UserFormToUserBusinessModel extends BaseConverter<IRegistrationForm, IUserBusinessModel> {
	
	@Override
	public IUserBusinessModel convert(IRegistrationForm source) {
		// TODO Auto-generated method stub
		return super.convert(source);
	}
	
	

}
