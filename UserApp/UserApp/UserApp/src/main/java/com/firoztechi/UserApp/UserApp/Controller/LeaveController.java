package com.firoztechi.UserApp.UserApp.Controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firoztechi.UserApp.UserApp.Entity.Employee;
import com.firoztechi.UserApp.UserApp.Entity.LeaveEntry;
import com.firoztechi.UserApp.UserApp.Model.ResponseModel;
import com.firoztechi.UserApp.UserApp.Service.EmployeeService;
import com.firoztechi.UserApp.UserApp.Service.LeaveService;
import com.firoztechi.UserApp.UserApp.Utility.AppUtility;

@RestController
@RequestMapping("/leaves")
public class LeaveController {

	@Autowired
	private LeaveService leaveService;
	
	@PostMapping("/addLeave")
	public ResponseModel saveLeave(@RequestBody LeaveEntry leave,HttpSession session)throws Exception {
		ResponseModel response=new ResponseModel();
		try { 
			     leave.setCreatedOn(new Date());
				 leave.setCreatedBy("");
				 leaveService.add(leave);
				 response.setSuccess(AppUtility.SUCCESS_MESSAGE);
		}
		catch(Exception e) {
			response.setErrorMsg(AppUtility.FAILURE_MSG);
			throw new Exception(e.getLocalizedMessage());
		}
	return response;
	}
}
