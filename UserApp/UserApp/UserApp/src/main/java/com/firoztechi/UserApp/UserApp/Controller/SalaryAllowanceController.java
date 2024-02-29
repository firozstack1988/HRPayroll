package com.firoztechi.UserApp.UserApp.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firoztechi.UserApp.UserApp.Entity.SalaryAllowance;
import com.firoztechi.UserApp.UserApp.Entity.Users;
import com.firoztechi.UserApp.UserApp.Model.EmployeeModel;
import com.firoztechi.UserApp.UserApp.Model.ResponseModel;
import com.firoztechi.UserApp.UserApp.Service.SalaryAllowanceService;
import com.firoztechi.UserApp.UserApp.Utility.AppUtility;

@RestController
@RequestMapping("/allowance")
public class SalaryAllowanceController {

	@Autowired
	private SalaryAllowanceService salaryAllowanceService;
	
	@PostMapping("/addAllowance")
	public ResponseModel save(@RequestBody SalaryAllowance salaryAllowance,HttpSession session)throws Exception {
		ResponseModel response=new ResponseModel();
		try {
				Date date=new Date();
				SimpleDateFormat sdf=new SimpleDateFormat("DD-MM-YYYY");
				String st=sdf.format(new Date());
				Date dt=sdf.parse(st);
				salaryAllowance.setCreatedOn(date);
				salaryAllowance.setYear(new Date().getYear());
				salaryAllowanceService.add(salaryAllowance);
				response.setSuccess(AppUtility.SUCCESS_MESSAGE);
		}
		catch(Exception e) {
			response.setErrorMsg(AppUtility.FAILURE_MSG);
			throw new Exception(e.getLocalizedMessage());
		}
	return response;
	}
	
	@GetMapping("/allowanceList")
	public ResponseModel allowanceList()throws Exception {
		ResponseModel response=new ResponseModel();
		try {
			List<SalaryAllowance> allowanceList=salaryAllowanceService.getAllowanceList();
				 response.setSuccess(AppUtility.SUCCESS_MESSAGE);
				 response.setContent(allowanceList);
		}
		catch(Exception e) {
			response.setErrorMsg(AppUtility.FAILURE_MSG);
			throw new Exception(e.getLocalizedMessage());
		}
	return response;
	}
	@GetMapping("/allowanceById/{id}")
	public ResponseModel employeeById(@PathVariable long id)throws Exception {
		ResponseModel response=new ResponseModel();
		try {
		SalaryAllowance allowance=salaryAllowanceService.getAllowance(id);
				 response.setSuccess(AppUtility.SUCCESS_MESSAGE);
				 response.setContent(allowance);
		}
		catch(Exception e) {
			response.setErrorMsg(AppUtility.FAILURE_MSG);
			throw new Exception(e.getLocalizedMessage());
		}
	return response;
	}
}
