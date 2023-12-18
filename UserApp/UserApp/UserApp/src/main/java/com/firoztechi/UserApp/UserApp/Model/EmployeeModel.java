package com.firoztechi.UserApp.UserApp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {
	private String empId;
	private String name;
	private String deptName;
	private String emailAddress;
	private String mobileNo;
	private String designation;
}
