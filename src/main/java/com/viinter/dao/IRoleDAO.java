package com.viinter.dao;


import java.util.Collection;
import java.util.List;

import com.viinter.exceptions.NoRolesAssignedException;
import com.viinter.exceptions.RoleNotFoundException;
import com.viinter.model.IRole;
import com.viinter.model.Role;



public interface IRoleDAO extends IBaseDao<Role> {
	List<Role> getRoles() throws NoRolesAssignedException;
	IRole getRoleObject(int id);
	Collection<IRole> getRolesByIds(Collection<Integer> roleIds) throws RoleNotFoundException;
	
}
