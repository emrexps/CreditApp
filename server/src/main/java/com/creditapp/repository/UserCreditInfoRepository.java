package com.creditapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.creditapp.entity.UserCreditInfo;

public interface UserCreditInfoRepository extends JpaRepository<UserCreditInfo, Long> {
	
	


}
