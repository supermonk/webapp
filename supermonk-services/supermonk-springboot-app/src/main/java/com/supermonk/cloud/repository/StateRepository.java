package com.supermonk.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supermonk.cloud.entity.StateEntity;

public interface StateRepository extends JpaRepository<StateEntity, String> {

	StateEntity findByAbbrevation(String stateAbbrevation);

}