package com.supermonk.cloud.DO;

import java.util.Optional;

import com.supermonk.cloud.entity.UserEntity;

public class UserDO {

	private String firstName;
	private String lastName;
	
	public UserDO() {
		this.setFirstName("");
		this.setLastName("");
	}

	public UserDO(Optional<UserEntity> entity) {
		this();
		if (entity.isPresent()) {
			this.setFirstName(entity.get().getFirstName());
			this.setLastName(entity.get().getLastName());
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
