package com.viinter.dao;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.viinter.exceptions.NoRolesAssignedException;
import com.viinter.exceptions.RoleNotFoundException;
import com.viinter.model.IRole;
import com.viinter.model.Role;


@Repository
public class RoleDAOImpl extends AbstractDao<Role> implements IRoleDAO {

	@Override
	public List<Role> getRoles() throws NoRolesAssignedException {
		List<Role> roles = super.getAll();
		if(null == roles || roles.isEmpty())
			throw new NoRolesAssignedException("Roles not defined");
		return roles;
	}

	@Override
	public IRole getRoleObject(int id) {
		Validate.notNull(id);
		return get(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<IRole> getRolesByIds(Collection<Integer> roleIds) throws RoleNotFoundException {
		Collection<IRole> roles = new ArrayList<IRole>();
		try{
			Criteria crit = getCriteria();
			crit.add(Restrictions.in("roleId", roleIds));
			roles = new ArrayList<IRole> (crit.list());
		}catch(HibernateException e){
			throw new RoleNotFoundException("Role Not Found",roleIds.toString());
		}
		return roles;
	}

}
