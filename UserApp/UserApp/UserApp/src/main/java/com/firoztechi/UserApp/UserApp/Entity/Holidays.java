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
public class Holidays {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String month;
	private int numberOfHoliday;
	private int year;
	private String createdBy;
	private Date createdOn;
}
