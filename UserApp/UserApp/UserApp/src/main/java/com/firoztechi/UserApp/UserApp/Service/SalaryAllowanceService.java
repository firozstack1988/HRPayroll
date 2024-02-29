package com.firoztechi.UserApp.UserApp.Service;

import java.util.List;

import com.firoztechi.UserApp.UserApp.Entity.SalaryAllowance;

public interface SalaryAllowanceService {

	public void add(SalaryAllowance salaryAllowance)throws Exception;
	public List<SalaryAllowance> getAllowanceList() throws Exception;
	public SalaryAllowance getAllowance(long id) throws Exception;
	
}
