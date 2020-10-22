package com.creditapp.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.creditapp.constant.CreditConstants;
import com.creditapp.dto.ServiceRequest;
import com.creditapp.dto.ServiceResponse;
import com.creditapp.entity.User;
import com.creditapp.entity.UserCreditInfo;
import com.creditapp.repository.UserRepository;

@Component
@Transactional
public class CreditServiceImpl implements CreditService {

	
	private UserRepository userRepository;
	private  CreditApprovalService creditApprovalService;
	private SMSservice smsService;
	
	//Injection
	public CreditServiceImpl( UserRepository  userRepository,CreditApprovalService creditApprovalService,SMSservice smsService ) {
		this.userRepository=userRepository;
		this.creditApprovalService=creditApprovalService;	
		this.smsService=smsService;
	}
	
	
	@Override
	public ServiceResponse checkCredit(ServiceRequest cuser) {

		ServiceResponse serviceResponse=new ServiceResponse();
		User user = userRepository.findByTcno(cuser.getTcno());
        UserCreditInfo creditUser = user.getUserCredit();
	    
        	//Kredi skoru 500’ün altında ise kullanıcı reddedilir.
			if (creditUser.getCreditScore() < 500) {
				return creditApprovalService.ifCreditScoreInadequate(user);
			} 
			else {
             //Kredi skoru 500 puan ile 1000 puan arasında ise ve aylık geliri 5000 TL’nin altındaise kullanıcının kred başvurusu onaylanır ve kullanıcıya 10.000 TL limit atanır
			
				
				if (creditUser.getCreditScore() > 500 && creditUser.getCreditScore() < 1000) {
					creditUser.setCreditLimit(10000.0);
					serviceResponse= creditApprovalService.ifCreditScoreLessThanHundred(user);
				}
                //Kredi skoru 1000 puana eşit veya üzerinde ise kullanıcıya AYLIK GELİR BİLGİSİ *KREDİ LİMİT ÇARPANI kadar limit atanır
				if (creditUser.getCreditScore() > 1000) {
					creditUser.setCreditLimit(user.getSalary()*CreditConstants.CREDITLIMITFACTOR);
					serviceResponse= creditApprovalService.ifCreditScoreBiggerThanHundred(user, creditUser);
				}
			}
		//Krediyi kaydet
		userRepository.save(user);
		
		//sms gönder
		smsService.sendSms("sms sended");
		
		return serviceResponse;

	}

	
}
