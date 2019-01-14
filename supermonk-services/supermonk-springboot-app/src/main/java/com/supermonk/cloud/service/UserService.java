package com.supermonk.cloud.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermonk.cloud.DO.UserDO;
import com.supermonk.cloud.entity.UserEntity;
import com.supermonk.cloud.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	private Optional<UserEntity> getUser(String userId) {
		return userRepository.findById(userId);
	}

	public UserDO getUserDO(String userId) {
		Optional<UserEntity> entity = this.getUser(userId);
		return new UserDO(entity);

	}

}
