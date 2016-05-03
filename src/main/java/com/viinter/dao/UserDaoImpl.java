package com.viinter.dao;

import org.springframework.stereotype.Repository;

import com.viinter.model.IUser;
import com.viinter.model.User;

@Repository
public class UserDaoImpl extends AbstractDao<User> implements IUserDao{

	@Override
	public void createNewUser(IUser user) {
		saveOrUpdate((User)user);
	}
	
}
