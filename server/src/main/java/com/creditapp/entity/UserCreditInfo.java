package com.creditapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserCreditInfo  extends BaseEntity {

	
	@Id
	@GeneratedValue
	private Long creditId;

	@Column
	private Integer creditScore;
	@Column
	private Double creditLimit;

	
	
	
	
	
}
