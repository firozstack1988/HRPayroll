package com.firoztechi.UserApp.UserApp.Controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firoztechi.UserApp.UserApp.Entity.BranchConfig;
import com.firoztechi.UserApp.UserApp.Entity.EmpTransfer;
import com.firoztechi.UserApp.UserApp.Model.ResponseModel;
import com.firoztechi.UserApp.UserApp.Service.BranchConfigService;
import com.firoztechi.UserApp.UserApp.Service.EmpTransferService;
import com.firoztechi.UserApp.UserApp.Utility.AppUtility;

@RestController
@RequestMapping("/empTransfer")
public class EmpTransferController {

	@Autowired
	private EmpTransferService empTransferService;
	
	@PostMapping("/addTransfer")
	public ResponseModel add(@RequestBody EmpTransfer empTransfer,HttpSession session)throws Exception {
		ResponseModel response=new ResponseModel();
		try {     
			empTransfer.setCreatedBy("");
			empTransfer.setCreatedOn(new Date());
			empTransferService.add(empTransfer);
			response.setSuccess(AppUtility.SUCCESS_MESSAGE);
		}
		catch(Exception e) {
			response.setErrorMsg(AppUtility.FAILURE_MSG);
			throw new Exception(e.getLocalizedMessage());
		}
	return response;
	}
}
