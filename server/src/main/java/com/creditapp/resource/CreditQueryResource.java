package com.creditapp.resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creditapp.dto.ServiceRequest;
import com.creditapp.dto.ServiceResponse;
import com.creditapp.service.CreditService;
import com.creditapp.service.CreditServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/api/credit")
public class CreditQueryResource {
	
	private CreditService creditQueryService;
	
	
	public CreditQueryResource(CreditServiceImpl creditQueryService) {
		this.creditQueryService=creditQueryService;
	}
	
	
	@PostMapping("score")
	public ServiceResponse applyCredit(@RequestBody ServiceRequest user)  {
		
		return creditQueryService.checkCredit(user);
		
	}
	

}
