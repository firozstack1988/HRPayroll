package com.firoztechi.UserApp.UserApp.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firoztechi.UserApp.UserApp.Entity.SalaryAllowance;
import com.firoztechi.UserApp.UserApp.Model.ResponseModel;
import com.firoztechi.UserApp.UserApp.Model.SalaryProcess;
import com.firoztechi.UserApp.UserApp.Service.SalaryProcessServiceImpl;
import com.firoztechi.UserApp.UserApp.Utility.AppUtility;

@RestController
@RequestMapping("/salProcess")
public class SalaryProcessController {

	@Autowired
	private SalaryProcessServiceImpl salaryProcessServiceImpl;
	
	@PostMapping("/add")
	public ResponseModel save(@RequestBody SalaryProcess salaryProcess,HttpSession session)throws Exception {
		ResponseModel response=new ResponseModel();
		try {
				Date date=new Date();
				SimpleDateFormat sdf=new SimpleDateFormat("DD-MM-YYYY");
				String st=sdf.format(new Date());
				Date dt=sdf.parse(st);
				salaryProcess.setCreatedOn(date);
				salaryProcessServiceImpl.add(salaryProcess);
				response.setSuccess(AppUtility.SUCCESS_MESSAGE);
		}
		catch(Exception e) {
			response.setErrorMsg(AppUtility.FAILURE_MSG);
			throw new Exception(e.getLocalizedMessage());
		}
	return response;
	}
}
