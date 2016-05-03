package com.viinter.model;

import java.util.Date;

 public interface IBaseEntity {
	 
	 void setLastUpdateOn(Date lastUpdateOn);
	 
	 Date getLastUpdateOn();
	 
	 Date getCreatedOn();
	 
	 void setCreatedOn(Date createdOn);

}
