package com.firoztechi.UserApp.UserApp.Model;

import java.io.Serializable;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaryProcessCompositId implements Serializable{
 
	private Long id;
	private String empId;
	private String month;
	private int year;
}
