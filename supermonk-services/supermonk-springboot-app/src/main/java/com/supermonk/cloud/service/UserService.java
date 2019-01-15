package com.supermonk.cloud.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermonk.cloud.DO.UserDO;
import com.supermonk.cloud.entity.AddressEntity;
import com.supermonk.cloud.entity.StateEntity;
import com.supermonk.cloud.entity.UserEntity;
import com.supermonk.cloud.repository.AddressRepository;
import com.supermonk.cloud.repository.StateRepository;
import com.supermonk.cloud.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private AddressRepository addressRepository;

	private Optional<UserEntity> getUser(String userId) {
		return userRepository.findById(userId);
	}

	public UserDO getUserDO(String userId) {
		Optional<UserEntity> entity = this.getUser(userId);
		return new UserDO(entity);

	}

	public String addUserDO(UserDO user) {
		StateEntity stateEntity = stateRepository.findByAbbrevation(user.getStateAbbrevation());

		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setAddress1(user.getAddress1());
		addressEntity.setAddress2(user.getAddress2());
		addressEntity.setStateEntity(stateEntity);
		addressRepository.save(addressEntity);

		UserEntity usrentity = new UserEntity();
		usrentity.setAddressEntity(addressEntity);
		usrentity.setFirstName(user.getFirstName());
		usrentity.setLastName(user.getLastName());

		UserEntity entity = userRepository.save(usrentity);
		return entity.getUserId();

	}

}
