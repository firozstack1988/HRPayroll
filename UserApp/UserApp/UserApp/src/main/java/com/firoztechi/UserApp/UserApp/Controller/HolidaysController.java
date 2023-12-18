package com.firoztechi.UserApp.UserApp.Controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firoztechi.UserApp.UserApp.Entity.EmpTransfer;
import com.firoztechi.UserApp.UserApp.Entity.Holidays;
import com.firoztechi.UserApp.UserApp.Model.ResponseModel;
import com.firoztechi.UserApp.UserApp.Service.EmpTransferService;
import com.firoztechi.UserApp.UserApp.Service.HolidayService;
import com.firoztechi.UserApp.UserApp.Service.HolidayServiceImpl;
import com.firoztechi.UserApp.UserApp.Utility.AppUtility;

@RestController
@RequestMapping("/holiday")
public class HolidaysController {

	@Autowired
	private HolidayService holidayService;
	
	@PostMapping("/addHoliday")
	public ResponseModel add(@RequestBody Holidays holidays)throws Exception {
		ResponseModel response=new ResponseModel();
		try {     
			holidays.setCreatedBy("");
			holidays.setCreatedOn(new Date());
			holidayService.add(holidays);
			response.setSuccess(AppUtility.SUCCESS_MESSAGE);
		}
		catch(Exception e) {
			response.setErrorMsg(AppUtility.FAILURE_MSG);
			throw new Exception(e.getLocalizedMessage());
		}
	return response;
	}
}
