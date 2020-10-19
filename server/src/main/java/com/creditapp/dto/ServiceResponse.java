package com.creditapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ServiceResponse {
	
	private String name;
	
	private CreditApprovalType status;
	
	private Double credit;
	
	private Double creditLimit;
	

}
