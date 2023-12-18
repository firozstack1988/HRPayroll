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
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String empId;
	private String name;
	private String deptName;
	private String emailAddress;
	private String mobileNo;
	private String designation;
	private double basicAmt;
	private String branchCode;
	private String createdBy;
	private Date createdOn;
	private String updatedBy;
	private Date updatedOn;
}
