package com.firoztechi.UserApp.UserApp.Controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firoztechi.UserApp.UserApp.Entity.BranchConfig;
import com.firoztechi.UserApp.UserApp.Entity.FundTransfer;
import com.firoztechi.UserApp.UserApp.Model.ResponseModel;
import com.firoztechi.UserApp.UserApp.Model.ValidationResponse;
import com.firoztechi.UserApp.UserApp.Service.BranchConfigService;
import com.firoztechi.UserApp.UserApp.Service.FundTransferService;
import com.firoztechi.UserApp.UserApp.Utility.AppUtility;

@RestController
@RequestMapping("/fundTransfer")
public class FundTransferController {

	@Autowired
	private FundTransferService fundTransferService;
	
	@PostMapping("/amtTransfer")
	public ResponseModel saveUser(@RequestBody FundTransfer fundTransfer,HttpSession session)throws Exception {
		ResponseModel response=new ResponseModel();
		try {     
			fundTransfer.setCreatedBy("");
			fundTransfer.setCreatedOn(new Date());
			fundTransferService.add(fundTransfer);
			response.setSuccess(AppUtility.SUCCESS_MESSAGE);
		}
		catch(Exception e) {
			response.setErrorMsg(e.getLocalizedMessage());
		}
	return response;
	}
	
	@GetMapping("/getAvailBal/{debitAcc}")
	public ResponseModel getAvailBal(@PathVariable String debitAcc)throws Exception {
		ResponseModel response=new ResponseModel();
		try {     
		  double  debitAccAvailBal=fundTransferService.getAvailBal(Long.parseLong(debitAcc));
		  response.setAvailBal(String.valueOf(debitAccAvailBal));
		}
		catch(Exception e) {
			throw new Exception(e.getLocalizedMessage());
		}
 	  return response;
	}
	
}
