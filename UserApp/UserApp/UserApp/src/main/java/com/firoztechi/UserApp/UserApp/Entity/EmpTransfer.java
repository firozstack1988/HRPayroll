package com.firoztechi.UserApp.UserApp.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class EmpTransfer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String employeeId;
	private String currentBrnName;
	private String transferedBrnName;
	private String designation;
	private String createdBy;
	private Date createdOn;
}
