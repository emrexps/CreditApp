package com.creditapp;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.creditapp.entity.User;
import com.creditapp.entity.UserCreditInfo;
import com.creditapp.repository.UserRepository;

@SpringBootApplication
public class CreditAppServerApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(CreditAppServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		UserCreditInfo trumpCredit = UserCreditInfo.builder().creditLimit(5000.0).creditScore(0).build();

		User trump = User.builder().username("Donald").lastname("Trump").salary(600.4).tcno("12345678901")
				.userCredit(trumpCredit).build();

		UserCreditInfo bidenCredit = UserCreditInfo.builder().creditLimit(400.0).creditScore(2000).build();

		User biden = User.builder().username("Joe").lastname("Biden").salary(500.5).tcno("12345678903")
				.userCredit(bidenCredit).build();

		userRepository.save(trump);
		userRepository.save(biden);
	}

}
