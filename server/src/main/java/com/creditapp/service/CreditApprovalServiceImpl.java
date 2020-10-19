package com.creditapp.service;

import org.springframework.stereotype.Component;

import com.creditapp.dto.CreditApprovalType;
import com.creditapp.dto.ServiceResponse;
import com.creditapp.entity.User;
import com.creditapp.entity.UserCreditInfo;
@Component
public class CreditApprovalServiceImpl implements CreditApprovalService{

	public  ServiceResponse ifCreditScoreLessThanHundred(User user) {

		ServiceResponse serviceResponse = new ServiceResponse();
		serviceResponse.setStatus(CreditApprovalType.APPROVED);
		serviceResponse.setName(user.getUsername());
		serviceResponse.setCredit(10000.0);
		serviceResponse.setCreditLimit(1000.0);
		return serviceResponse;

	}
	
	public  ServiceResponse ifCreditScoreBiggerThanHundred(User user, UserCreditInfo creditInfo) {

		ServiceResponse serviceResponse = new ServiceResponse();
		serviceResponse.setStatus(CreditApprovalType.APPROVED);
		serviceResponse.setName(user.getUsername());
		serviceResponse.setCreditLimit(creditInfo.getCreditLimit());
		serviceResponse.setCredit(creditInfo.getCreditLimit());
		return serviceResponse;

	}

	public  ServiceResponse ifCreditScoreInadequate(User user) {

		ServiceResponse serviceResponse = new ServiceResponse();
		serviceResponse.setStatus(CreditApprovalType.REJECTED);
		serviceResponse.setName(user.getUsername());
		return serviceResponse;

	}

}
