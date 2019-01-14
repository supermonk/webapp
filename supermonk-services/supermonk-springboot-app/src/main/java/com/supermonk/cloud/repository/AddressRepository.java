package com.supermonk.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supermonk.cloud.entity.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, String> {

}
