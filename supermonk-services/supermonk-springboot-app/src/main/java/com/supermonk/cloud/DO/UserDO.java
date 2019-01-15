package com.supermonk.cloud.DO;

import java.util.Optional;

import com.supermonk.cloud.entity.UserEntity;

public class UserDO {

	private String firstName;
	private String lastName; 
	private String address1; 
	private String address2;
	private String stateAbbrevation;
	
	
	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getStateAbbrevation() {
		return stateAbbrevation;
	}

	public void setStateAbbrevation(String stateAbbrevation) {
		this.stateAbbrevation = stateAbbrevation;
	}

	public UserDO() {
		this.setFirstName("");
		this.setLastName("");
	}

	public UserDO(Optional<UserEntity> entity) {
		this();
		if (entity.isPresent()) {
			this.setFirstName(entity.get().getFirstName());
			this.setLastName(entity.get().getLastName());
			this.setAddress1(entity.get().getAddressEntity().getAddress1());
			this.setAddress2(entity.get().getAddressEntity().getAddress2());
			this.setStateAbbrevation(entity.get().getAddressEntity().getStateEntity().getAbbrevation());
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
