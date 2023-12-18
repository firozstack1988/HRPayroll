package com.firoztechi.UserApp.UserApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firoztechi.UserApp.UserApp.Entity.SalaryAllowance;
import com.firoztechi.UserApp.UserApp.Repository.SalaryAllowanceRepository;
@Service
public class SalaryAllowanceServiceImpl implements SalaryAllowanceService{
   @Autowired
   private SalaryAllowanceRepository salaryAllowanceRepository;
	
   @Override
	public void add(SalaryAllowance salaryAllowance) throws Exception {
		
		try {
			salaryAllowanceRepository.save(salaryAllowance);
		}
		catch(Exception e) {
			throw new Exception(e.getLocalizedMessage());
		}
	}

}
