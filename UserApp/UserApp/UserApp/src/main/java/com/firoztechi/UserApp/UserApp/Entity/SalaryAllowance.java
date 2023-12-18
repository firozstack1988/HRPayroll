package com.firoztechi.UserApp.UserApp.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class SalaryAllowance {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private double houseRent;
	private double medical;
	private double transport;
	private double lunch;
	private double cityAllowance;
	private double providentFund;
	private double creditAllowance;
	private int year;
	private Date createdOn;
	private String createdBy;
	private Date modifyBy;
	private String modifyOn;
}
