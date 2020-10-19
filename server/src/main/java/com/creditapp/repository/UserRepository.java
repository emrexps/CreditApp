package com.creditapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creditapp.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByTcno(String tcno);
	
	

}
