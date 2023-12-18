package com.firoztechi.UserApp.UserApp.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity
public class BranchConfig {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String branchCode;
	private String branchName;
	private String brnAddressName;
	private String upozila;
	private String district;
	private String branchLocation;
	private String createdBy;
	private Date createdOn;
}
