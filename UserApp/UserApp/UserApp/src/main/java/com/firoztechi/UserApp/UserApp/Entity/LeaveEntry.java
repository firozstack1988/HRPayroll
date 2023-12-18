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

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LeaveEntry {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String employeeId;
	private String leaveType;
	private String leaveReason;
	private Date fromDate;
	private Date toDate;
	private int numberOfDays;
	private String createdBy;
	private Date createdOn;
	private String updatedBy;
	private Date updatedOn;
	
}
