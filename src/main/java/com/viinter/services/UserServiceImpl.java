package com.viinter.services;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viinter.converters.representationtomodel.UserRepresentationToUserModel;
import com.viinter.dao.IUserDao;
import com.viinter.model.IUser;
import com.viinter.representations.IUserBusinessModel;

@Service
public class UserServiceImpl implements IUserService {
	
	private IUserDao userDao;
	
	private ObjectFactory<IUser> userFactory;
	
	private UserRepresentationToUserModel representationToUserModel;
	
	
	@Autowired
	public void setUserFactory(ObjectFactory<IUser> userFactory) {
		this.userFactory = userFactory;
	}
	
	@Autowired
	public void setRepresentationToUserModel(UserRepresentationToUserModel representationToUserModel) {
		this.representationToUserModel = representationToUserModel;
	}
	
	@Autowired
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public int createNewUser(IUserBusinessModel userDetails) {
		//Convert business to Model object
		IUser userModel = userFactory.getObject();
		representationToUserModel.setFactoryObject(userModel);
		userModel = representationToUserModel.convert(userDetails);
		userDao.createNewUser(userModel);
		return userDetails.getUserId();
	}

}
