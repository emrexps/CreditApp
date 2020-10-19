package com.creditapp.service;

import org.springframework.stereotype.Service;

import com.creditapp.dto.ServiceRequest;
import com.creditapp.dto.ServiceResponse;

@Service
public interface CreditService {
	
	public ServiceResponse checkCredit(ServiceRequest user);




}
