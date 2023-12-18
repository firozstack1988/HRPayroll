package com.firoztechi.UserApp.UserApp.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(SalaryProcessCompositId.class)
public class SalaryProcess {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Id
	private int year;
	@Id
	private String month;
	@Id
	private String empId;
	private String empName;
	private double basicAmt;
	private double houseRentAmt;
	private double medicalAllowanceAmt;
	private double transportAllowance;
	private double lunchAmt;
	private double cityAllowanceAmt;
	private double creditAllowanceAmt;
	private double providentFundAmt;
	private double grossSalary;
	private String createdBy;
	private Date createdOn;
}
