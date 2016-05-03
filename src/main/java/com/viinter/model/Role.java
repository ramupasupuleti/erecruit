

package com.viinter.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Table(name = "Roles")
public class Role extends BaseEntity implements Serializable, IRole {

	private static final long serialVersionUID = 4645431283408677443L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROLE_ID")
    private Integer roleId;

    @OneToOne(mappedBy = "role")
    private User user;

	@Column(name = "ROLE_NAME")
    private String name;

    public Role() {
        super();
    }

    public Role(final String name) {
        super();
        this.name = name;
    }

    //

    /* (non-Javadoc)
	 * @see com.viinter.model.IRole#getId()
	 */
    @Override
	public Integer getId() {
        return roleId;
    }

    /* (non-Javadoc)
	 * @see com.viinter.model.IRole#setId(java.lang.Long)
	 */
    @Override
	public void setId(final Integer roleId) {
        this.roleId = roleId;
    }

    /* (non-Javadoc)
	 * @see com.viinter.model.IRole#getName()
	 */
    @Override
	public String getName() {
        return name;
    }

    /* (non-Javadoc)
	 * @see com.viinter.model.IRole#setName(java.lang.String)
	 */
    @Override
	public void setName(final String name) {
        this.name = name;
    }

    @Override
    public User getUser() {
		return user;
	}
    
    @Override
	public void setUser(User user) {
		this.user = user;
	}


    /* (non-Javadoc)
	 * @see com.viinter.model.IRole#hashCode()
	 */
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Role role = (Role) obj;
        if (!role.equals(role.name)) {
            return false;
        }
        return true;
    }

    /* (non-Javadoc)
	 * @see com.viinter.model.IRole#toString()
	 */
	@Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Role [name=").append(name).append("]").append("[id=").append(roleId).append("]");
        return builder.toString();
    }

	
}

