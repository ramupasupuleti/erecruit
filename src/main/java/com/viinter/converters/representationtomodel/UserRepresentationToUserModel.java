package com.viinter.converters.representationtomodel;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.viinter.dao.IRoleDAO;
import com.viinter.model.IRole;
import com.viinter.model.IUser;
import com.viinter.model.Role;
import com.viinter.representations.IUserBusinessModel;

@Component
public class UserRepresentationToUserModel extends BaseConverter<IUserBusinessModel, IUser> {
	
	private PasswordEncoder passwordEncoder;
	
	private ObjectFactory<IUser> userFactory;
	
	private IRoleDAO roleDAO;
	
	
	@Autowired
	public void setRoleDAO(IRoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	@Autowired
	public void setUserFactory(ObjectFactory<IUser> userFactory) {
		this.userFactory = userFactory;
	}


	@Autowired
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public IUser convert(IUserBusinessModel source) {
		IUser user = userFactory.getObject();
		user = super.convert(source);
		//Setting password?? TODO: Can we move this service layer??
		user.setPassword(passwordEncoder.encode(source.getPassword()));
		//TODO:add roles, by default role ID is participant, will check how Role is selected in UI screen
		IRole role = null;
			role = roleDAO.getRoleObject(2);
		user.setRole((Role)role);
		return user; 
	}

}
