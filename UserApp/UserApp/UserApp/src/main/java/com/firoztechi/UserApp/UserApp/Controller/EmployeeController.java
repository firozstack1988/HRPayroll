package com.firoztechi.UserApp.UserApp.Controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firoztechi.UserApp.UserApp.Entity.Employee;
import com.firoztechi.UserApp.UserApp.Entity.Users;
import com.firoztechi.UserApp.UserApp.Model.EmployeeModel;
import com.firoztechi.UserApp.UserApp.Model.ResponseModel;
import com.firoztechi.UserApp.UserApp.Service.EmployeeService;
import com.firoztechi.UserApp.UserApp.Service.UserServiceImpl;
import com.firoztechi.UserApp.UserApp.Utility.AppUtility;
@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/addEmployee")
	public ResponseModel saveUser(@RequestBody Employee employee,HttpSession session)throws Exception {
		ResponseModel response=new ResponseModel();
		try {
				// String generatedEmpId=employeeService.generateEmpId();
			    // employee.setEmpId(generatedEmpId);
				 employee.setCreatedOn(new Date());
				 employee.setCreatedBy("");
				 employeeService.addEmployee(employee);
				// response.setGeneratedSerial(generatedEmpId);
				 response.setSuccess(AppUtility.SUCCESS_MESSAGE);
		}
		catch(Exception e) {
			response.setErrorMsg(AppUtility.FAILURE_MSG);
			throw new Exception(e.getLocalizedMessage());
		}
	return response;
	}
	
	@GetMapping("/employeeList")
	public ResponseModel employeeList()throws Exception {
		ResponseModel response=new ResponseModel();
		List<EmployeeModel>empList=null;
		try {
			empList=employeeService.getEmployees();
				 response.setSuccess(AppUtility.SUCCESS_MESSAGE);
				 response.setContent(empList);
		}
		catch(Exception e) {
			response.setErrorMsg(AppUtility.FAILURE_MSG);
			throw new Exception(e.getLocalizedMessage());
		}
	return response;
	}
	
	@GetMapping("/employeeById")
	public ResponseModel employeeById(@RequestBody Users users)throws Exception {
		ResponseModel response=new ResponseModel();
		EmployeeModel employeeModel=null;
		try {
			employeeModel=employeeService.getEmployee(users.getLoginUser());
				 response.setSuccess(AppUtility.SUCCESS_MESSAGE);
				 response.setContent(employeeModel);
		}
		catch(Exception e) {
			response.setErrorMsg(AppUtility.FAILURE_MSG);
			throw new Exception(e.getLocalizedMessage());
		}
	return response;
	}
	
	
}
