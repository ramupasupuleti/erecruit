package com.viinter.dao;

import com.viinter.model.IUser;
import com.viinter.model.User;

public interface IUserDao extends IBaseDao<User> {
	void createNewUser(IUser user);

}
