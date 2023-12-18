package com.firoztechi.UserApp.UserApp.Controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firoztechi.UserApp.UserApp.Entity.BranchConfig;
import com.firoztechi.UserApp.UserApp.Entity.Employee;
import com.firoztechi.UserApp.UserApp.Model.ResponseModel;
import com.firoztechi.UserApp.UserApp.Service.BranchConfigService;
import com.firoztechi.UserApp.UserApp.Service.EmployeeService;
import com.firoztechi.UserApp.UserApp.Utility.AppUtility;

@RestController
@RequestMapping("/brnConfig")
public class BranchConfigController {

	@Autowired
	private BranchConfigService branchConfigService;
	
	@PostMapping("/addBranch")
	public ResponseModel saveUser(@RequestBody BranchConfig branchConfig,HttpSession session)throws Exception {
		ResponseModel response=new ResponseModel();
		try {     
			branchConfig.setCreatedBy("");
			branchConfig.setCreatedOn(new Date());
			branchConfigService.add(branchConfig);
			response.setSuccess(AppUtility.SUCCESS_MESSAGE);
		}
		catch(Exception e) {
			response.setErrorMsg(AppUtility.FAILURE_MSG);
			throw new Exception(e.getLocalizedMessage());
		}
	return response;
	}
}
