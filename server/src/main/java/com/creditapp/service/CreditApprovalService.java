package com.creditapp.service;

import org.springframework.stereotype.Service;

import com.creditapp.dto.ServiceResponse;
import com.creditapp.entity.User;
import com.creditapp.entity.UserCreditInfo;
@Service
public interface CreditApprovalService {
	
	public  ServiceResponse ifCreditScoreLessThanHundred(User user);
	
	public  ServiceResponse ifCreditScoreBiggerThanHundred(User user, UserCreditInfo creditInfo);

	public  ServiceResponse ifCreditScoreInadequate(User user);
}
