package com.supermonk.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supermonk.cloud.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {

}
