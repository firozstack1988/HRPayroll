package com.firoztechi.UserApp.UserApp.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

import com.firoztechi.UserApp.UserApp.Entity.BranchConfig;
import com.firoztechi.UserApp.UserApp.Entity.Employee;
import com.firoztechi.UserApp.UserApp.Entity.Holidays;
import com.firoztechi.UserApp.UserApp.Entity.LeaveEntry;
import com.firoztechi.UserApp.UserApp.Entity.SalaryAllowance;
import com.firoztechi.UserApp.UserApp.Model.SalaryProcess;
import com.firoztechi.UserApp.UserApp.Repository.BranchConfigRepository;
import com.firoztechi.UserApp.UserApp.Repository.EmployeeRepository;
import com.firoztechi.UserApp.UserApp.Repository.HolidaysRepository;
import com.firoztechi.UserApp.UserApp.Repository.LeaveRpository;
import com.firoztechi.UserApp.UserApp.Repository.SalaryAllowanceRepository;
import com.firoztechi.UserApp.UserApp.Repository.SalaryProcessRepository;

@Service
public class SalaryProcessServiceImpl implements SalaryProcessService{

	@Autowired
	private SalaryAllowanceRepository salaryAllowanceRepository; 
	@Autowired
	private LeaveRpository leaveRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private HolidaysRepository holidaysRepository;
	@Autowired
	private BranchConfigRepository branchConfigRepository;
	@Autowired
	private SalaryProcessRepository salaryProcessRepository;
	
	@Override
	public void add(SalaryProcess salaryProcess) throws Exception {
		try {
			
		    List<Employee>empList=employeeRepository.findAll();
		    empList.forEach(p->{
		    int  totalLeave=leaveRepository.getEmpLeaveByempId(p.getEmpId());
		    SalaryAllowance allowance=salaryAllowanceRepository.getSalaryAllowanceByYear(salaryProcess.getYear()); 
		    salaryProcess.setEmpId(p.getEmpId());
		    salaryProcess.setEmpName(p.getName());
		    salaryProcess.setBasicAmt(p.getBasicAmt());
		    double houseRent=p.getBasicAmt()*(allowance.getHouseRent()/100);
		    salaryProcess.setHouseRentAmt(houseRent);
		    double medial=p.getBasicAmt()*(allowance.getMedical()/100);
		    salaryProcess.setMedicalAllowanceAmt(medial);
		    double transport=p.getBasicAmt()*(allowance.getTransport()/100);
		    salaryProcess.setTransportAllowance(transport);
		    double lunchAmt=0;
			try {
				lunchAmt = calculateLunch(totalLeave,salaryProcess.getMonth(),allowance.getLunch());
			} catch (Exception e) {
			}
		    salaryProcess.setLunchAmt(lunchAmt);
		    String brnLocation="";
		    try {
			   brnLocation=branchLocation(p.getBranchCode());
		      } catch (Exception e) {
			   e.printStackTrace();
		     }
		   if(brnLocation.equalsIgnoreCase("City")) 
			   salaryProcess.setCityAllowanceAmt(allowance.getCityAllowance());  
		   else 
			   salaryProcess.setCityAllowanceAmt(0);
		   
		    salaryProcess.setCreditAllowanceAmt(allowance.getCreditAllowance());
		    double pfAmt=p.getBasicAmt()*(allowance.getProvidentFund()/100);
		    salaryProcess.setProvidentFundAmt(pfAmt);
		    double grossAmt=p.getBasicAmt()+houseRent+medial+transport+lunchAmt+allowance.getCityAllowance()+allowance.getCreditAllowance();
		    salaryProcess.setGrossSalary(grossAmt);
		    salaryProcess.setCreatedBy("");
		    salaryProcess.setCreatedOn(new Date());
		    salaryProcessRepository.save(salaryProcess);
		    });
		}
		catch(Exception e) {
			throw new Exception(e.getLocalizedMessage());
		}
		
	}
	private String branchLocation(String brnCode) throws Exception{
		String brnLocation="";
		try {
			BranchConfig branchConfig=branchConfigRepository.getBranchConfigByBranchCode(brnCode);
			brnLocation=branchConfig.getBranchLocation();
		}
		catch(Exception e) {
			throw new Exception(e.getLocalizedMessage());
		}
		return brnLocation;
	}
   private double calculateLunch(int totalLeave,String month,double lunchAmt) throws Exception{
	   double lunchAllowance=0;
	   try {
		  Holidays holiday=holidaysRepository.getHolidaysByMonth(month);
		  int monthlyLoeave=holiday.getNumberOfHoliday();
		  if(month.equalsIgnoreCase("January")||month.equalsIgnoreCase("March")||month.equalsIgnoreCase("May")
		  ||month.equalsIgnoreCase("July")|| month.equalsIgnoreCase("August")||month.equalsIgnoreCase("October")
		  ||month.equalsIgnoreCase("December")) {
		  int totalWorkingDays=31-(monthlyLoeave+totalLeave);
		  lunchAllowance=totalWorkingDays*lunchAmt;
		  } 
		  else if(month.equalsIgnoreCase("February")) {
			  int totalWorkingDays=28-(monthlyLoeave+totalLeave);
			  lunchAllowance=totalWorkingDays*lunchAmt;  
		  }
		  else {
			  int totalWorkingDays=30-(monthlyLoeave+totalLeave);
			  lunchAllowance=totalWorkingDays*lunchAmt;
		  }
	  } 
	  catch(Exception e) {
		  throw new Exception(e.getLocalizedMessage());
	  }
	   return lunchAllowance;
	   
   }
}
